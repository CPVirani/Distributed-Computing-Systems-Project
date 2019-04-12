import java.util.Random;

public class rand_num_gen_class {
    public int rand_num_gen_func(int exception){
        int random_num;
        while(true) {
            main main_obj = new main();
            int rand_min = 1;
            int rand_max = main_obj.get_inp_processes();
            Random rand = new Random();
            random_num = rand.nextInt((rand_max - rand_min) + 1) + rand_min;
            if (random_num!=exception){
                break;
            }
        }

        return random_num;
    }

}
