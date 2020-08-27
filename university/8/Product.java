public class Product {

    private String name;
    private int price;

    // Constructor
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Getter
    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Name of product: " + name + " price -  " + price;
    }

}
