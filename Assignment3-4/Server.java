
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        File logFile = new File("/data/messages.log");
        if (!logFile.exists()) {
            logFile.getParentFile().mkdirs();
            logFile.createNewFile();
        }

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started on port 5000...");
            Socket socket = serverSocket.accept();

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = input.readLine();
            System.out.println("Received: " + message);

            try (FileWriter writer = new FileWriter(logFile, true)) {
                writer.write(message + "\n");
            }

            socket.close();
        }
    }
}
