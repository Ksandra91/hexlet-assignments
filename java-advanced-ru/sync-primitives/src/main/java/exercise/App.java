package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        // BEGIN
        var list = new SafetyList();

        var thred1 = new ListThread(list);
        var thred2 = new ListThread(list);

        thred1.start();
        thred2.start();
        thred1.join();
        thred2.join();

        System.out.println(list.getSize());

        // END
    }
}

