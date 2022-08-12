package com.rwj.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rwj.reggie.pojo.Dish;
import com.rwj.reggie.dto.DishDto;

/**
 * @author rwj
 * @create 2022-08-08 22:45
 */
public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    DishDto getDishWithDishDto(Long id);

    void updateWithFlavor(DishDto dishDto);
}
