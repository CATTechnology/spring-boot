package top.takefly.boot.frame.attribute;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxy;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/17 15:27
 */
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> resultInfo = super.getErrorAttributes(webRequest, includeStackTrace);
        Map<String, Object> extInfo = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        resultInfo.put("ext", extInfo);
        return resultInfo;
    }
}
