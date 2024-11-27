import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5001);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Connected to the server!");
        String clientMsg, serverMsg;
        while (true) {
            System.out.print("You: ");
            clientMsg = userIn.readLine();
            out.println(clientMsg);
            if (clientMsg.equalsIgnoreCase("quit")) {
                System.out.println("Disconnected from the server.");
                break;
            }

            serverMsg = in.readLine();
            System.out.println("Server: " + serverMsg);
        }

        socket.close();
    }
}
