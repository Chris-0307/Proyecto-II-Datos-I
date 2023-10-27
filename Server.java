import java.io.*;
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

                String[] parts = received_data.split(":");
                boolean ari_log = Boolean.parseBoolean(parts[0]);
                String expression = parts[1];

                String last_result;

                if (ari_log == false){
                    Bet_2 bet_2 = new Bet_2(expression);
                    last_result = String.valueOf(bet_2.evaluate_exp());

                } else{
                    Bet bet = new Bet(expression);
                    last_result = String.valueOf(bet.evaluate_exp());

                }

                OutputStream os = client_socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                pw.println(last_result);

                os.close();
                pw.close();
                client_socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}