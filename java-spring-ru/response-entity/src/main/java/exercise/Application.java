package exercise;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    ResponseEntity<List<Post>> x(@RequestParam(defaultValue = "10") Integer limit, @RequestParam(defaultValue = "1") Integer page) {
        // return posts.stream().limit(limit).toList();
        List<Post> result = new ArrayList<>();
        int start = 0;
        int end;
        if (page != 1) {
            start = (page * limit) - limit;
        }
        if ((page * limit) + limit > posts.size()) {
            end = (page * limit) + (posts.size() - limit);
        } else end = (page * limit) + limit;


        for (int i = start; i <= end; i++) {
            result.add(posts.get(i));
        }
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(result);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> show(@PathVariable String id) {
        var post = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (post.isPresent()) {
            return ResponseEntity.of(post);
        } else return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(null);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        var findPost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (findPost.isPresent()) {
            var post = findPost.get();
            post.setId(data.getId());
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
            return ResponseEntity.ok(data);

        }
        return ResponseEntity.status(204).body(null);
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {

        posts.removeIf(p -> p.getId().equals(id));
    }
}
