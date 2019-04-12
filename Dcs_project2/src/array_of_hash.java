import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class array_of_hash {
    private static List<Object> array_of_hash = new ArrayList<>();
//    private HashMap<Integer,Hashtable<Integer,BigInteger>> array_of_maps = new HashMap<>();
//    private static TreeMap<Integer,Hashtable<Integer,BigInteger>> array_of_tree = new TreeMap<>();

    synchronized static List<Object> getArray_of_hash(){
        return array_of_hash;
    }
}
