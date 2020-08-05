package top.takefly.boot.frame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/17 14:00
 * 全局异常处理器
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 浏览器和其他客户端都返回了json 数组，不满足自适应
     * @param ex
     * @param response
     * @return
     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
    public Map<Object, Object> handleNullPointException(NullPointerException ex, HttpServletResponse response) {
        Map result = new HashMap(16);
        result.put("code", "999");
        result.put("succeed", false);
        result.put("msg", "空指针异常!!!");
        result.put("data", null);

        return result;
    }

    /**
     * 处理请求异常请求，使响应能够自适应浏览器和postman等请求工具
     * 借助springboot提供的异常处理
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(NullPointerException ex, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        ex.printStackTrace();
        return "forward:/error";
    }
}
