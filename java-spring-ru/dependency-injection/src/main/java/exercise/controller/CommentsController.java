package exercise.controller;

import exercise.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment show(@PathVariable long id) {

        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
    }

    @PostMapping(path = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment data) {
        Comment comment = new Comment();
        comment.setPostId(data.getPostId());
        comment.setBody(data.getBody());
        commentRepository.save(comment);

        return comment;
    }

    @PutMapping(path = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment update(@PathVariable long id, @RequestBody Comment data) {

        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        comment.setPostId(data.getPostId());
        comment.setBody(data.getBody());
        commentRepository.save(comment);

        return comment;
    }

    @DeleteMapping(path = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        commentRepository.delete(comment);

    }
}
// END
