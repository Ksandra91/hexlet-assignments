package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {
        try {
            int s = (int) Math.round(circle.getSquare());
            System.out.println(s);
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }

}
// END
