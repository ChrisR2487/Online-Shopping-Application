import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args){
        Scanner inputStream = null;
        PrintWriter outputStream = null;
        ArrayList<Item> inv = new ArrayList<Item>();
        int itemNum = 0;
        String itemName;
        String category = null;
        double price = 0.0;
        int itemQuantity = 0;

        try {
            inputStream = new Scanner(new FileInputStream("items.txt"));

            while(inputStream.hasNextLine()) {
                itemNum = Integer.parseInt(inputStream.nextLine());
                itemName = inputStream.nextLine();
                category = inputStream.nextLine();
                price = Double.parseDouble(inputStream.nextLine());
                itemQuantity = Integer.parseInt(inputStream.nextLine());
                Item stuff = new Item(itemNum, itemName, category, price, itemQuantity);
                inv.add(stuff);
            }

            String line = null;
            int linecount = 0;
            String label = "";
            while(inputStream.hasNextLine())
            {
                if (linecount % 5 == 0) {
                    label = "Number: ";
                }
                if (linecount % 5 == 1) {
                    label = "Name: ";
                }
                if (linecount % 5 == 2) {
                    label = "Category: ";
                }
                if (linecount % 5 == 3) {
                    label = "Price: ";
                } else if (linecount % 5 == 4) {
                    label = "Quantity: ";
                }
                line = inputStream.nextLine();
                linecount++;
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Problem opening file.");
            System.exit(0);
        }
        inputStream.close();


        Item temp = new Item(0,"","",0,1);
        Item temp2 = new Item(0,"","",0,1);
        boolean menuDone = false;
        boolean cartCreate = false;
        Scanner first = new Scanner(System.in);
        Scanner itemChoice = new Scanner(System.in);
        Scanner uInp = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        Scanner catChoice = new Scanner(System.in);
        Scanner payInfo1 = new Scanner(System.in);
        Scanner payInfo2 = new Scanner(System.in);
        Scanner payInfo3= new Scanner(System.in);
        Scanner payInfo4 = new Scanner(System.in);

        temp.menu();
        String uFirst = first.nextLine();
        while(!"1".equals(uFirst)){
            System.out.println("Please create a cart first.");
            temp.menu();
            uFirst = uInp.nextLine();
        }
        ArrayList<Item> uInv = new ArrayList<Item>();
        System.out.println("");
        System.out.println("Shopping cart created!");
        System.out.println("");
        while (!menuDone) {
            temp.menu();
            String uChoice = choice.nextLine();
            switch (uChoice) {
                case "1":
                    System.out.println("Cart has already been created");
                    System.out.println();
                    break;
                case "2":{
                    System.out.println();
                    System.out.println("Choose a category.");
                    temp.printCategories(inv);
                    System.out.print("Your Choice? ");
                    int bChoice = catChoice.nextInt();
                    switch (bChoice) {
                        case 1:
                            temp.printBooks(inv);
                            System.out.println();
                            System.out.println("Enter the number of the item you wish to add.");
                            System.out.print("Your Choice? ");
                            bChoice = itemChoice.nextInt();
                            while (!temp.checkID(bChoice, inv)) {
                                System.out.println();
                                System.out.println("Invalid option.");
                                temp.printBooks(inv);
                                System.out.println();
                                System.out.println("Enter the number of the item you wish to add.");
                                System.out.print("Your Choice? ");
                                bChoice = itemChoice.nextInt();
                            }
                            temp2 = temp.search(bChoice, inv);
                            uInv.add(inv.get(temp2.getIndex(bChoice, inv)));
                            System.out.println("Your Choice: " + temp2 + " has been added to your cart.");
                            System.out.println();
                            temp2.showCart(uInv);
                            break;
                        case 2:
                            temp.printMovies(inv);
                            System.out.println();
                            System.out.println("Enter the number of the item you wish to add.");
                            System.out.print("Your Choice? ");
                            bChoice = itemChoice.nextInt();
                            while (!temp.checkID(bChoice, inv)) {
                                System.out.println();
                                System.out.println("Invalid option.");
                                temp.printMovies(inv);
                                System.out.println();
                                System.out.println("Enter the number of the item you wish to add.");
                                System.out.print("Your Choice? ");
                                bChoice = itemChoice.nextInt();
                            }
                            temp2 = temp.search(bChoice, inv);
                            uInv.add(inv.get(temp2.getIndex(bChoice, inv)));
                            System.out.println("Your Choice: " + temp2 + " has been added to your cart.");
                            System.out.println();
                            temp2.showCart(uInv);
                            break;
                        case 3:
                            temp.printMusic(inv);
                            System.out.println();
                            System.out.println("Enter the number of the item you wish to add.");
                            System.out.print("Your Choice? ");
                            bChoice = itemChoice.nextInt();
                            while (!temp.checkID(bChoice, inv)) {
                                System.out.println();
                                System.out.println("Invalid option.");
                                temp.printMusic(inv);
                                System.out.println();
                                System.out.println("Enter the number of the item you wish to add.");
                                System.out.print("Your Choice? ");
                                bChoice = itemChoice.nextInt();
                            }
                            temp2 = temp.search(bChoice, inv);
                            uInv.add(inv.get(temp2.getIndex(bChoice, inv)));
                            System.out.println("Your Choice: " + temp2 + " has been added to your cart.");
                            System.out.println();
                            temp2.showCart(uInv);
                            break;
                        case 4:
                            temp.printElectronics(inv);
                            System.out.println();
                            System.out.println("Enter the number of the item you wish to add.");
                            System.out.print("Your Choice? ");
                            bChoice = itemChoice.nextInt();
                            while (!temp.checkID(bChoice, inv)) {
                                System.out.println();
                                System.out.println("Invalid option.");
                                temp.printElectronics(inv);
                                System.out.println();
                                System.out.println("Enter the number of the item you wish to add.");
                                System.out.print("Your Choice? ");
                                bChoice = itemChoice.nextInt();
                            }
                            temp2 = temp.search(bChoice, inv);
                            uInv.add(inv.get(temp2.getIndex(bChoice, inv)));
                            System.out.println("Your Choice: " + temp2 + " has been added to your cart.");
                            System.out.println();
                            temp2.showCart(uInv);
                            break;
                        default:
                            System.out.println("Invalid Choice.");
                            break;
                    }
                    break;
                }

                case "3":
                    temp2.showCart(uInv);
                    System.out.println("Enter the number of the item you wish to remove.");
                    System.out.print("Your Choice? ");
                    int bChoice = itemChoice.nextInt();
                    temp2 = temp.search(bChoice,inv);
                    uInv.remove(temp2);
                    System.out.println("Item #" + temp2.getItemNum() + " has been removed from your cart.");
                    temp2.showCart(uInv);
                    break;
                case "4":
                    System.out.println("Order Summary:");
                    System.out.println();
                    temp.showCart(uInv);
                    System.out.printf("Order Total: $%8.2f", temp.getTotal(uInv));
                    System.out.print(" (6.0% tax included)");
                    System.out.println();
                    System.out.println("How do you wish to pay for your order?");
                    System.out.println();
                    System.out.print("(Enter 1 to charge to credit card on file or 2 to charge to new credit card.): ");
                    int payChoice = itemChoice.nextInt();
                    while(payChoice !=1 && payChoice !=2){
                        System.out.println("Invalid Option.");
                        System.out.print("Please enter 1 to charge to credit card on file or 2 to charge to new credit card. ");
                        payChoice = itemChoice.nextInt();
                    }
                    if(payChoice == 1){
                        System.out.println("Payment Summary: " );
                        System.out.println();
                        System.out.printf("Payment Amount: $%8.2f", temp.getTotal(uInv));
                        System.out.print(" Charged to card on file");
                        System.out.println();
                        temp.thanks();
                    }
                    if(payChoice == 2){
                        System.out.println("Please enter your payment information:" );
                        System.out.print("Card holder name: ");
                        String uInfo1 = payInfo1.nextLine();
                        System.out.print("Credit card type (e.g., MasterCard): ");
                        String uInfo2 = payInfo2.nextLine();
                        System.out.print("Credit card number (e.g., 5201345098756420): ");
                        String uInfo3 = payInfo3.nextLine();
                        while (uInfo3.length() != 16){
                            System.out.print("Credit card number must be 16 chars long: ");
                            System.out.print("Credit card number (e.g., 5201345098756420): ");
                            uInfo3 = payInfo3.nextLine();
                        }
                        System.out.print("Expiration date (e.g., 10/2016): ");
                        String uInfo4 = payInfo4.nextLine();
                        System.out.println();

                        System.out.println("Credit payment summary: ");
                        System.out.println("Customer name: " + uInfo1);
                        System.out.printf("Payment Amount: $%8.2f%n", temp.getTotal(uInv));
                        System.out.println("Card type:  " + uInfo2);
                        System.out.println("Card number: ************" + uInfo3.substring(12,16));
                        System.out.println("Exp date: " + uInfo4);
                        System.out.println();
                        temp.thanks();
                    }

                    menuDone = true;
                    break;
                default:
                    System.out.println("Invalid Selection");
                    System.out.println();
                    break;

            }
        }

    }




}
