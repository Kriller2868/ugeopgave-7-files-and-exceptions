/*
import java.util.Scanner;

public class Opgave1 {
    Scanner scan = new Scanner(System.in);
    public int promptNumber (String msg) {
        System.out.println(msg);
        try {
            return Integer.parseInt(scan.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Skriv venligst et heltal");
            return promptNumber(msg);
        }
    }
}
*/