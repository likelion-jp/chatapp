package chat.chatapp3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/***
 * 서버의 주요 기능을 담당하는 쓰레드 클래스, 클라이언트로 부터 직접적으로 모든 정보를
 * 전달 받아서 모든 사용자의 채팅창 서버에 메세지 내용을 뿌려주는 서버기능 클래스
 */



public class ChatThread extends Thread{

    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Socket socket;

    private List<ChatThread> list;

    public ChatThread(Socket socket, List<ChatThread> list) {
        this.socket = socket;
        this.list = list;

        try{
            writer = new ObjectOutputStream(socket.getOutputStream());
            reader = new ObjectInputStream(socket.getInputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        InfoDTO dto = null;
        String nickName;
        try{
            while(true){
                dto = (InfoDTO)reader.readObject();
                nickName = dto.getNickName();


                if(dto.getCommand() == Info.EXIT){
                    InfoDTO sendDto = new InfoDTO();

                    sendDto.setCommand(Info.EXIT);
                    writer.writeObject(sendDto);
                    writer.flush();

                    reader.close();
                    writer.close();
                    socket.close();
                    //남아있는 클라이언트에게 퇴장메세지 보내기
                    list.remove(this);

                    sendDto.setCommand(Info.SEND);
                    sendDto.setMessage(nickName+"님 퇴장하였습니다");
                    broadcast(sendDto);
                    break;
                }else if(dto.getCommand()==Info.JOIN){
                    //모든 사용자에게 메세지 보내기
                    //nickName = dto.getNickName();
                    //모든 클라이언트에게 입장 메세지를 보내야 함
                    InfoDTO sendDto = new InfoDTO();
                    sendDto.setCommand(Info.SEND);
                    sendDto.setMessage(nickName+"님 입장하였습니다");
                    broadcast(sendDto);
                } else if(dto.getCommand()==Info.SEND){
                    InfoDTO sendDto = new InfoDTO();
                    sendDto.setCommand(Info.SEND);
                    sendDto.setMessage("["+nickName+"]"+ dto.getMessage());
                    broadcast(sendDto);
                }
            }//while
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void broadcast(InfoDTO sendDto) throws IOException{
        for (ChatThread thread : list) {
            thread.writer.writeObject(sendDto);
            thread.writer.flush();
        }
    }
}
