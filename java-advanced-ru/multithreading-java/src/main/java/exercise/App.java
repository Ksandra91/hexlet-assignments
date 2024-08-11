package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) throws InterruptedException {

        MinThread minThread = new MinThread(array);
        MaxThread maxThread = new MaxThread(array);
        minThread.start();
        minThread.join();
        maxThread.start();
        maxThread.join();

        Map<String, Integer> res = new HashMap<>();
        res.put("max", maxThread.getMax());
        res.put("min", minThread.getMin());
        return res;
    }

//    public static void main(String[] args) throws InterruptedException {
//        var res = getMinMax(new int[]{1,2,3,4,5});
//        System.out.println(res);
//    }
    // END
}
