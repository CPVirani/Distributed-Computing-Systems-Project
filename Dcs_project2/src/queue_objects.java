import org.apfloat.Apfloat;

import java.math.BigDecimal;
import java.math.BigInteger;

public class queue_objects implements Comparable<queue_objects> {
    private int event_id;
    private long event_time;
    private BigInteger evc_stamp;
    private int sender_id;
    private Apfloat log_evc;

    public queue_objects(int id, long time, BigInteger evc, int send_id, Apfloat log_evc_value){
        event_id=id;
        event_time=time;
        evc_stamp = evc;
        sender_id = send_id;
        log_evc = log_evc_value;

    }
    synchronized public int get_event_ID(){
        return event_id;
    }
    synchronized public long getTime(){
        return event_time;
    }
    synchronized public BigInteger get_evc_stamp(){
        return evc_stamp;
    }
    synchronized public int getSender_id(){
        return sender_id;
    }
    synchronized public Apfloat getLog_evc(){
        return log_evc;
    }
    synchronized public boolean equals(queue_objects other){
        return  this.getTime()==other.getTime();
    }


    @Override
    synchronized public int compareTo(queue_objects other) {
        if(this.equals(other)){
            return 0;
        }
        else if(getTime()>other.getTime())
        {
            return -1;
        }
        return 1;
    }
}
