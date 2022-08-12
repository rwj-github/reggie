package com.rwj.reggie.dto;

import com.rwj.reggie.pojo.Dish;
import com.rwj.reggie.pojo.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rwj
 * @create 2022-08-09 21:39
 */
@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
