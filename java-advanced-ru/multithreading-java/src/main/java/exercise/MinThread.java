package exercise;

// BEGIN
public class MinThread extends Thread {
    public MinThread(int[] array) {
        this.array = array;
    }

    private int[] array;

    public int getMin() {
        return min;
    }

    private int min;

    @Override
    public void run() {
        min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
    }
}
// END
