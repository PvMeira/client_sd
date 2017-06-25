package app.model;

/**
 * Created by pvmeira on 24/06/17.
 */
public class MenuItem {
    private String id;
    private String name;
    private double price;
    private Boolean buy = Boolean.FALSE;

    public MenuItem(Boolean b, String id, String name, double price) {
        this.buy = b;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        MenuItem item = (MenuItem) obj;
        return id.equalsIgnoreCase(item.id);
    }

    public Boolean getBuy() {
        return buy;
    }

    public void setBuy(Boolean buy) {
        this.buy = buy;
    }
}

