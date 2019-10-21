/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;

import java.util.*; //importing all the libraries from java.util
import java.io.*; //importing all the libraries from java.io

public class StockListCLI {

    /* Declaration */
    Scanner in = new Scanner(System.in);
    private StockList stock = null;
    private String itemID = "";
    private String itemDesc = "";
    private double itemPrice = 0;
    private int itemQuantity = 0;
    private int itemReOrderLevel = 0;

    /* Constructor */
    public StockListCLI(StockLinkedList stock) {
        this.stock = stock;
    }

    /**
     * Display Main Menu The exception is needed because we passing information
     * into StockList.dat
     *
     * @throws FileNotFoundException - Throwing exception message if the file is
     * not found
     */
    public void doMenu() throws FileNotFoundException {

        int option; //Switch Statement
        boolean loopMenu = false;
        do {
            System.out.println("Stock List Main Menu");
            System.out.println("********************");
            System.out.println("1. Add an Item");
            System.out.println("2. Delete an Item");
            System.out.println("3. Update Item Price");
            System.out.println("4. Update Item Quantity");
            System.out.println("5. Update Re-Order Level");
            System.out.println("6. Print Stock List");
            System.out.println("7. Print ReOrder List");
            System.out.println("8. Exit");

            System.out.print("\nSelect option [1-8] :> ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    doAddItem();
                    break;

                case 2:
                    doDeleteItem();
                    break;

                case 3:
                    doUpdateItemPrice();
                    break;

                case 4:
                    doUpdateQuantity();
                    break;

                case 5:
                    doUpdateReOrderLevel();
                    break;

                case 6:
                    doPrintStockList();
                    break;

                case 7:
                    doPrintReorderList();
                    break;

                case 8:
                    loopMenu = true;
                    break;

                default:
                    doError();
                    break;
            }

        } while (loopMenu != true);

    }

    /**
     * Adding items into the List (..\StockList.dat) The exception is needed
     * because we passing information into StockList.dat
     *
     * @throws FileNotFoundException - Throwing exception message if the file is
     * not found
     */
    private void doAddItem() throws FileNotFoundException {

        boolean check = false; //Do-While Loop

        do {
            System.out.println("Add New Item");
            System.out.println("***************\n");
            System.out.print("Enter ID 5 Characters :> ");
            in.nextLine();
            itemID = in.nextLine();

            System.out.print("Enter Description     :> ");
            itemDesc = in.nextLine();
            System.out.print("Enter Price           :> ");
            itemPrice = in.nextDouble();
            System.out.print("Enter Quantity        :> ");
            itemQuantity = in.nextInt();
            System.out.print("Enter Re-Order Level  :> ");
            itemReOrderLevel = in.nextInt();

            /* Adds information in a list only if the ID is not existing */
            try {
                stock.addItem(new StockItem(itemID, itemDesc, itemPrice, itemQuantity, itemReOrderLevel));
            } catch (ItemIDAlreadyExistInLinkedList e) {
                System.out.println(e.getMessage());
            }

            stock.saveStockData(); //Saves information on the StockList.dat 

            char addAnotherCheck;
            System.out.print("Enter another (Y/N)   :> ");
            addAnotherCheck = in.next().charAt(0);

            if (addAnotherCheck == 'Y' || addAnotherCheck == 'y') {
                check = false; //boolean = false - Dont exit the loop
            } else if (addAnotherCheck == 'N' || addAnotherCheck == 'n') {
                System.out.println();
                check = true; //boolean = true - Exit the loop 
            } else {
                doError(); //Invalid Number Message
            }
        } while (!check);
    }

    /**
     * Identified a specific ID and remove it from the list Saves the list in
     * the file(StockList.dat) The exception is required as we are passing
     * information into StockList.dat
     *
     * @throws FileNotFoundException for the method stock.saveStockDate()
     */
    private void doDeleteItem() throws FileNotFoundException {

        String strID;
        System.out.println("Delete an Item");
        System.out.println("**************");
        System.out.print("Please enter the ID you want to remove :> ");
        in.nextLine();
        strID = in.nextLine();

        try {
            stock.deleteItem(strID); //Delete the item from the list using strID parameter
        } catch (ItemIDNotFoundInTheList e) {
            System.out.println(e.getMessage());//Display Exception Message
        }

        stock.saveStockData();

    }

    /**
     * Updating the Price of a selected item by checking the identification from
     * the StockList.dat The exception is required as we passing information
     * into StockList.dat
     *
     * @throws FileNotFoundException - Throwing exception message if the file is
     * not found
     */
    private void doUpdateItemPrice() throws FileNotFoundException {

        String strID;
        double newItemPrice;
        System.out.println("Update Price of an item");
        System.out.println("***********************");
        System.out.print("Please enter the ID you want to update :> ");
        in.nextLine();
        strID = in.nextLine();

        /* Try to update only if you find the ID in the list */
        try {
            System.out.print("\nEnter the new price :> ");
            newItemPrice = in.nextDouble(); //Adding information to a Double variable
            stock.updateItemPrice(strID, newItemPrice); //Updates Price
        } catch (ItemIDNotFoundInTheList e) {
            System.out.println(e.getMessage()); //Display Exception Message
        }
        stock.saveStockData(); //Save the List in the StockList.dat
    }

    /**
     * Updating the Quantity of a selected item by checking the identification
     * from the StockList.dat The exception is required as we passing
     * information into StockList.dat
     *
     * @throws FileNotFoundException - Throwing exception message if the file is
     * not found
     */
    private void doUpdateQuantity() throws FileNotFoundException {

        String strID;
        int newItemQuantity;
        System.out.println("Update Quantity of an item");
        System.out.println("**************************");
        System.out.print("Please enter the ID you want to update :> ");
        in.nextLine(); //Collecting information from the keyboard including spaces
        strID = in.nextLine(); //Adding collected information to a String 

        /* Try to update only if you find the ID in the list */
        try {
            System.out.print("\nEnter the new Quantity Level :> ");
            newItemQuantity = in.nextInt(); //Adding information to an Integer variable
            stock.updateItemQuantity(strID, newItemQuantity); //Updates the Quantity
        } catch (ItemIDNotFoundInTheList e) {
            System.out.println(e.getMessage()); //Display Exception Message
        }
        stock.saveStockData(); //Save the List in the StockList.dat
    }

    /**
     * Updating the Re-Order-Level of a selected item by checking the
     * identification from the StockList.dat The exception is required as we
     * passing information into StockList.dat
     *
     * @throws FileNotFoundException - Throwing exception message if the file is
     * not found
     */
    private void doUpdateReOrderLevel() throws FileNotFoundException {

        String strID;
        int newItemReOrderLevel;

        System.out.println("Update Re-order Level of an item");
        System.out.println("********************************");
        System.out.print("Please enter the ID you want to update :> ");
        in.nextLine(); //Collenting information from the keyboard including spaces
        strID = in.nextLine(); //Adding collected information to a String 

        /* Try to update only if you find the ID in the list */
        try {
            System.out.print("\nEnter the new Re-Order Level :> ");
            newItemReOrderLevel = in.nextInt(); //Adding information to an Integer
            stock.updateReOrderLevel(strID, newItemReOrderLevel);//Updates the Re-Order-Level
        } catch (ItemIDNotFoundInTheList e) {
            System.out.println(e.getMessage()); //Display Exception Message
        }
        stock.saveStockData(); //Save the List in the StockList.dat
    }

    /**
     * Returns a string representation of the List Table The exception is
     * required as we passing information into StockList.dat
     *
     * @throws FileNotFoundException if the file is not found
     */
    private void doPrintStockList() throws FileNotFoundException {
        /* Loads everything from the StockList.dat */
        stock.loadStockData("StockList.dat");
    }

    /**
     * Returns a string representation of the List Table The written products
     * are in the list only if if quantity < ReOrderLevel
     */
    private void doPrintReorderList() {
        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println(stock.formatReOrderList());
    }

    /**
     * Returns an error message if the input number is not valid to help the
     * user
     */
    private void doError() {

        String RED = "\u001B[31m"; //Color RED
        String RESET = "\u001B[0m"; //Reset the color
        System.out.println(RED + "! ! ! ! ! ! !Error! ! ! ! ! ! !");
        System.out.println(RED + "INVALID NUMBER PLEASE TRY AGAIN" + RESET);
    }

}
