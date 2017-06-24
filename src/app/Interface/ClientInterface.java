package app.Interface;

import app.model.*;
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
    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel();


    public ClientInterface() {
        super("Produtos");
        criaJTable();
        criaJanela();
    }

    public void criaJanela() {
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        setVisible(true);

    }

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Valor");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        pesquisar(modelo);
    }

    public void pesquisar(DefaultTableModel modelo) {
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
