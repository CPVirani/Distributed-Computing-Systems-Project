import com.sun.org.apache.bcel.internal.generic.BIPUSH;
import org.apfloat.Apfloat;
import org.apfloat.Apint;

import java.math.BigInteger;

public class gcd {
    public static BigInteger get_gcd(BigInteger a, BigInteger b)
    {
        if (a.compareTo(BigInteger.valueOf(0))==0) {
            return b;
        }

        return get_gcd(b.mod(a), a);
    }
    public static BigInteger get_log_gcd(Apint a, Apint b){
        if (a.compareTo(new Apfloat(0,10))==0) {
            return b.toBigInteger();
        }

        return get_log_gcd(b.mod(a),a);

    }
}
