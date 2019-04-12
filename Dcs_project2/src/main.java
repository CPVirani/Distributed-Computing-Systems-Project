import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;

import static org.apfloat.ApfloatMath.log;

public class main {
    static int inp_processes;
    static int no_of_events;
    int get_inp_processes(){
        return inp_processes;
    }
    public int get_no_of_events(){
        return no_of_events;
    }
    public static long[] process_prime;
    public static BigInteger Max_val ;
    public static int overflow_proc;
    public static int mantissa_size;
    public static int false_negative=0;
    public static int false_positive=0;
    public static int true_negative=0;
    public static int true_positive=0;
    public static int total_loop_events = 0;
    public static int precision;
    public static long prime_no;
    public static Apfloat base_value;

    public static void main(String[] args) {

        prime_gen pr_gen = new prime_gen();
//      Get the number of processes from the user
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        inp_processes = sc.nextInt();
        // Get mantissa size from the user
        System.out.println("Enter the mantissa size");
        int mantissa = sc.nextInt();
        mantissa_size = ((new BigInteger("2").pow(mantissa)).toString().length());
        System.out.println("Enter the base value");
        base_value = new Apfloat(sc.nextInt());
        //System.out.println("mantissa size" + mantissa_size);
        precision = mantissa_size;

        //Max_val = new BigInteger("2").pow(((inp_processes*32)-1));        //max value of the overflowing process(Part 1)
        process_prime = new long[inp_processes+1];

        //initialize queues for processes
        queue_array.initialize_priority_queue(inp_processes);

        //initialize hash_table, process_prime array and log_hash_table
        for(int i = 1; i<=inp_processes;i++){
            prime_no = pr_gen.prime_gen();
            process_prime[i] = prime_no;
            Hash_table.getId_table().put(i, BigInteger.valueOf(prime_no));
            Hash_table.get_log_hashtable().put(i,ApfloatMath.log(new Apfloat(prime_no,precision),base_value));
        }

        //start the entered number of threads
        for(int i = 1; i<=inp_processes;i++){
            Thread t = new Thread(new gen_thread(i));
            t.start();
        }
        //for part 1 to check if a a process's evc value has overflown
//        new Thread(){
//            public void run(){
//                while (true) {
//                    for (overflow_proc=1;overflow_proc<=inp_processes;overflow_proc++) {
//                        if(Hash_table.getId_table().get(overflow_proc).compareTo(main.Max_val)==1){
//                            System.out.println("OVERFLOWN PROCESS!="+ overflow_proc);
//                            System.exit(0);
//                        }
//
//                    }
//                }
//            }
//        }.start();


        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){      //after the program terminates
                //System.out.println("OVERFLOWN PROCESS!="+ overflow_proc);         //for part 1
                System.out.println("original hashtable"+Hash_table.getId_table());
                System.out.println("log_hash_table"+Hash_table.get_log_hashtable());
                System.out.println("total events at each process"+Arrays.toString(event_count.getCount_array()));
                int j = 0;
                for(int i:event_count.getCount_array()){
                    j = j+i;
                }
                System.out.println("Total number of events="+ j);

                for(int x = 0 ; x<=part2_array.get_part2_arraylist().size();x++){
                    for(int y = x+1 ; y<=part2_array.get_part2_arraylist().size(); y++){

                        ++total_loop_events;
                        try{
                            if((part2_array.get_part2_arraylist().get(x).getEvc_val().compareTo(part2_array.get_part2_arraylist().get(y).getEvc_val()))==1){
                                if((part2_array.get_part2_arraylist().get(x).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==-1){
                                    ++false_negative;
                                }
                                else if((part2_array.get_part2_arraylist().get(x).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==1){
                                    ++true_positive;
                                }
                            }
                            else if((part2_array.get_part2_arraylist().get(x).getEvc_val().compareTo(part2_array.get_part2_arraylist().get(y).getEvc_val()))==-1){
                                if((part2_array.get_part2_arraylist().get(x).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==1){
                                    ++false_positive;
                                }
                                else if((part2_array.get_part2_arraylist().get(x).getLog_evc_val().compareTo(part2_array.get_part2_arraylist().get(y).getLog_evc_val()))==-1){
                                    ++true_negative;
                                }
                            }
                        }
                        catch (IndexOutOfBoundsException|NullPointerException e){
                            break;
                        }

                    }
                }
                System.out.println("-------------------------------------");
                System.out.println("False Negative count" + false_negative);
                System.out.println("False positive count" + false_positive);
                System.out.println("-------------------------------------");
                System.out.println("FN Error%: " + (((float)false_negative)/(false_negative+true_positive))*100);
                System.out.println("FP Error%: " + (((float)false_positive)/(false_positive+true_negative))*100);
//
//                System.out.println("true negative count" + true_negative);
//                System.out.println("true positive count" + true_positive);
                System.out.println("no of processes: " + inp_processes);
                System.out.println("Mantissa bit size: " + mantissa);
                System.out.println("base value: " + base_value);
                System.out.println("total: "+total_loop_events);



//                for(int i = 0;i<array_of_hash.getArray_of_hash().size();i++) {        //for evc values of overflown process (Part 1)
//                    Hashtable<Integer, BigInteger> hashtable = (Hashtable<Integer, BigInteger>) array_of_hash.getArray_of_hash().get(i);
//                    double a = (Math.log(hashtable.get(overflow_proc).doubleValue()))/Math.log(10);
//                    System.out.println(((double)(Math.round(a*100)))/100);
//                    //System.out.println(hashtable.get(overflow_proc));
//                }
            }
        });

    }

}

