package client;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class Client {

    private Socket socketClient;

    public Client() {
        try {
            this.socketClient = new Socket("localhost",5000);
            Logger.getGlobal().info("CLIENT: I'm connected to Server on port 5000...");
            transferData();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void transferData() throws IOException {
        DataInputStream dataInput = new DataInputStream(socketClient.getInputStream());
        DataOutputStream dataOutput = new DataOutputStream(socketClient.getOutputStream());

        while (true){
            dataOutput.writeInt(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a position to Search 0 - 10")));
            JOptionPane.showMessageDialog(null,"CLIENT: The server returns - " + dataInput.readUTF());
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
