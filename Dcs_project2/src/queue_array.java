import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

//public class queue_array {
//    public static Queue<Object[]>[] queues;
//
//    public void initialize_queue(int no_of_proc) {
//        //initialize queue for the processes
//        queues = new Queue[no_of_proc+1];
//        for(int i = 1; i <=no_of_proc; i++) {
//            queues[i] = new LinkedList<>();
//        }
//
//    }
//
//    public static Queue<Object[]>[] get_queue(){
//        return queues;
//    }
//}
public class queue_array {
    public static PriorityBlockingQueue<queue_objects>[] queues;

    public static void initialize_priority_queue(int no_of_proc) {
        //initialize queue for the processes
        queues = new PriorityBlockingQueue[no_of_proc+1];
        for(int i = 1; i <=no_of_proc; i++) {
            queues[i] = new PriorityBlockingQueue<>();
        }

    }

//    public static Queue<Object[]>[] get_queue(){
//        return queues;
//    }
    public static PriorityBlockingQueue<queue_objects>[] get_queue(){
        return queues;
    }
}