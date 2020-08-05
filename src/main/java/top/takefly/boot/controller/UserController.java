package top.takefly.boot.controller;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.takefly.boot.frame.utils.ExcelUtil;
import top.takefly.boot.model.User;
import top.takefly.boot.req.Page;
import top.takefly.boot.resp.PageResp;
import top.takefly.boot.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/13 15:24
 */
@RestController
public class UserController implements InitializingBean {

    private static final String EXCEL_NAME = "红包活动提现";

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public PageResp<User> list(Page page) {
        return userService.findByPage(page);
    }

    @GetMapping("/batchInsert")
    public List<User> batchInsert() {
        return userService.batchInsert();
    }

    @GetMapping("/export")
    public void exportData(Page page, HttpServletResponse response) throws IOException {
        PageResp<User> users = userService.findByPage(page);
        List<?> data = users == null ? Lists.newArrayList() : users.getContent();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String formatDate = simpleDateFormat.format(new Date());
        new ExcelUtil("红包数据导出", new String[]{"id", "name", "age"}, data, EXCEL_NAME + formatDate + ".xlsx").export(response);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserController's:" + userService);
    }
}
