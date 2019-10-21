/*
 * Marios Christodoulou
 * Java project
 * Final Assignment
 */
package stockitem;


public class ItemIDNotFoundInTheList extends IllegalArgumentException{
    
    /* Constructor */
    public ItemIDNotFoundInTheList(){
        
    }
    
    /**
     * Returns a String Representation of my custom Exception
     * @param str is the custom Exception
     */
    public ItemIDNotFoundInTheList(String str){
        super(str);
    }
}
