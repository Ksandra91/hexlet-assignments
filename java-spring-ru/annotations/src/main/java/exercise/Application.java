package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

import java.lang.reflect.Method;


public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);
        // BEGIN
        // Итерируем все методы класса
        for (Method method : Address.class.getDeclaredMethods()) {

            // Проверяем, есть ли у метода аннотация @LogExecutionTime
            if (method.isAnnotationPresent(Inspect.class)) {

                String name = method.getName();
                String type = method.getReturnType().getSimpleName();
                System.out.println("Method " + name + " returns a value of type " + type);// END
            }

        }
    }
}
