package com.rwj.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rwj.reggie.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author rwj
 * @create 2022-08-08 22:43
 */
@Mapper
@Repository
public interface DishMapper extends BaseMapper<Dish> {
}
