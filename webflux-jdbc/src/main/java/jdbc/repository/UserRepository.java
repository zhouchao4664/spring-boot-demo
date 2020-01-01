package jdbc.repository;

import jdbc.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 2018/8/26
 * zhouchao
 */
@Repository
public class UserRepository {

    private final DataSource dataSource;
    private final DataSource masterDataSource;
    private final DataSource slaveDataSource;
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager platformTransactionManager;

    public UserRepository(DataSource dataSource,
                          @Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("slaveDataSource") DataSource slaveDataSource,
                          JdbcTemplate jdbcTemplate,
                          PlatformTransactionManager platformTransactionManager) {
        this.dataSource = dataSource;
        this.masterDataSource = masterDataSource;
        this.slaveDataSource = slaveDataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.platformTransactionManager = platformTransactionManager;
    }

    public boolean saveInJdbc(User user) {
        System.out.println("save user: " + user.toString());
        return true;
    }

//    @Transactional
    public boolean save(User user) {
        Boolean success = false;

        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus =platformTransactionManager.getTransaction(defaultTransactionDefinition);

        success = jdbcTemplate.execute("INSERT INTO user(name) VALUES (?);", new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement .setString(1,user.getName());
                return preparedStatement.executeUpdate() > 0;
            }
        });

        platformTransactionManager.commit(transactionStatus);
        return success;
    }


}
