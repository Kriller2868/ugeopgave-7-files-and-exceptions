/*
opgave 2 og 2b
public class Main {

    public static void main(String[] args) {


        Drink drink = new Drink(5.00);
        drink.items.add("Cola");
        drink.items.add("Fanta");

        try {
            drink.setPrice(-5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ugyldig pris: " + e.getMessage());
        }

        try {
            drink.setPrice(5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ugyldig pris: " + e.getMessage());
        }

        try {
            drink.getItem(drink.items,5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
*/

// opgave 3 og 3b
/*
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String []args) {
        fileRead reader = new fileRead();

        //test 1: fil der findes
        try {
            ArrayList<String> lines = reader.readlines("data/data.csv");
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet");
        }


        //test 2: fil der ikke findes
        try {
            ArrayList<String> lines = reader.readlines("data/dataikkefindes.csv");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet");
        }

    }
}
*/

// opgave 4
/*
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("Espresso, En kraftfuld og koncentreret kaffe, 25.0");
        data.add("Latte, Espresso med dampet mælk, 45.0");
        data.add("Cola, Kold og brusende, 30.0");

        for (String line : data) {
            String[] value = line.split(",");

            String name = value[0].trim();
            String description = value[1].trim();
            // Prisen i en String
            // String price = value[2].trim();
            // Prisen i en double
            double price = Double.parseDouble(value[2].trim());

            System.out.println(name + " - " + description + " (" + price + " kr)");



        }

    }
}
*/

import java.util.ArrayList;

//Opgave 5
/*
public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("Cola, Kold sodavand, 25.0");
        data.add("Kaffe, Sort kaffe, 30.5");
        data.add("Fanta, Appelsinsodavand, 22");
        data.add("Vand, Stille kildevand, gratis");

        double total = 0;
        for (String s : data) {
            String[] values = s.split(",");
            String name = values[0].trim();
            String description = values[1].trim();
            try {
                double price = Double.parseDouble(values[2].trim());
                total += price;
                System.out.println(name + " - " + description + " (" + price + " kr)");
            } catch (NumberFormatException e) {
                System.out.println(name + " - kunne ikke læse pris: " + values[2].trim());
            }
        }
        System.out.println("Samlet pris: " + total + " kr");
    }
}
*/

public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.loadData();
        cafe.showMenu();
    }
}


