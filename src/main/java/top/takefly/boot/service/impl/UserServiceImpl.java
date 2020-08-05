package top.takefly.boot.service.impl;

import org.assertj.core.util.Lists;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import top.takefly.boot.dao.UserDao;
import top.takefly.boot.model.User;
import top.takefly.boot.req.Page;
import top.takefly.boot.resp.PageResp;
import top.takefly.boot.service.UserService;

import java.util.List;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/13 15:21
 */
@Service
public class UserServiceImpl implements UserService, InitializingBean {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Cacheable(cacheNames = "t_user")
    public PageResp<User> findByPage(Page page) {
        String direction = page.getDirection();
        Sort sort = StringUtils.isBlank(direction) ? Sort.by(page.getColumn()).ascending() : direction.equals("asc") ? Sort.by(page.getColumn()).ascending() : Sort.by(page.getColumn()).ascending();
        org.springframework.data.domain.Page<User> all = userDao.findAll(PageRequest.of(page.getPage(), page.getSize(), sort));
        PageResp<User> userPageResp = new PageResp<>(all.getContent());
        userPageResp.setCurrentPage(all.getNumber());
        userPageResp.setSize(all.getSize());
        userPageResp.setTotal(all.getTotalElements());
        return userPageResp;
    }

    @Override
    @CachePut(cacheNames = "t_user")
    public List<User> batchInsert() {
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            users.add(new User("dailingfei" + i, i));
        }
        return userDao.saveAll(users);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("userServiceImpl 初始化....");
    }
}
