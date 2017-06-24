package app.Runnable;

import javax.swing.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by pvmeira on 24/06/17.
 */
public class ServerListner implements Runnable {

    private final Scanner scanner;
    private final Socket socket;

    public ServerListner(Scanner scanner, Socket socket) {
        this.scanner = scanner;
        this.socket = socket;

    }

    @Override
    public void run() {
        try {
            String currenttext;

            while ((currenttext = scanner.nextLine()) != null) ;

        } catch (NoSuchElementException e) {
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
