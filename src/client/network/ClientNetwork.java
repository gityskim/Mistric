package client.network;

import client.ui.GameFrame;
import common.GameMsg;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * 객체 직렬화 기반 클라이언트 네트워크 클래스
 * 서버로 GameMsg 객체를 전송하고,
 * 서버에서 GameMsg를 실시간으로 수신한다.
 */
public class ClientNetwork {

    private GameFrame parent;

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    private Thread receiverThread;
    private boolean connected = false;

    public ClientNetwork(GameFrame parent) {
        this.parent = parent;
    }

    // =========================================================
    // 서버 연결
    // =========================================================
    public boolean connect(String ip, int port, String nick) {
        try {
            socket = new Socket(ip, port);

            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());

            connected = true;

            // 로그인 메시지 전송
            GameMsg loginMsg = new GameMsg(GameMsg.LOGIN, nick);
            send(loginMsg);

            startReceiver();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            connected = false;
            return false;
        }
    }

    // =========================================================
    // 메시지 전송
    // =========================================================
    public void send(GameMsg msg) {
        if (!connected) return;
        try {
            out.writeObject(msg);
            out.flush();
        } catch (Exception e) {
            System.out.println("메시지 전송 실패: " + e.getMessage());
        }
    }

    // =========================================================
    // 서버 수신 스레드
    // =========================================================
    private void startReceiver() {
        receiverThread = new Thread(() -> {
            try {
                while (connected) {
                    Object obj = in.readObject();

                    if (obj instanceof GameMsg msg) {
//                        handleMessage(msg);   // 실제 처리
                    }
                }
            } catch (Exception e) {
                System.out.println("서버 연결 종료");
            } finally {
                close();
            }
        });

        receiverThread.setDaemon(true);
        receiverThread.start();
    }
/*
    // =========================================================
    // 메시지 처리
    // =========================================================
    private void handleMessage(GameMsg msg) {
        System.out.println("[SERVER] mode=" + msg.mode + ", from=" + msg.user);

        // UI 쓰레드에서 처리하도록 invokeLater 사용
        SwingUtilities.invokeLater(() -> {
            switch (msg.mode) {

                case GameMsg.LOGIN_OK ->
                        parent.showLobby();

                case GameMsg.ROOM_LIST ->
                        parent.updateLobbyRoomList(msg.text.split("\\|"));

                case GameMsg.ROOM_UPDATE ->
                        parent.updateRoomPlayers(msg.text.split("\\|"));

                case GameMsg.CHAT, GameMsg.CHAT_SYSTEM ->
                        parent.updateChat(msg.user + ": " + msg.text);

                case GameMsg.GAME_STATE ->
                        parent.updateGameState(msg);

                case GameMsg.SPELL_RESULT ->
                        parent.updateGameState(msg);

                default ->
                        System.out.println("알 수 없는 메시지 mode = " + msg.mode);
            }
        });
    }
*/
    // =========================================================
    // 종료
    // =========================================================
    public void close() {
        try {
            connected = false;
            if (socket != null) socket.close();
        } catch (Exception ignored) {}
    }
}
