package com.rwj.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rwj.reggie.common.R;
import com.rwj.reggie.dto.SetmealDto;
import com.rwj.reggie.pojo.Category;
import com.rwj.reggie.pojo.Setmeal;
import com.rwj.reggie.pojo.SetmealDish;
import com.rwj.reggie.service.CategoryService;
import com.rwj.reggie.service.SetmealDishService;
import com.rwj.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author rwj
 * @create 2022-08-10 8:39
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SetmealDishService setmealDishService;

    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){
        setmealService.saveWithDish(setmealDto);
        return R.success("添加成功");
    }
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        Page<Setmeal> pageInfo = new Page<>(page, pageSize);
        Page<SetmealDto> setmealDtoPage = new Page<>();
        LambdaQueryWrapper<Setmeal> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(name),Setmeal::getName,name)
                .orderByDesc(Setmeal::getUpdateTime);
        setmealService.page(pageInfo,lqw);
        BeanUtils.copyProperties(pageInfo,setmealDtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();
        List<SetmealDto> list = new ArrayList<>();
        for (Setmeal record : records) {
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(record,setmealDto);
            Long categoryId = record.getCategoryId();
            Category category = categoryService.getById(categoryId);
            String categoryName = category.getName();
            setmealDto.setCategoryName(categoryName);
            list.add(setmealDto);
        }
        setmealDtoPage.setRecords(list);
        return R.success(setmealDtoPage);
    }
    @GetMapping("/{id}")
    public R<SetmealDto> getById(@PathVariable Long id){
        SetmealDto setmealDto = setmealService.getByIdWithDish(id);
        return R.success(setmealDto);
    }
    @PutMapping
    public R<String> updateWithDish(@RequestBody SetmealDto setmealDto){
        setmealService.updateWithDish(setmealDto);
        return R.success("修改成功");
    }
    @DeleteMapping
    public R<String> delete(String[] ids){
        LambdaQueryWrapper<SetmealDish> lqw = new LambdaQueryWrapper<>();
        for (String id : ids) {
            setmealService.removeById(id);
            lqw.eq(SetmealDish::getSetmealId,id);
            setmealDishService.remove(lqw);
        }
        return R.success("删除成功");
    }
    @PostMapping("/status/{status}")
    public R<String> update(@PathVariable Integer status,String[] ids){
        LambdaQueryWrapper<Setmeal> lqw = new LambdaQueryWrapper<>();
        for (String id : ids) {
            Setmeal setmeal = setmealService.getById(id);
            setmeal.setStatus(status);
            setmealService.updateById(setmeal);
        }
        return R.success("修改成功");
    }
    @GetMapping("/list")
    public R<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Setmeal::getCategoryId,setmeal.getCategoryId());
        lqw.eq(Setmeal::getStatus,setmeal.getStatus());
        List<Setmeal> list = setmealService.list(lqw);
        return R.success(list);
    }
}
