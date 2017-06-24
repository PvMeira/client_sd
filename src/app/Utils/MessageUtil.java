package app.Utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pvmeira on 24/06/17.
 */
public class MessageUtil {
    public static void errorMessage(Component frame, String titulo, String content) {
        JOptionPane.showMessageDialog(frame, content, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void sucessMessage(Component frame, String titulo, String content) {
        JOptionPane.showMessageDialog(frame, content, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warningMessage(Component frame, String titulo, String content) {
        JOptionPane.showMessageDialog(frame, content, titulo, JOptionPane.WARNING_MESSAGE);
    }


}
