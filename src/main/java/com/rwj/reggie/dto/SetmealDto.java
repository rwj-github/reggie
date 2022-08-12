package com.rwj.reggie.dto;

import com.rwj.reggie.pojo.Setmeal;
import com.rwj.reggie.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
