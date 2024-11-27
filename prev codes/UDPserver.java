import java.net.*;

public class UDPserver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5001);
        byte[] buffer = new byte[1024];
        System.out.println("Server is listening...");

        while (true) {
            // Receive message from the client
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String clientMsg = new String(packet.getData(), 0, packet.getLength());
            
            if (clientMsg.equalsIgnoreCase("quit")) {
                System.out.println("Client disconnected.");
                break;
            }
            
            System.out.println("Client: " + clientMsg);

            // Send response to the client
            String serverMsg = "Server received: " + clientMsg;
            byte[] response = serverMsg.getBytes();
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();
            DatagramPacket responsePacket = new DatagramPacket(response, response.length, clientAddress, clientPort);
            socket.send(responsePacket);
        }

        socket.close();
    }
}
