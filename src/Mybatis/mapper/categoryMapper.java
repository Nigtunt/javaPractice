package Mybatis.mapper;

import Mybatis.pojo.category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: YHQ
 * @Date: 2020/2/14 12:09
 */
public interface categoryMapper {
    @Insert(" insert into category_ ( name ) values (#{name}) ")
    int add(category category);

    @Delete(" delete from category_ where id= #{id} ")
    void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    int update(category category);

    @Select(" select * from category_ ")
    List<category> list();
}
