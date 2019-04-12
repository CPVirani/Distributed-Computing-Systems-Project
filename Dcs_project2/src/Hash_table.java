import org.apfloat.Apfloat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Hashtable;

public class Hash_table {
    private static Hashtable<Integer,BigInteger> id_table = new Hashtable<>();
    private static Hashtable<Integer,Apfloat> log_table = new Hashtable<>();

    synchronized public static Hashtable<Integer,BigInteger> getId_table(){
        return id_table;
    }
    synchronized public static Hashtable<Integer,Apfloat> get_log_hashtable(){
        return log_table;
    }
}
