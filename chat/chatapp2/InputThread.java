/*
package chat.chatapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class InputThread extends Thread{
    private Socket socket;
    private BufferedReader in;

    InputThread(Socket socket, BufferedReader in) {
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void run() {
        try (BufferedReader reader = in) {
            String msg = null;
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
*/
