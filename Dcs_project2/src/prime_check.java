public class prime_check {
    public synchronized boolean is_prime(int num){
        boolean val=true;
        int temp = num/2;
        if (num>3){
            for (int i=2;i<=temp;i++){
                if (num%i==0){
                    val = false;
                }

            }
        }
        if (num<=3){
            val=true;
        }
        return  val;
    }

}
