package Logic.Entity.Network;

import Logic.Entity.Network.SharingCenter.SharingCenter;
import Logic.Entity.UserInfo.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Network implements Runnable{

    private ServerSocket serverSocket;
    private boolean isRun;

    public Server(int port, User user) throws IOException {
        super(user);
        serverSocket = new ServerSocket(port);

    }

    @Override
    public void run() {
        while (isRun){

            try {
                Socket client = this.serverSocket.accept();
                Thread sharingCenter = new SharingCenter(super.getUser() ,client);
                sharingCenter.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    }
