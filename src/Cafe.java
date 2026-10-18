import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {
    private ArrayList<Drink> coffeeMenu = new ArrayList<>();
    private final String FILE_PATH = "data/menu.csv";

    public void loadData() {
        coffeeMenu.clear();
        try {
            Scanner fileScanner = new Scanner(new File(FILE_PATH));

            // Spring header-linjen over ("Name, Price, SoldNumber")
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue; // spring tomme linjer over
                }

                String[] parts = line.split(",");
                String name = parts[0].trim();
                int price = Integer.parseInt(parts[1].trim());
                int soldNumber = Integer.parseInt(parts[2].trim());

                coffeeMenu.add(new Drink(name, price, soldNumber));
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke finde filen: " + FILE_PATH);
        }
    }

    // Gemmer menuen tilbage til filen
    public void saveData() {
        try {
            PrintStream out = new PrintStream(new File(FILE_PATH));

            out.println("Name, Price, SoldNumber"); // header
            for (Drink drink : coffeeMenu) {
                out.println(drink); // bruger toString()
            }
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke gemme til filen: " + FILE_PATH);
        }
    }

    public void showMenu() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- CAFÉ MENU ---");
            for (int i = 0; i < coffeeMenu.size(); i++) {
                Drink d = coffeeMenu.get(i);
                System.out.println((i + 1) + ". " + d.getName() + " - " + d.getPrice() + " kr.");
            }
            System.out.println("0. Afslut");
            System.out.print("Vælg en kaffe: ");

            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("Indtast venligst et tal.");
                input.next(); // fjern det ugyldige input
                continue;
            }

            if (choice == 0) {
                running = false;
                System.out.println("Tak for besøget!");
            } else if (choice >= 1 && choice <= coffeeMenu.size()) {
                Drink selected = coffeeMenu.get(choice - 1);

                System.out.println("Du skal betale: " + selected.getPrice() + " kr.");

                selected.setSoldNumber(selected.getSoldNumber() + 1);
                saveData();
            } else {
                System.out.println("Ugyldigt valg, prøv igen.");
            }
        }
        input.close();
    }
}
