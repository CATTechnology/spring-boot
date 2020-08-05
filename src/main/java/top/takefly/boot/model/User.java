package top.takefly.boot.model;

import lombok.Builder;
import lombok.Data;
import top.takefly.boot.frame.annotation.ExportField;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/13 15:10
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    @ExportField
    private Long id;

    @Column(length = 20)
    @ExportField
    private String name;

    @Column
    @ExportField
    private Integer age;
}
