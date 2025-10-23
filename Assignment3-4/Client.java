import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Connect to server container using its name
        Socket socket = new Socket("server-container", 5000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello from client at " + System.currentTimeMillis());
        socket.close();
        System.out.println("Message sent to server!");
    }
}

