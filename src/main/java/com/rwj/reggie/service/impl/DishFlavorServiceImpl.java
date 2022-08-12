package com.rwj.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rwj.reggie.mapper.DishFlavorMapper;
import com.rwj.reggie.pojo.DishFlavor;
import com.rwj.reggie.service.DishFlavorService;
import com.rwj.reggie.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @author rwj
 * @create 2022-08-09 21:23
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper,DishFlavor> implements DishFlavorService {
}
