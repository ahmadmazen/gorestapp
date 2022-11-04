package in.co.gorest.controller;

import in.co.gorest.dto.PostDto;
import in.co.gorest.dto.UserDto;
import in.co.gorest.service.PostService;
import in.co.gorest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService PostService;

    @GetMapping
    public ResponseEntity<List<PostDto>> listOfUsers() throws Exception {

        List<PostDto> posts = PostService.getPosts();
        return ResponseEntity.ok().body(posts);
    }


    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<PostDto>> getUserPosts(@PathVariable("userId") Integer userId) throws Exception {

        List<PostDto> posts = PostService.getUserPosts(userId);
        return ResponseEntity.ok().body(posts);
    }
}
