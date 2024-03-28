package exercise;

import com.sun.jdi.Value;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();

        List<String> notValidFields = new ArrayList<>();
        try {
            for (var field : fields) {
                Object notNull = field.getAnnotation(NotNull.class);
                if (notNull != null) {
                    field.setAccessible(true);
                    Object value = field.get(address);
                    String name = field.getName();
                    if (value == null) {
                        notValidFields.add(name);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> notValidFields = new HashMap<>();
        try {
            for (var field : fields) {
                Object notNull = field.getAnnotation(NotNull.class);
                MinLength minLength = field.getAnnotation(MinLength.class);
                if (notNull != null && minLength != null) {
                    field.setAccessible(true);
                    Object value = field.get(address);
                    String name = field.getName();
                    int len = minLength.minLength();
                    if (value == null) {
                        notValidFields.put(name, List.of("can not be null"));
                    }
                    if (len != String.valueOf(value).length()) {
                        notValidFields.put(name, List.of("length less than " + len));
                    }
                } else if (notNull != null) {
                    field.setAccessible(true);
                    Object value = field.get(address);
                    String name = field.getName();
                    if (value == null) {
                        notValidFields.put(name, List.of("can not be null"));
                    }

                } else if (minLength != null) {
                    field.setAccessible(true);
                    Object value = field.get(address);
                    String name = field.getName();
                    int len = minLength.minLength();
                    if (len != String.valueOf(value).length()) {
                        notValidFields.put(name, List.of("length less than " + len));
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return notValidFields;

    }

    public static void main(String[] args) throws IllegalAccessException {
//        Address address = new Address(null, "London", "1-st street", "7", null);
//        List<String> notValidFields = Validator.validate(address);
//        System.out.println(notValidFields); // => [country]
//
//        Address address2 = new Address("England", null, null, "7", "2");
//        List<String> notValidFields2 = Validator.validate(address2);
//        System.out.println(notValidFields2); // => [city, street]
//    }

        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
        System.out.println(notValidFields); // =>  {country=[length less than 4], street=[can not be null]}


    }
}
// END
