package exercise;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import exercise.model.User;
import exercise.component.UserProperties;

@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();
    @Autowired // Аннотация нужна для автоподстановки объекта
    private UserProperties userInfo;

    // BEGIN
    @GetMapping("/admins")
    public List<String> indexAdmins() {
        List<String> admins = userInfo.getAdmins();
        List<String> result = new ArrayList<>();
        for (String email : admins) {
            var name = users.stream()
                    .filter(u -> u.getEmail().equals(email))
                    .map(User::getName)
                    .findFirst();
            result.add(name.get());
        }
        Collections.sort(result);
        return result;
    }
    // END

    @GetMapping("/users")
    public List<User> index() {
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Long id) {
        var user = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
