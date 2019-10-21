/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;

import java.io.FileNotFoundException;


public interface StockList {

    /**
     * Adding stock items to the Linked List
     *
     * @param item create and add stock in myStockList
     */
    public void addItem(StockItem item);

    /**
     * Deleting stock items from the Linked List
     *
     * @param itemID check the ID equality and then delete the selected item
     */
    public void deleteItem(String itemID);

    /**
     * Updating the Price to a selected item in the Linked List
     *
     * @param itemID checks the ID equality
     * @param price sets the new Price to the selected item
     */
    public void updateItemPrice(String itemID, double price);

    /**
     * Updating the Quantity of a selected item in the Linked List
     *
     * @param itemID checks the ID equality
     * @param quantity sets the new Quantity number to the selected item
     */
    public void updateItemQuantity(String itemID, int quantity);

    /**
     * Updating the Re-Order Level to a selected item in the Linked List
     *
     * @param itemID checks the ID equality
     * @param reOrderLevel sets the new Re-Order Level to the selected item
     */
    public void updateReOrderLevel(String itemID, int reOrderLevel);

    /**
     * Returns formatted representation of the Linked List
     *
     * @return a formated String to the console screen
     */
    public String formatStockList();

    /**
     * Returns formatted representation of re-order list
     *
     * @return a formated String only for the products that have quantity <
     * reOrderLevel
     */
    public String formatReOrderList();

    /**
     * Creating and saving the file information to a .dat file Exception is
     * needed because we accessing information into a file(..\StockList.dat)
     *
     * @throws FileNotFoundException - If the file its not found
     */
    public void saveStockData() throws FileNotFoundException;

    /**
     * Loading the file from the Directory
     *
     * @param filename to check if the file is existing Exception is needed
     * because we accessing information into a file(..\StockList.dat)
     * @throws FileNotFoundException if the file is not found
     */
    public void loadStockData(String filename) throws FileNotFoundException;
}
