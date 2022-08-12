package models;

/**
 *
 * @author 835178
 */
public class HomeItem {
    private String name;
    private String owner;
    private String category;
    private String price;

    public HomeItem(String name, String owner, String category, String price) {
        this.name = name;
        this.owner = owner;
        this.category = category;
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getPrice() {
        return price;
    }
    
    
}
