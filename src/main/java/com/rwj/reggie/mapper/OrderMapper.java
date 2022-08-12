package com.rwj.reggie.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rwj.reggie.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Orders> {

}