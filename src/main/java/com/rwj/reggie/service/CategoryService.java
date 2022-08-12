package com.rwj.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rwj.reggie.pojo.Category;
import org.springframework.stereotype.Service;

/**
 * @author rwj
 * @create 2022-08-08 21:35
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
