import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args){

        try{
            ServerSocket serverSocket = new ServerSocket(34723);

            while (true){
                Socket client_socket = serverSocket.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
                String received_data = br.readLine();

                Bet bet = new Bet(received_data);
                String last_result = String.valueOf(bet.evaluate_exp());

                PrintWriter pw = new PrintWriter(client_socket.getOutputStream(), true);
                pw.println(last_result);

                client_socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }




}