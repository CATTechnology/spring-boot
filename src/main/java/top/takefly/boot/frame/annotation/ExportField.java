package top.takefly.boot.frame.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/1/29.
 */
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface ExportField {
    boolean needExport()  default true;
}
