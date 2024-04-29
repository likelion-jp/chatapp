/*
package chat.chatapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ChatThread extends java.lang.Thread {

    private Socket socket;
    private String id;
    private BufferedReader reader;
    private PrintWriter writer;

    private Map<String, PrintWriter> chatClients;

    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;
        try{
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            id = reader.readLine();

            broadcast(id + "님이 입장하셨습니다.");
            System.out.println("새로운 사용자의 아이디는 " + id + "입니다.");

            synchronized (chatClients){
                chatClients.put(this.id, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public  void run(){
        System.out.println(id + "사용자 채팅시작!!");

        String msg = null;
        try{
            while((msg = reader.readLine()) != null){
                if("/quit".equalsIgnoreCase(msg))
                    break;

                if(msg.indexOf("/to") == 0)
                    sendMsg(msg);
                else
                    broadcast(id + " : " + msg);
            }
        }catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}































*/
