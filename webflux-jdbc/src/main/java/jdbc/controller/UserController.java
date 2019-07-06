package jdbc.controller;

import com.zhouchao.springbootdemo.jdbc.domain.User;
import com.zhouchao.springbootdemo.jdbc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 2018/8/26
 * zhouchao
 */
@Controller
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
