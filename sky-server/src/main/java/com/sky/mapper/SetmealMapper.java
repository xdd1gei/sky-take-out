package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 套餐管理
 */
@Mapper
public interface SetmealMapper {

    @Select("select count(id) from setmeal where category_id = #{id}")
    Integer getNumByCategory(Long id);

}
