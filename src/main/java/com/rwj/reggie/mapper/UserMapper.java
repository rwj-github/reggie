package com.rwj.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rwj.reggie.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author rwj
 * @create 2022-08-11 11:09
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
