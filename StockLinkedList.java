/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;

import java.util.*;     //importing all the libraries from java.util
import java.io.*;       //importing all the libraries from java.io
import java.util.Scanner;

public class StockLinkedList implements StockList {

    /* Declaration */
    Scanner in = new Scanner(System.in);
    LinkedList<StockItem> myStockList; //Create The List
    String RED = "\u001B[31m";     //Color RED
    String BLUE = "\u001B[34m";     //Color BLUE
    String RESET = "\u001B[0m";     //Reset the color

    /* Custom exceptions as Strings */
    String idExistException = RED + "|----------------------------------------|\n"
            + RED + "|         ! ! !  E R R O R  ! ! !        |\n"
            + RED + "| This ID is already excist in the list. |\n"
            + RED + "| NOTE : Print the list to see the items |\n"
            + RED + "|----------------------------------------|\n" + RESET;

    String idNotFoundException = RED + "|----------------------------------------|\n"
            + RED + "|         ! ! !  E R R O R  ! ! !        |\n"
            + RED + "|    This ID is not found in the list.   |\n"
            + RED + "| NOTE : Print the list to see the items |\n"
            + RED + "|----------------------------------------|\n" + RESET;

    //Constructor:
    public StockLinkedList() {
        /* Create a new Linked List  */
        myStockList = new LinkedList<StockItem>();
    }

    /**
     * Adding stock to the myStockList
     *
     * @param item adds stock in the list
     */
    public void addItem(StockItem item) {

        for (StockItem x : myStockList) {                     //For every stock in the List
            if (x.getItemID().equals(item.getItemID())) {     //Checks if the ID is already excist
                //Throw my custom exception if you find the same ID in the list
                throw new ItemIDAlreadyExistInLinkedList(idExistException);
            }
        }
        myStockList.add(item); //Add stock in myStockList
    }

    /**
     * Deleting stock from the StockList
     *
     * @param itemID check the ID equality and then delete the selected item
     */
    public void deleteItem(String itemID) {

        for (StockItem x : myStockList) {             //For every stock in the List
            if (x.getItemID().equals(itemID)) {       //Check if the ID are equal
                myStockList.remove(x);              //Remove from the list
                return; //Exit Loop
            }
            //Throw my custom Exception if you dont find the same ID in the list
            throw new ItemIDNotFoundInTheList(idNotFoundException);
        }
    }

    /**
     * Setting new price to an item from the myStockList
     *
     * @param itemID checks the ID equality
     * @param price sets the new price to the selected item
     */
    public void updateItemPrice(String itemID, double price) {

        for (StockItem x : myStockList) { //For every stock in myStockList
            if (x.getItemID().equals(itemID)) { //Check if the ID are equal
                x.setPrice(price); //Setting new price to the selected item
                return; //Exit Loop
            }
            //Throw my custom Exception if you dont find the same ID in the list
            //throw new ItemIDNotFoundInTheList(idNotFoundException);
        }

    }

    /**
     * Setting new Quantity of an item from the myStockList
     *
     * @param itemID checks the ID equality
     * @param quantity sets the new quantity number to the selected item
     */
    public void updateItemQuantity(String itemID, int quantity) {

        for (StockItem x : myStockList) { //For every stock in myStockList
            if (x.getItemID().equals(itemID)) { //Check if the ID are equal
                x.setQuantity(quantity); //Setting new quantity to the selected item
                return; //Exit Loop
            }
            //Throw my custom Exception if you dont find the same ID in the list
            //throw new ItemIDNotFoundInTheList(idNotFoundException);
        }
    }

    /**
     * Setting new Re-Order Level to an item from the myStockList
     *
     * @param itemID checks the ID equality
     * @param reOrderLevel sets the new reOrder Level to the selected item
     */
    public void updateReOrderLevel(String itemID, int reOrderLevel) {

        for (StockItem x : myStockList) { //For every stock in myStockList
            if (x.getItemID().equals(itemID)) { //Check if the ID are equal
                x.setReOrderLevel(reOrderLevel); //Setting new reOrder Level to the selected item
                return; //Exit Loop
            }
            //Throw my custom Exception if you dont find the same ID in the list
            //throw new ItemIDNotFoundInTheList(idNotFoundException);
        }
    }

    /**
     * Returns formatted representation of StockList
     *
     * @return a formated table
     */
    public String formatStockList() {

        String str = "";
        for (StockItem x : myStockList) {
            str += x.format();
        }
        return str;
    }

    /**
     * Returns formatted representation of Re-order List Checks if the quantity
     * is smaller than the reOrderLevel
     *
     * @return a formated table
     */
    public String formatReOrderList() {

        String str = "";
        for (StockItem x : myStockList) { //For every stock in the List
            if (x.getQuantity() < x.getReOrderLevel()) {
                str += x.format();
            }
        }
        return str;
    }

    /**
     * Creating and saving the file and adding information to it Exception is
     * needed because we accessing information into a file(StockList.dat)
     *
     * @throws FileNotFoundException - If the file its not found then the
     * program create a new dat file called StockList.dat
     */
    public void saveStockData() throws FileNotFoundException {

        //System.out.println("Enter file name: ");
        // String fileName = in.next() + ".ser";
        FileOutputStream fos = null;
        ObjectOutputStream outs = null;
        try {
            fos = new FileOutputStream("stocklist.ser");
            outs = new ObjectOutputStream(fos);
            outs.writeObject(myStockList);
            fos.close();
            outs.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PrintWriter out = new PrintWriter("StockList.dat");
        out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        out.println("******\t\t***********\t*****\t\t****\t\t**************");
        for (StockItem x : myStockList) { //For every StockItem in List
            out.println(x.format()); //Save information in .dat file as Strings (Readable)
        }
        out.close(); //Clarifying that the save its done

    }

    /**
     * Loading the file from the Directory
     *
     * @param fileName to check if the file is excisting Exception is needed
     * because we accesing information into a file(..\StockList.dat)
     * @throws FileNotFoundException if the file is not found
     */
    public void loadStockData(String fileName) throws FileNotFoundException {
        //OBJECT STREAMS
        FileInputStream fis = null;
        ObjectInputStream in = null;
        File file = new File("stocklist.ser");
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                //myStockList = (LinkedList) in.readObject();
                myStockList = (LinkedList<StockItem>) in.readObject();

                fis.close();
                in.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            System.out.println("\nThe file does not exist!");
        }

        String line = ""; //String Declaration
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName)); //New Buffer Reader
            while ((line = br.readLine()) != null) { // Reads every line of the file
                System.out.println(line); //And then prints it as a String
            }
        } catch (Exception e) { //If file is not found

            System.out.println(RED + "|-------------------------------------------------|");
            System.out.println(RED + "|         ERROR - FILE NOT FOUND EXCEPTION        |");
            System.out.println(RED + "|-------------------------------------------------|");
            System.out.println(RED + "To avoid the error Add an Item, so the system will create the");
            System.out.println(RED + "StockList.dat file to collect information from the directory below :");
            System.out.println(BLUE + "StockList.dat" + RESET);
        }

    }
}
