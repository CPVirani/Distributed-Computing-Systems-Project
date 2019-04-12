import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.acl.LastOwnerException;


public class lcm_class {
    synchronized public static BigInteger get_lcm(BigInteger x, BigInteger y){

        return (x.multiply(y)).divide(gcd.get_gcd(x,y));
    }
    synchronized public static Apfloat get_log_lcm(Apfloat x, Apfloat y){
        return (x.add(y)).subtract(ApfloatMath.log(new Apfloat(gcd.get_log_gcd(ApfloatMath.pow(main.base_value,x).ceil(),ApfloatMath.pow(main.base_value,y).ceil()),main.precision),main.base_value));

            //return (x.add(y)).subtract(ApfloatMath.log(new BigDecimal(gcd.get_gcd((BigDecimal.valueOf(Math.pow(log_calculator.base_value,x.doubleValue())).toBigInteger()),(BigDecimal.valueOf(Math.pow(log_calculator.base_value,y.doubleValue())).toBigInteger())).toString())));




    }
}

