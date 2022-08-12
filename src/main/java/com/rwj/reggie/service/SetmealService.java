package com.rwj.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rwj.reggie.dto.SetmealDto;
import com.rwj.reggie.pojo.Setmeal;

/**
 * @author rwj
 * @create 2022-08-08 22:46
 */
public interface SetmealService extends IService<Setmeal> {
    void saveWithDish(SetmealDto setmealDto);

    SetmealDto getByIdWithDish(Long id);

    void updateWithDish(SetmealDto setmealDto);
}
