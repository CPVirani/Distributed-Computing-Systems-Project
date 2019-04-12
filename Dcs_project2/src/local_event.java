import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.math.BigDecimal;
import java.math.BigInteger;

public class local_event {
    synchronized public void start_event(int process_id){

        //System.out.println("Local Event at process:" + process_id);
        Hash_table.getId_table().put(process_id,Hash_table.getId_table().get(process_id).multiply(BigInteger.valueOf(main.process_prime[process_id]))); //incrementing the process's local clock by multiplying the prime number of the process
        //Hash_table.get_log_hashtable().put(process_id,Hash_table.get_log_hashtable().get(process_id).add(log_calculator.get_log(BigDecimal.valueOf(main.process_prime[process_id]))));  //local add of the logarithm prime
        Hash_table.get_log_hashtable().put(process_id,Hash_table.get_log_hashtable().get(process_id).add(ApfloatMath.log(new Apfloat(main.process_prime[process_id],main.precision),main.base_value)));

        part2_array.get_part2_arraylist().add(new compare_objects(Hash_table.getId_table().get(process_id),Hash_table.get_log_hashtable().get(process_id))); //put the objects in the part2 array
        // for first part
//        if(Hash_table.getId_table().get(process_id).compareTo(main.Max_val)==1){
//            main.overflow_proc = process_id;
//            System.exit(0);
//        }
    }
}
