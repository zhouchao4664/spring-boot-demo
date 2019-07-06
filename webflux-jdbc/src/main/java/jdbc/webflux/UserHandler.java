package jdbc.webflux;

import org.springframework.stereotype.Component;

/**
 * 2018/8/26
 * zhouchao
 */
@Component
public class UserHandler {

//    private final UserRepository userRepository;
//
//    public UserHandler(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//    public Mono<ServerResponse> save(ServerRequest serverRequest){
//
//        Mono<User> userMono = serverRequest.bodyToMono(User.class);
//
//        Mono<Boolean> booleanMono = userMono.map(userRepository::save);
//
//        return ServerResponse.ok().body(booleanMono,Boolean.class);
//    }

}
