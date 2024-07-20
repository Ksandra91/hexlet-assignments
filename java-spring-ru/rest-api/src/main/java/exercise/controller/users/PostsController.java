package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")

public class PostsController {
    List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")

    public List<Post> show(@PathVariable Integer id) {
        var result = posts.stream()
                .filter(p -> p.getUserId() == id)
                .toList();
        return result;
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable Integer id, @RequestBody Post data) {
        Post post = new Post();
        post.setUserId(id);
        String body = data.getBody();
        String slug = data.getSlug();
        String title = data.getTitle();
        post.setBody(body);
        post.setSlug(slug);
        post.setTitle(title);
        posts.add(post);
        return post;
    }

}