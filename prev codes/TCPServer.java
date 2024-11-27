import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5001);
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Client connected!");
        String clientMsg, serverMsg;
        while (true) {
            clientMsg = in.readLine();
            if (clientMsg.equalsIgnoreCase("quit")) {
                System.out.println("Client disconnected.");
                break;
            }
            System.out.println("Client: " + clientMsg);

            System.out.print("You: ");
            serverMsg = userIn.readLine();
            out.println(serverMsg);
        }

        client.close();
        server.close();
    }
}
