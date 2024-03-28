package exercise;

import com.fasterxml.jackson.core.JsonFactory;
import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.IOException;

// BEGIN
@Getter
@Setter
@AllArgsConstructor

// END
class Car {

    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public static String serialize(Car car) throws IOException {
        return new ObjectMapper().writeValueAsString(car);
    }

    public static Car unserialize(String json) throws IOException {
        Car car = new ObjectMapper().readValue(json, Car.class);
        return car;
    }
    // END

}
