
import java.util.ArrayList;

/*
public class Drink {
    private double price;
    public ArrayList<String> items = new ArrayList<>();

    public Drink(double price) {
        setPrice(price);   // genbruger valideringen
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Prisen er for lav: " + price);
        }
        this.price = price;
    }



    public String getItem(ArrayList<String> items, int index) {
        if (index < 0 || index >= items.size()) {
            throw new IllegalArgumentException("Indeks " + index + " er uden for range 0-" + (items.size() - 1));
        }
        return items.get(index);
    }
}
*/

public class Drink {
private String name;
private int price;
private int soldNumber;

    public Drink(String name, int price, int soldNumber) {
        this.name = name;
        this.price = price;
        this.soldNumber = soldNumber;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", soldNumber=" + soldNumber +
                '}';
    }

}
