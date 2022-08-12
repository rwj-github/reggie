package com.rwj.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rwj.reggie.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author rwj
 * @create 2022-08-08 21:34
 */
@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
}
