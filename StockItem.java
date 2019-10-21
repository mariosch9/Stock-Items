/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;

public class StockItem implements java.io.Serializable {

    private String itemID; // Five alpha-numeric characters
    private String itemDesc; // Item description
    private double price; // Item price in pounds sterling
    private int quantity; // Quantity in stock
    private int reOrderLevel; // Level at which to re-order

    public StockItem() {
        itemID = null;
        itemDesc = null;
        price = 0;
        quantity = 0;
        reOrderLevel = 0;
    }

    /**
     * Adding elements to a new stock
     *
     * @param itemID, itemDesc, price, quantity, reOrderLevel adding information
     * to the stock
     */
    public StockItem(String itemID, String itemDesc, double price, int quantity, int reOrderLevel) {
        this.itemID = itemID;
        this.itemDesc = itemDesc;
        this.price = price;
        this.quantity = quantity;
        this.reOrderLevel = reOrderLevel;
    }

    /**
     * Getting the name of the item
     *
     * @return itemID in class StockItem
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Getting a description of the item
     *
     * @return itemDesc in class StockItem
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * Getting the price of the item
     *
     * @return price in class StockItem
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setting the price of the item
     *
     * @param price in class StockItem
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getting the quantity of the item
     *
     * @return quantity in class StockItem
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setting the quantity of the item
     *
     * @param quantity in class StockItem
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getting the re-order level of the item
     *
     * @return reOrderLevel in class StockItem
     */
    public int getReOrderLevel() {
        return reOrderLevel;
    }

    /**
     * Setting the re-order level of the item
     *
     * @param reOrderLevel in class StockItem
     */
    public void setReOrderLevel(int reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    /**
     * Displaying information of the item
     *
     * @return a String representation in a single line
     */
    public String toString() {
        String toStringMessage = " [ITEM = " + getItemID()
                + " , DESCRIPTION = " + getItemDesc() + " , PRICE = " + getPrice()
                + " , QUANTITY = " + getQuantity() + " , RE_ORDER LEVEL = "
                + getReOrderLevel() + "]";

        return getClass().getSimpleName() + toStringMessage;
    }

    /**
     * Displaying information of the item in format style
     *
     * @return returns the output in the below formated way with the appropriate
     * spacing
     */
    public String format() {
        return String.format("%-15s %-15s %-15.2f %-15d %d\n", getItemID(),
                getItemDesc(), getPrice(), getQuantity(), getReOrderLevel());
    }
}
