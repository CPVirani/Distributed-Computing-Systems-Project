import jdk.nashorn.internal.objects.Global;

import java.math.BigInteger;

public class prime_gen {
    prime_check prchk = new prime_check();
    public static volatile int j = 1;
    public static BigInteger b;

    synchronized public int prime_gen() {
        j++;
        while(true) {
            if (prchk.is_prime(j)) {
                break;

            } else {
                j++;
            }
        }

        return j;
    }
}

