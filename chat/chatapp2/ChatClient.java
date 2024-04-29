/*
package chat.chatapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("사용법 : java ChatClient id");
            System.exit(1);
        }

        try(Socket socket = new Socket("127.0.0.1", 9999);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ){
            writer.println(args[0]);

            new InputThread(socket, reader).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
