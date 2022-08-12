package com.rwj.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rwj.reggie.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author rwj
 * @create 2022-08-11 14:28
 */
@Mapper
@Repository
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
