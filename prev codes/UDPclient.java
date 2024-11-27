import java.net.*;
import java.io.*;

public class UDPclient{
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        byte[] buffer = new byte[1024];

        System.out.println("connected to server");
        String ClientMsg, ServerMsg;

        while (true) {
            System.out.println("You: ");
            ClientMsg = userIn.readLine();
            byte[] data = ClientMsg.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length,serverAddress, 5001);
            socket.send(packet);

            if(ClientMsg.equalsIgnoreCase("quit"))
            {
                System.out.println("disconnected");
                break;
            }

            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            ServerMsg = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println("Server: " + ServerMsg);
            
        }
        socket.close();
    }
}