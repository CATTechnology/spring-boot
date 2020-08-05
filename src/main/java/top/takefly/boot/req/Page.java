package top.takefly.boot.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/23 15:47
 */
@Data
public class Page implements Serializable {
    private int page;
    private int size;
    private String column;
    private String direction;
}
