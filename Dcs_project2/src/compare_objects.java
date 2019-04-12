import org.apfloat.Apfloat;

import java.math.BigDecimal;
import java.math.BigInteger;

public class compare_objects {
    private Apfloat log_evc_val;
    private BigInteger evc_val;

    public compare_objects(BigInteger evc, Apfloat log_evc){
        evc_val = evc;
        log_evc_val = log_evc;
    }
    synchronized public BigInteger getEvc_val(){
        return evc_val;
    }
    synchronized public Apfloat getLog_evc_val(){
        return log_evc_val;
    }
}
