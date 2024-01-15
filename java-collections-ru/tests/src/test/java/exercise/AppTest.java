package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {


    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers0 = List.of(0);
        int expected0 = numbers0.size();
        List<Integer> expectedlist0 = List.of(0);
        List<Integer> actual0 = App.take(numbers0, 1);
        assertThat(actual0.size()).isEqualTo(expected0);
        assertThat(actual0).isEqualTo(expectedlist0);

        List<Integer> numbers1 = List.of(0, 1, 2, 3, 4, 5);
        int expected1 = 3;
        List<Integer> expectedlist1 = List.of(0, 1, 2);
        List<Integer> actual1 = App.take(numbers1, 3);
        assertThat(actual1.size()).isEqualTo(expected1);
        assertThat(actual1).isEqualTo(expectedlist1);
        // END
    }

}
