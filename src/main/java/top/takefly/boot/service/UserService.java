package top.takefly.boot.service;

import top.takefly.boot.model.User;
import top.takefly.boot.req.Page;
import top.takefly.boot.resp.PageResp;

import java.util.List;

/**
 * @author dailingfei
 */
public interface UserService {

    /**
     * 分页查询
     * @param page 分页实体
     * @return
     */
    PageResp<User> findByPage(Page page);

    /**
     * 批量插入
     * @return
     */
    List<User> batchInsert();
}
