package app.Controller;

import app.model.Menu;
import app.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pvmeira on 25/06/17.
 */
public class ClientController {

    public String buySelectedProducts(List<String> idsProducts) {
        //TODO logica para compra
        return "OK";
    }

    public Menu getItensFromServer() {
        return getList();
    }

    public Double getFoundFromCurrentUser(String id) {
        //TODO logica para buscar saldo dado o id do usuario
        return 40.00;
    }

    private Menu getList() {
        java.util.List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(Boolean.FALSE, "1", "Teste Volta 00", 14.09));
        items.add(new MenuItem(Boolean.FALSE, "2", "Teste Volta 02", 14.09));
        items.add(new MenuItem(Boolean.FALSE, "3", "Teste Volta 03", 14.09));
        items.add(new MenuItem(Boolean.FALSE, "4", "Teste Volta 01", 14.09));
        return new Menu(items);
    }

}
