/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;


public class ItemIDAlreadyExistInLinkedList extends IllegalArgumentException{
    
    /* Constructor */
    public ItemIDAlreadyExistInLinkedList(){
    
    }
    
    /**
     * Returns a String Representation of my custom Exception
     * @param str is the custom Exception
     */
    public ItemIDAlreadyExistInLinkedList(String str){
        super(str); 
    }
    
    
}
