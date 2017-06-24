package app.Controller;

import app.Runnable.ServerListner;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by pvmeira on 24/06/17.
 */
public class ServerController {


    private Socket socket;
    private PrintWriter writer;
    private Scanner scanner;

    private String ip;
    private Integer port;

    public ServerController(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public void configClientNetWork() throws IOException {
        this.socket = new Socket(this.ip, this.port);

        this.writer = new PrintWriter(this.socket.getOutputStream());
        this.scanner = new Scanner(this.socket.getInputStream());
        new Thread(new ServerListner(this.scanner, this.socket)).start();
    }
}
