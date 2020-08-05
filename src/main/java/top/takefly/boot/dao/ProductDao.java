package top.takefly.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.takefly.boot.model.Product;

/**
 * @author 戴灵飞
 */
@Mapper
public interface ProductDao {

    /**
     * 查询列表
     * @param startIdx 开始位置
     * @param pageSize 每页行数
     * @return
     */
    @Select("select * from product limit #{startIdx} , #{pageSize}")
    Product findByPage(@Param("startIdx") Integer startIdx , @Param("pageSize") Integer pageSize);
}
