package top.takefly.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.takefly.boot.model.User;

/**
 * @author Admin
 */
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
}
