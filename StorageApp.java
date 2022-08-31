import java.util.Scanner;

public class StorageApp {
    public static void main(String[] args) {
        StorageService storageService = new StorageService();

        System.out.println("If you want to add, press the 1 button");
        System.out.println("if you want to delete,press 2 button");
        System.out.println("if you want to see,press 3 button");
        System.out.println("if you want to exit press 0 button");
        int i = 0;
        while (i >= 0) {
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            if (x == 1) {
                System.out.println("Enter the id ");
                int id = scan.nextInt();
                System.out.println("Enter the Brand");
                String brand = scan.next();

                System.out.println("Enter the price");
                int price = scan.nextInt();

                storageService.save(id, brand, price);

                System.out.println("added");

            } else if (x == 2) {
                
                System.out.println("Enter the id ");
                int id = scan.nextInt();

                storageService.delete(id);

                System.out.println("Deleted");
            } else if (x == 3) {

                storageService.seeAllProducts();
                System.out.println("Look");
            } else if (x == 0) {

                System.out.println("Bye:)");
                // TODO close database connection
                break;

            }

        }
    }

}
