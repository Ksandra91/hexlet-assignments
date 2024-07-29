package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    @GetMapping
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        return posts.stream()
                .map(this::toDTO)
                .toList();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return toDTO(post);
    }

    private PostDTO toDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setComments(commentsToDTO(post));
        return dto;
    }

    private List<CommentDTO> commentsToDTO(Post post) {
        List<CommentDTO> result = new ArrayList<>();
        var dto = new CommentDTO();
        var comments = commentRepository.findByPostId(post.getId());
        for (var comment : comments) {
            dto.setId(comment.getId());
            dto.setBody(comment.getBody());
            result.add(dto);
        }
        return result;
    }
}
// END
