package com.cupk.controller;

import com.cupk.common.Result;
import com.cupk.mapper.CatMapper;
import com.cupk.pojo.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatMapper catMapper;

    //查询类都是Get
    //查询全部
    @GetMapping("/cats")
    Result selectALl(){
        List<Cat> catList= catMapper.selectList(null);
        for(Cat cat:catList){
            System.out.println(cat);
        }

        return Result.success(catList);
    }

    //查询部分
    @GetMapping("/cats/{id}")
    Result selectById(@RequestParam Integer id ){
        Cat cat= catMapper.selectById(id);

        if(cat!=null){
            System.out.println("数据查询成功！");
            return Result.success(cat);
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

    //添加类都是Post
    //添加
    @PostMapping("/cats")
    Result insertUser(@RequestBody Cat cat){
        int i = catMapper.insert(cat);
        if(i>0){
            System.out.println("数据添加成功！");
            return Result.success(cat);
        }else{
            System.out.println("数据添加失败！");
            return Result.error();
        }
    }

    //修改类都是Put
    //修改
    @PutMapping("/cats")
    Result updateUser(@RequestBody Cat cat){
        int i = catMapper.updateById(cat);
        if(i>0){
            System.out.println("数据修改成功！");
            return Result.success();
        }else{
            System.out.println("数据修改失败！");
            return Result.error();
        }
    }


    //删除部分
    @DeleteMapping("/cats/{id}")
    Result deleteById(@PathVariable Integer id){
        int i = catMapper.deleteById(id);
        if(i>0){
            System.out.println("数据查询成功！");
            return Result.success();
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

}
