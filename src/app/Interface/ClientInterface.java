package app.Interface;

import app.model.Menu;
import app.model.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

/**
 * Created by pvmeira on 24/06/17.
 */
public class ClientInterface extends JFrame {
    private JPanel jPanel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private DefaultTableModel model = new DefaultTableModel();


    public ClientInterface() {
        super("Produtos");
        createJTable();
        createWindow();
    }

    public void createWindow() {
        jScrollPane = new JScrollPane(jTable);
        jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(BorderLayout.CENTER, jScrollPane);

        getContentPane().add(jPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        setVisible(true);

    }

    private void createJTable() {
        jTable = new JTable(model);
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Valor");
        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        serachMenu(model);
    }

    public void serachMenu(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        for (MenuItem m : getList().getItems()) {
            modelo.addRow(new Object[]{m.getId(), m.getName(), m.getPrice()});
        }
    }

    private Menu getList() {
        java.util.List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem("1", "Nome menu 1", 14.09));
        items.add(new MenuItem("2", "Nome menu 2", 14.09));
        items.add(new MenuItem("3", "Nome menu 3", 14.09));
        items.add(new MenuItem("4", "Nome menu 4", 14.09));
        return new Menu(items);
    }

}
