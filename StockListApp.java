/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StockListApp {

    public static void main(String[] args) throws FileNotFoundException {
        //Creates a new stockList
        StockList stockList = new StockLinkedList();
        stockList.loadStockData("StockList.dat");
        StockListCLI StockListCLI = new StockListCLI((StockLinkedList) stockList);

        StockListCLI.doMenu();

    }
}
