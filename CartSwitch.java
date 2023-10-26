import java.util.ArrayList;
import java.util.Scanner;

public class CartSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();

        System.out.println("Welcome to your shopping cart");

        while (true) {
            System.out.print(">");
            String input = scanner.nextLine().trim();
            String[] command = input.split("[, ]+");
            
            switch (command[0]) {
                case "list":
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty");
                    } else {
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.println((i + 1) + ". " + cart.get(i));
                        }
                    }
                    break;
                case "add":
                    if (command.length > 1) {
                        for (int i = 1; i < command.length; i++) {
                            String item = command[i];
                            if (cart.contains(item)) {
                                System.out.println("You have " + item + " in your cart");
                            } else {
                                cart.add(item);
                                System.out.println(item + " added to cart");
                            }
                        }
                    }
                    break;
                case "delete":
                    if (command.length > 1) {
                        int index = Integer.parseInt(command[1]) - 1;
                        if (index >= 0 && index < cart.size()) {
                            String removedItem = cart.remove(index);
                            System.out.println(removedItem + " removed from cart");
                        } else {
                            System.out.println("Incorrect item index");
                        }
                    }
                    break;

                case "exit":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    

                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}