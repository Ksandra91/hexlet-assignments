package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post show(@PathVariable long id) {

        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping(path = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post data) {
        Post post = new Post();
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());

        postRepository.save(post);

        return post;
    }

    @PutMapping(path = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@PathVariable long id, @RequestBody Post data) {

        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        post.setBody(data.getBody());
        post.setTitle(data.getTitle());
        postRepository.save(post);
        return post;
    }

    @DeleteMapping(path = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        postRepository.delete(post);
        commentRepository.deleteByPostId(id);
    }
}
// END
