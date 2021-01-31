package server_1;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    static final int PORT = 8189;
    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("server started");

            socket = server.accept();
            System.out.println("client connected");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = in.nextLine();

                        if (str.equals("/end")) {
                            System.out.println("Client disconnected");
                            break;
                        }

                        System.out.println("Client: " + str);
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner in_kbr = new Scanner(System.in);

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
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
