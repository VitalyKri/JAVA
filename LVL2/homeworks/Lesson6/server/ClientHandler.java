package Lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Comparable {
    private MainServ serv;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    private String nick;
    private boolean isAuth;

    public ClientHandler(MainServ serv, Socket socket) {
        try {
            this.serv = serv;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        readMessages();

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnect();
                    }
                    serv.upsubscribe(ClientHandler.this);

                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessages() throws IOException {
        while (true) {
            String str = in.readUTF();
            System.out.println("Client " + str);
            // если не авторизовался запускаем ветку, авторизация, регистрация, иначе можем отправлять сообщения
            if (!this.isAuth){
                if (str.startsWith("/auth")) {
                    authentication(str);
                }
            } else {
                if (str.equals("/end")) {
                    out.writeUTF("/serverclosed");
                    break;
                } else if (str.startsWith("/w")) {
                    serv.sendMsg(str.replace("/w","/w "+this.nick));
                    sendMsg(str);
                } else {
                    serv.broadcastMsg(nick + ": " + str);
                }

            }

        }
    }

    public void authentication(String msg) throws IOException {

        String[] token = msg.split(" ");
        try {
            String currentNick = AuthService.getNickByLoginAndPass(token[1], token[2]);
            if (!serv.isNickBusy(currentNick)) {
                this.nick = currentNick;
                this.isAuth = true;
                serv.subscribe(this);
                sendMsg("/authok");
                serv.broadcastMsg("пользователь (" + currentNick + ") в чате");
            } else {
                sendMsg("Под этим ником уже авторизовались");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            sendMsg("Неверный логин/пароль");
        }


    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }

    @Override
    public int compareTo(Object o) {
        ClientHandler another = (ClientHandler) o;
        if (this.nick.hashCode() > another.getNick().hashCode()) {
            return 1;
        }
        if (this.nick.hashCode() < another.getNick().hashCode()) {
            return -1;
        }
        return 0;
    }

    public void closeConnect() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
