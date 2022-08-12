package com.rwj.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rwj.reggie.pojo.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author rwj
 * @create 2022-08-08 22:44
 */
@Mapper
@Repository
public interface SetmealMapper extends BaseMapper<Setmeal> {
}
