/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;

import java.io.*;
import java.util.*;

public class StockListTester {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //Scanner in = new Scanner(System.in);
        StockLinkedList registration = new StockLinkedList();

        /* Test 1 Adding items in the list */
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("               Test 1 : addItem() & formatStockList()");
        System.out.println("\nAdding [Jin, Martini, Vodka, Whisky,] to the StockList\n");

        /* Adding items in the list */
        registration.addItem(new StockItem("A1234", "Jin", 15.99, 50, 150));
        registration.addItem(new StockItem("B1234", "Martini", 22.40, 42, 158));
        registration.addItem(new StockItem("C1234", "Vodka", 39.50, 100, 100));
        registration.addItem(new StockItem("D1234", "Whisky", 32.00, 91, 109));

        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println("Expected:");
        System.out.println("A1234 \t\tJin        \t15.99\t\t50  \t\t150");
        System.out.println("B1234 \t\tMartini    \t22.40\t\t42  \t\t158");
        System.out.println("C1234 \t\tVodka      \t39.50\t\t100 \t\t100");
        System.out.println("D1234 \t\tWhisky      \t32.00\t\t91 \t\t109");
        System.out.println("\nActual:");
        System.out.println(registration.formatStockList()); //Print the List
        System.out.println("------------------------------------------------------------------------------\n");

        /* Test 2 Deleting items from the list */
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("               Test 2 : deleteItem()");
        System.out.println("\nDeleting [Jin, Martini] from the StockList\n");

        /* Remove all except C1234 Vodka from the Stock List */
        registration.deleteItem("A1234"); //Deletiing an Item
        registration.deleteItem("B1234"); //Deletiing an Item

        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println("Expected:");
        System.out.println("C1234 \t\tVodka      \t39.50\t\t100 \t\t100");
        System.out.println("D1234 \t\tWhisky      \t32.00\t\t91 \t\t109");
        System.out.println("\nActual:");
        System.out.println(registration.formatStockList());
        System.out.println("------------------------------------------------------------------------------\n");

        /* Test 3 Setting new price to an item in the list */
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("               Test 3 : updateItemPrice()");
        System.out.println("\nSetting new price to [Vodka, Whisky] from the StockList\n");

        /* Updating the prices of the items */
        registration.updateItemPrice("C1234", 99.99); //find ID "C1234" and replace price to 99.99
        registration.updateItemPrice("D1234", 51.50); //find ID "D1234" and replace price to 51.50

        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println("Expected:");
        System.out.println("C1234 \t\tVodka      \t99.99\t\t100 \t\t100");
        System.out.println("D1234 \t\tWhisky      \t51.50\t\t91 \t\t109");
        System.out.println("\nActual:");
        System.out.println(registration.formatStockList());
        System.out.println("------------------------------------------------------------------------------\n");

        /* Test 4 Setting new quantity to an item in the list */
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("               Test 4 : updateItemQuantity()");
        System.out.println("\nSetting new quantity to [Vodka, Whisky] from the StockList\n");

        /* Updating the quantity of the items */
        registration.updateItemQuantity("C1234", 123);
        registration.updateItemQuantity("D1234", 800);

        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println("Expected:");
        System.out.println("C1234 \t\tVodka      \t99.99\t\t123 \t\t100");
        System.out.println("D1234 \t\tWhisky      \t51.50\t\t800 \t\t109");
        System.out.println("\nActual:");
        System.out.println(registration.formatStockList());
        System.out.println("------------------------------------------------------------------------------\n");

        /* Test 5 Setting new Re-order Level to an item in the list */
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("               Test 5 : updateReOrderLevel()");
        System.out.println("\nSetting new Re-Order Level to [Vodka, Whisky] from the StockList\n");

        /* Updationg the Re-order Level of the items */
        registration.updateReOrderLevel("C1234", 901);
        registration.updateReOrderLevel("D1234", 444);

        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println("Expected:");
        System.out.println("C1234 \t\tVodka      \t99.99\t\t123 \t\t901");
        System.out.println("D1234 \t\tWhisky      \t51.50\t\t800 \t\t444");
        System.out.println("\nActual:");
        System.out.println(registration.formatStockList());
        System.out.println("------------------------------------------------------------------------------\n");

        /* Test 6 Testing the method formatReOrderList() from the StockLinkedList.java */
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("               Test 6 : formatReOrderList()");
        System.out.println("\nPrinting elements only if quantity is smaller than reOrderLevel\n");

        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println("Expected:");
        System.out.println("C1234 \t\tVodka      \t99.99\t\t123 \t\t901");
        System.out.println("\nActual:");
        System.out.println(registration.formatReOrderList());
        System.out.println("NOTE: The Whisky had bigger Re-Order Level than Quantity so its not printed");
        System.out.println("------------------------------------------------------------------------------\n");

        /* Test 7 Testing the method saveStockData() */
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("               Test 7 : saveStockData() & loadStockData()");
        System.out.println("\nPrinting elements that are saved in the StockList.dat\n");

        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println("Expected:");
        System.out.println("C1234 \t\tVodka      \t99.99\t\t123 \t\t901\n");
        System.out.println("D1234 \t\tWhisky      \t51.50\t\t800 \t\t444");
        System.out.println("\nActual:");

        //Save the list and then load it
        registration.saveStockData();
        registration.loadStockData("M:\\Year 1\\Semester 2\\ICP 1023 - OOP\\FinalProject\\src\\finalproject\\StockList.dat");

        System.out.println("------------------------------------------------------------------------------\n");

    }

}
