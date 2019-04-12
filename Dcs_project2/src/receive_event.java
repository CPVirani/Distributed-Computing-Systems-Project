import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.math.BigDecimal;
import java.math.BigInteger;

public class receive_event {
    synchronized public void start_event(int process_id, BigInteger evc, int sender_id, Apfloat sender_log_evc){
        //System.out.println("Receive event at process:"+process_id+" from sender ID:"+sender_id);


        try {
            Hash_table.getId_table().put(process_id,lcm_class.get_lcm(Hash_table.getId_table().get(process_id),evc).multiply(BigInteger.valueOf(main.process_prime[process_id])));
            Hash_table.get_log_hashtable().put(process_id,lcm_class.get_log_lcm(Hash_table.get_log_hashtable().get(process_id),sender_log_evc).add(ApfloatMath.log(new Apfloat(main.process_prime[process_id],main.precision))));
            //Hash_table.get_log_hashtable().put(process_id,lcm_class.get_log_lcm(Hash_table.get_log_hashtable().get(process_id).add(log_calculator.get_log(BigDecimal.valueOf(main.process_prime[process_id]))),sender_log_evc));
            part2_array.get_part2_arraylist().add(new compare_objects(Hash_table.getId_table().get(process_id),Hash_table.get_log_hashtable().get(process_id)));
            //for first part
//            if(Hash_table.getId_table().get(process_id).compareTo(main.Max_val)==1){
//                main.overflow_proc = process_id;
//                System.exit(0);
//            }
        }
        catch (NullPointerException e) {
            try {
                Thread.sleep(1 * 1000);
            }
            catch (InterruptedException f){
                f.printStackTrace();
            }

        }


    }
}
