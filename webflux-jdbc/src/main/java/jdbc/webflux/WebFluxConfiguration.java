package jdbc.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 2018/8/26
 * zhouchao
 */

@Configuration
public class WebFluxConfiguration {

    @Bean
    public RouterFunction<ServerResponse> saveUser(UserHandler userHandler){
        return route(POST("/web/flux/user/save"),userHandler::save);
    }

}
