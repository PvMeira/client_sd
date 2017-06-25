package app.Interface;

import app.Controller.ClientController;
import app.Utils.MessageUtil;
import app.model.Menu;
import app.model.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by pvmeira on 24/06/17.
 */
public class ClientInterface extends JFrame {
    private JPanel jPanel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private DefaultTableModel model = new DefaultTableModel();
    private Boolean errorShow = Boolean.FALSE;
    private List<String> ids = new ArrayList<>();
    private ClientController clientController;
    private Menu menu;
    private DefaultTableModel m;
    private Double foundFromCurrentUser;
    private JLabel foundLabel;


    public ClientInterface() {
        super("Produtos");
        this.clientController = new ClientController();
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
        this.foundFromCurrentUser = this.clientController.getFoundFromCurrentUser("1");
        foundLabel = new JLabel("Saldo atual : " + this.foundFromCurrentUser);
        getContentPane().add(foundLabel, BorderLayout.NORTH);
    }

    private void createJTable() {
        m = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        jTable = new JTable();
        jTable.setModel(m);

        m.addColumn("");
        m.addColumn("Id");
        m.addColumn("Nome");
        m.addColumn("Valor");

        jTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.getList();
        this.serachMenu(m);

        JButton selectRows = new JButton("Comprar produtos Selecionados");
        selectRows.addActionListener(e -> {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                Boolean slection = Boolean.valueOf(jTable.getValueAt(i, 0).toString());
                String idValue = jTable.getValueAt(i, 1).toString();
                Double totalValue = (Double) jTable.getValueAt(i, 3);
                if (slection) {
                    ids.add(idValue);
                }
            }
            if (ids.isEmpty()) {
                MessageUtil.errorMessage(null, "Erro", "Nenhum Item Selecionado");
            } else {
                String response = this.clientController.buySelectedProducts(ids);
                if (response.equalsIgnoreCase("OK")) {
                    Menu menu = this.clientController.getItensFromServer();
                    Double foundFromCurrentUser = this.clientController.getFoundFromCurrentUser("id");
                    setMenu(menu);
                    serachMenu(m);
                    this.foundFromCurrentUser = foundFromCurrentUser;
                    MessageUtil.sucessMessage(null, "Compra Realizada", "Sua compra foi realizda com sucesso");
                } else {
                    MessageUtil.errorMessage(null, "Erro na Compra", "Erro ao fazer a compra");
                }
                ids = new ArrayList<>();

            }
        });
        selectRows.setSize(100, 50);
        getContentPane().add(BorderLayout.SOUTH, selectRows);
    }

    public void serachMenu(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        for (MenuItem m : this.menu.getItems()) {
            modelo.addRow(new Object[]{new Boolean(false), m.getId(), m.getName(), m.getPrice()});
        }
    }

    private void getList() {
        java.util.List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(Boolean.FALSE, "1313131", "Nome menu 1331311", 14.09));
        items.add(new MenuItem(Boolean.FALSE, "213131313", "Nome menu 21313131", 14.09));
        items.add(new MenuItem(Boolean.FALSE, "313131313", "Nome menu 31313131", 14.09));
        items.add(new MenuItem(Boolean.FALSE, "413131", "Nome menu 131314", 14.09));
        this.menu = new Menu(items);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
