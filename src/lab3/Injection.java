package lab3;

import java.util.Scanner;

/**
*
* @author Bernd OK
*/
public class Injection {

    private static String getString(Scanner inp) {
        System.out.print("Customer ID (empty to exit): ");
        return inp.nextLine();
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String custID = getString(inp);
        while (!custID.equals("")) {
            try {
                System.out.println(CustomerAdmin.getCustomer(custID));
            } catch (Exception ex) {
                System.out.println("Not found!");
            }
            custID = getString(inp);
        }
        inp.close();
    }
}