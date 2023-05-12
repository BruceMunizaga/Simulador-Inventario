package cl.ucn.disc.pa.beattherhythm.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    /**
     * Add theObject to theStaticArray.
     *
     * @param theStaticArray the array.
     * @param theObject      the object to append.
     * @param <T>            generic to use.
     * @return the static array.
     */
    public static <T> T[] append(T[] theStaticArray, T theObject) {
        // new arraylist
        List<T> theList = new ArrayList<>();
        // copy all the items from [] to the list
        Collections.addAll(theList, theStaticArray);
        // add the object
        theList.add(theObject);
        // return the static array
        return theList.toArray(theStaticArray);
    }
}
