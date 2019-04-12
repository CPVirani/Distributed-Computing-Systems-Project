import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.math.BigDecimal;
import java.math.BigInteger;

public class send_event {

    synchronized public void start_event(int process_id,int send_id){
    //Send event

        rand_num_gen_class rand_num_obj = new rand_num_gen_class();
        //System.out.println("Send Event at process:"+process_id+" with id:"+send_id);

        Hash_table.getId_table().put(process_id,Hash_table.getId_table().get(process_id).multiply(BigInteger.valueOf(main.process_prime[process_id]))); //Local process clock increment
        Hash_table.get_log_hashtable().put(process_id,Hash_table.get_log_hashtable().get(process_id).add(ApfloatMath.log(new Apfloat(main.process_prime[process_id],main.precision),main.base_value)));


        //Hash_table.get_log_hashtable().put(process_id,Hash_table.get_log_hashtable().get(process_id).add(log_calculator.get_log(BigDecimal.valueOf(main.process_prime[process_id]))));
        part2_array.get_part2_arraylist().add(new compare_objects(Hash_table.getId_table().get(process_id),Hash_table.get_log_hashtable().get(process_id))); // put compare object in the part2_array
        // for first part
//        if(Hash_table.getId_table().get(process_id).compareTo(main.Max_val)==1){
//            main.overflow_proc = process_id;
//            System.exit(0);
//        }
        int destination_process_id = rand_num_obj.rand_num_gen_func(process_id); // randomly generate a destination process id
        //System.out.println("sender_id:" + process_id);
        //System.out.println("Send event from process:"+process_id+" to destination Process:" + destination_process_id);
        queue_array.get_queue()[destination_process_id].add(new queue_objects(2,System.currentTimeMillis()+10,Hash_table.getId_table().get(process_id),send_id,Hash_table.get_log_hashtable().get(process_id)));
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException f){
            f.printStackTrace();
        }

}
}
