package chat.chatapp3;


import java.io.Serializable;

/***
 * 서버와 클라이언트 간의 통신을 하기 위해서는 소켓을 사용하여 통신을 한다.
 * 이때 소켓을 통해 어떤 사용자가 어떤 목적을 거지고 서버와 통신 하고자 하는지에 대한
 * 모든 정보 값들을 가지고 잇는 클래스가 필요하다.
 */

enum Info{
    JOIN, EXIT, SEND
}

public class InfoDTO implements Serializable {

    private String nickName;
    private String message;
    private Info command;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Info getCommand() {
        return command;
    }

    public void setCommand(Info command) {
        this.command = command;
    }
}
