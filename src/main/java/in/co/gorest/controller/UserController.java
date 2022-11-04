package in.co.gorest.controller;

import in.co.gorest.dto.UserDto;
import in.co.gorest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> listOfUsers() throws Exception {

        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }


}
