package jdbc.controller;

import jdbc.domain.User;
import jdbc.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 2018/8/26
 * zhouchao
 */
@RestController
public class UserController {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @PostMapping("/web/mvc/user/save")
    public boolean save(@RequestBody User user) throws ExecutionException, InterruptedException {
        Future<Boolean> future = executorService.submit(()-> userRepository.save(user));
        return future.get();
    }
}
