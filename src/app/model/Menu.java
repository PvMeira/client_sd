package app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pvmeira on 24/06/17.
 */
public class Menu {
    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    private List<MenuItem> items = new ArrayList<>();

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
}
