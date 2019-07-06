package jdbc.repository;

import jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * 2018/8/26
 * zhouchao
 */
@Repository
public class UserRepository {

    private final DataSource dataSource;

    @Autowired
    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public boolean save(User user) {
        System.out.println("save user: " + user.toString());
        return true;
    }


}
