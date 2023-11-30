package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 菜品管理
 */
@Mapper
public interface DishMapper {

    @Select("select count(id) from dish where category_id = #{id}")
    Integer getNumByCategory(Long id);
}
