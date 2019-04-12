import com.sun.org.apache.xpath.internal.operations.String;
import org.apfloat.Apfloat;

import javax.print.attribute.HashAttributeSet;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class gen_thread implements Runnable {
    public int process_id;
    public int count = 0;
    public int event_ID;


    public gen_thread(int pro_no) {
        this.process_id = pro_no;
    }



    synchronized public void set_queue() {
        Object[] objects_array;
        main m = new main();
        Random rand = new Random();

        while(true){
            count++;
            int probability;
            double r = rand.nextDouble();
            if (r <= .4) {
                probability = 1;
            } else {
                probability = 2;
            }
            if (probability == 1) {
                queue_array.get_queue()[process_id].add(new queue_objects(0,System.currentTimeMillis(),new BigInteger("0"),0, new Apfloat(0)));
            } else if (probability == 2) {
                queue_array.get_queue()[process_id].add(new queue_objects(1,System.currentTimeMillis(),new BigInteger("0"),0,new Apfloat(0)));
            }
            if(count==2){
                try {
                    //System.out.println(count);
                    Thread.sleep(1000);
                    count=0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
//        for (int i = 1; i <= m.get_no_of_events(); i++) {    //for loop to add events to the queue
//            int probability;
//            double r = rand.nextDouble();
//            if (r <= .4) {
//                probability = 1;
//            } else {
//                probability = 2;
//            }
//            if (probability == 1) {
//                queue_array.get_queue()[process_id].add(new queue_objects(0,System.currentTimeMillis(),0));
//            } else if (probability == 2) {
//                queue_array.get_queue()[process_id].add(new queue_objects(1,System.currentTimeMillis(),0));
//            }
//            try {
//                TimeUnit.MILLISECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }






    synchronized public void run() {
        new Thread(){
            public void run(){
                gen_thread set_queue_obj = new gen_thread(process_id);
                set_queue_obj.set_queue();
            }
        }.start();

        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        local_event local_event = new local_event();
        send_event send_event = new send_event();
        receive_event receive_event = new receive_event();


        //prime_gen pr_gen = new prime_gen();


        //System.out.println("send and local events of queue_"+process_id+"="+queue_array.get_queue()[process_id]);

        while (true) {
            //remove each event from the queue
            //*Object a[] = queue_array.get_queue()[process_id].remove();

                try{
                    queue_objects a = queue_array.get_queue()[process_id].poll();
                    if (a.get_event_ID()==0){
                        //System.out.println("Local event at process: "+process_id);
                        event_count.increment_Count(process_id);
                        local_event.start_event(process_id);

                        try {   //gap between the events
                            Thread.sleep(1*10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //System.out.println("local time::"+a.getTime());
                    }
                    else if(a.get_event_ID()==1){
                        //System.out.println("Send event at process: "+process_id);
                        event_ID=event_count.increment_Count(process_id);
                        send_event.start_event(process_id,event_ID);
                        //System.out.println("send time::"+a.getTime());
                        try {   //gap between the events
                            Thread.sleep(1*10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else if (a.get_event_ID()==2){
                        //System.out.println("Receive event at process: "+process_id);
                        event_count.increment_Count(process_id);
                        //System.out.println("receive event time at process:"+process_id+"="+a.getTime());
                        receive_event.start_event(process_id,a.get_evc_stamp(),a.getSender_id(),a.getLog_evc());

                        try {   //gap between the events
                            Thread.sleep(1*10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
            }
            catch (NoSuchElementException|NullPointerException e){
                try {   //if no element found in the queue
                    Thread.sleep(1);
                } catch (InterruptedException f) {
                    f.printStackTrace();
                }
            }




            //            if (a[0] instanceof Integer){
//                int b = (Integer) a[0];
//                //System.out.println(b);
//                if (b == 1) {   //if send event in the queue
//                    send_event.start_event(process_id);
//                } else if (b == 0) {    //if local event in the queue
//                    local_event.start_event(process_id);
//                }
//            }
//            else{
//                System.out.println("no event in the queue");
//            }
//            if(a[1] instanceof Long){
//                System.out.println("system_time::"+a[1]);
//            }
            //System.out.println((a.get_event_ID()));
        }






         //increment destination process clock value


//        System.out.println("thread "+ process_id +": "+ pr_gen.prime_gen()); // generate prime number for each process

//        int i = 2;
//        id_table.put(process_id,i);
//        for (int i = 1; i <= 100; i++) {
//            if (prchk.is_prime(i)){
//                System.out.println(process_id*i);
//            }

    }
}
