package exercise;

// BEGIN
public class MaxThread extends Thread {
    public MaxThread(int[] array) {
        this.array = array;
    }

    private int[] array;

    public int getMax() {
        return max;
    }

    private int max;

    @Override
    public void run() {
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }
}
// END
