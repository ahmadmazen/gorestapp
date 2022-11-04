package in.co.gorest.controller;

import in.co.gorest.dto.CommentDto;
import in.co.gorest.dto.PostDto;
import in.co.gorest.service.CommentService;
import in.co.gorest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private in.co.gorest.service.CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> listOfUsers() throws Exception {

        List<CommentDto> comments = commentService.getComments();
        return ResponseEntity.ok().body(comments);
    }
    @GetMapping(value = "/{postId}")
    public ResponseEntity<List<CommentDto>> getPostComments(@PathVariable("postId") Integer postId) throws Exception {

        List<CommentDto> comments = commentService.getPostComments(postId);
        return ResponseEntity.ok().body(comments);
    }
}
