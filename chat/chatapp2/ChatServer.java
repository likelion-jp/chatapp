/*
package chat.chatapp2;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(8888);){
            System.out.println("서버가 준비되었습니다.");

            Map<String, PrintWriter> chatClients = new ConcurrentHashMap<>();

            while(true){
                Socket socket = serverSocket.accept();
                new ChatThread(socket, chatClients).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
