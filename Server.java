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
                String expression_csv = expression;

                if (ari_log == false){
                    Bet_2 bet_2 = new Bet_2(expression);
                    last_result = String.valueOf(bet_2.evaluate_exp());

                } else{
                    Bet bet = new Bet(expression);
                    last_result = String.valueOf(bet.evaluate_exp());

                }

                try{
                    PrintWriter pw_csv = new PrintWriter(new FileWriter("Information.csv", true));
                    StringBuilder sb_csv = new StringBuilder();

                    sb_csv.append("\n");
                    sb_csv.append(expression_csv);
                    sb_csv.append(",");
                    sb_csv.append(last_result);
                    sb_csv.append(",");
                    sb_csv.append(java.time.LocalDate.now());


                    pw_csv.write(sb_csv.toString());
                    pw_csv.close();

                } catch (Exception e){
                    e.printStackTrace();
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