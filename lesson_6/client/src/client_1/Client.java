package client_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket socket;
    static final int PORT = 8189;
    static final String IP_ADDRESS = "localhost";
    public static void main(String[] args) throws IOException {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in_kbr = new Scanner(System.in);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = in.nextLine();

                        if (str.equals("/end")) {
                            System.out.println("Server disconnected");
                            break;
                        }

                        System.out.println("Server: " + str);
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String msg = in_kbr.nextLine();
                        if(msg.equals("/end")) {
                            out.println(msg);
                            break;
                        }
                        out.println(msg);
                    }
                }
            });
            t1.start();
            t2.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }






    }
}
