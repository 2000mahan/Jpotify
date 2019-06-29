package Logic.Entity.Network;

import Logic.Entity.Network.SharingCenter.SharingCenter;
import Logic.Entity.UserInfo.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends Network implements Runnable {
    private Socket socket;
    private boolean isRun;

    public Client(int port, User user, String IPAddress) throws IOException {
        super(user);
        socket = new Socket(IPAddress, port);

    }

    @Override
    public void run() {
        while (isRun) {

            Thread sharingCenter = new SharingCenter(super.getUser());
            sharingCenter.start();

        }
    }
}