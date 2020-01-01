package jdbc.repository;

import jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * 2018/8/26
 * zhouchao
 */
@Repository
public class UserRepository {

    private final DataSource dataSource;
    private final DataSource masterDataSource;
    private final DataSource slaveDataSource;
    public UserRepository(DataSource dataSource,
                          @Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        this.dataSource = dataSource;
        this.masterDataSource = masterDataSource;
        this.slaveDataSource = slaveDataSource;
    }

    public boolean save(User user) {
        System.out.println("save user: " + user.toString());
        return true;
    }


}
