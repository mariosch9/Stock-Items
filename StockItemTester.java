/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;

public class StockItemTester {

    public static void main(String[] args) {
        String RED = "\u001B[31m"; //Color RED
        String BLUE = "\u001B[34m"; //Color BLUE

        //Test 1.1 - Testing the get methods:
        /* Create a new item  */
        StockItem item1 = new StockItem("A1234", "Water", 0.75, 200, 500);

        System.out.println("|-----------------------------------------------------------------|");
        System.out.println("|      Testing each GET/SET method      |  EXPECTED  |  ACTUAL    |");
        System.out.println("|-----------------------------------------------------------------|");
        System.out.println(RED + "|                    item1.getItemID()  |   A1234    |   " + item1.getItemID() + "    |");
        System.out.println(RED + "|                  item1.getItemDesc()  |   Water    |   " + item1.getItemDesc() + "    |");
        System.out.println(RED + "|---------------------------------------|------------|------------|");
        System.out.println(RED + "|                     item1.getPrice()  |  £ 00.75   |  £ 0" + item1.getPrice() + "   |");
        System.out.println(RED + "|                  item1.getQuantity()  |   200      |   " + item1.getQuantity() + "      |");
        System.out.println(RED + "|              item1.getReOrderLevel()  |   500      |   " + item1.getReOrderLevel() + "      |");

        //Test 1.2 - Testing the set methods:
        /* Setting new information to the stock item */
        item1.setPrice(1.25);
        item1.setQuantity(700);
        item1.setReOrderLevel(150);

        System.out.println(BLUE + "|---------------------------------------|------------|------------|");
        System.out.println(BLUE + "|               item1.setPrice(aPrice)  |  £ 01.25   |  £ 0" + item1.getPrice() + "   |");
        System.out.println(BLUE + "|         item1.setQuantity(aQuantity)  |   700      |   " + item1.getQuantity() + "      |");
        System.out.println(BLUE + "| item1.setReOrderLevel(aReOrderLevel)  |   150      |   " + item1.getReOrderLevel() + "      |");
        System.out.println(BLUE + "|-----------------------------------------------------------------|");

        System.out.println();

        //Test 2 - Testing the toString method:
        /* Create another item */
        StockItem item2 = new StockItem("B1234", "Juice", 1.99, 882, 798);

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("\t    Testing the toString method");
        System.out.println("\t    ***************************");
        System.out.println(RED + " EXPECTED:");
        System.out.println("StockItem [ITEM = A1234 , DESCRIPTION = Water , PRICE = 1.25 , QUANTITY = 700 , RE_ORDER LEVEL = 150]");
        System.out.println("StockItem [ITEM = B1234 , DESCRIPTION = Juice , PRICE = 1.99 , QUANTITY = 882 , RE_ORDER LEVEL = 798]");

        System.out.println();

        System.out.println(BLUE + " ACTUAL:");
        System.out.println(item1.toString());
        System.out.println(item2.toString());
        System.out.println("------------------------------------------------------------------------------------------------------");

        System.out.println();

        //Test 3 - Testing the format method:
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\t    Testing the format method");
        System.out.println("\t    *************************\n");
        System.out.println("ItemID\t\tDescription\tPrice\t\tQnty\t\tRe-Order Level");
        System.out.println("******\t\t***********\t*****\t\t****\t\t**************");
        System.out.println(item1.format());
        System.out.println(item2.format());
        System.out.println("--------------------------------------------------------------------------------");
    }

}
