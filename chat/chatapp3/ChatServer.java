package chat.chatapp3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/***
 * 기본적인 서버 클래스이지만 단순하게 서버와 포트번호만을 준비하여 클라이언트의 접속을
 * 기다리다가 클라이언트가 접속 하게 되면 정보를 ChatThread에게 전달만 해주는 기능
 * 이후 정상적인 모든 서버의 기능은 ChatThread 클래스가 수행
 */


public class ChatServer {

    private ServerSocket serverSocket;
    private List<ChatThread> list;
    public ChatServer(){
        try{
            serverSocket = new ServerSocket(9500);
            System.out.println("서버 준비 완료");
            list = new ArrayList<>();
            while (true){
                Socket socket = serverSocket.accept();
                ChatThread thread = new ChatThread(socket, list);
                thread.start();
                list.add(thread);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
