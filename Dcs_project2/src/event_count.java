import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class event_count {
    private static int[] count_array = new int[main.inp_processes + 1];
    public static int j = 0;
    public static int x = 0;
    public static int k = 0;

    synchronized public static int increment_Count(int process_id) {
        ++count_array[process_id];
        ++j;

        if(j==(main.inp_processes*50)+1) {
            //for second part
            System.out.println("max number of events reached");
            System.exit(0);
//            //for first part
//            System.out.println(Hash_table.getId_table());
//            //non_static_Hashtable abcd = new non_static_Hashtable();
//            array_of_hash.getArray_of_hash().add(Hash_table.getId_table().clone());
//
//            System.out.println(array_of_hash.getArray_of_hash());
//            //x=0;
        }

        System.out.println("events executed:="+j);
//        System.out.println(Hash_table.getId_table());
//        System.out.println(Hash_table.get_log_hashtable());
        return j;
    }
//

        public static int[] getCount_array () {
            return count_array;
        }
    }

