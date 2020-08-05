package top.takefly.boot.resp;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/24 10:50
 */
@Data
public class PageResp<T> {

    public PageResp() {
    }

    public PageResp(List<T> content) {
        this.content = content;
    }

    /**
     * 总元素
     */
    private long total;
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 页面元素个数
     */
    private int size;
    /**
     * 内容
     */
    private List<T> content;
}
