package com.rwj.reggie.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rwj.reggie.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}