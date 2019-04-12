import java.util.ArrayList;

public class part2_array {
//    public static ArrayList<compare_objects>[] part2_arraylist;
//    public static void initialize_part2_array(int no_of_proc) {
//        //initialize queue for the processes
//        part2_arraylist = new ArrayList[no_of_proc+1];
//        for(int i = 1; i <=no_of_proc; i++) {
//            part2_arraylist[i] = new ArrayList<>();
//        }
//
//    }

    public static ArrayList<compare_objects> part2_arraylist = new ArrayList<>();
    public static ArrayList<compare_objects> get_part2_arraylist(){
        return part2_arraylist;
    }

}
