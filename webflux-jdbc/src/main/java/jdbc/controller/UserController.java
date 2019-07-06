package jdbc.controller;

import jdbc.domain.User;
import jdbc.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/8/26
 * zhouchao
 */
@RestController
public class UserController {

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @PostMapping("/web/mvc/user/save")
    public boolean save(@RequestBody User user){
        return userRepository.save(user);
    }
}
