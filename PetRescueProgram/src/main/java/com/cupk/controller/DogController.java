package com.cupk.controller;

import com.cupk.common.Result;
import com.cupk.mapper.DogMapper;
import com.cupk.pojo.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {
    @Autowired
    private DogMapper dogMapper;

    //查询类都是Get
    //查询全部
    @GetMapping("/dogs")
    Result selectALl(){
        List<Dog> dogList=dogMapper.selectList(null);
        for(Dog dog:dogList){
            System.out.println(dog);
        }

        return Result.success(dogList);
    }

    //查询部分
    @GetMapping("/dogs/{id}")
    Result selectById(@RequestParam Integer id ){
        Dog dog=dogMapper.selectById(id);

        if(dog!=null){
            System.out.println("数据查询成功！");
            return Result.success(dog);
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

    //添加类都是Post
    //添加
    @PostMapping("/dogs")
    Result insertUser(@RequestBody Dog dog){
        int i = dogMapper.insert(dog);
        if(i>0){
            System.out.println("数据添加成功！");
            return Result.success(dog);
        }else{
            System.out.println("数据添加失败！");
            return Result.error();
        }
    }

    //修改类都是Put
    //修改
    @PutMapping("/dogs")
    Result updateUser(@RequestBody Dog dog){
        int i = dogMapper.updateById(dog);
        if(i>0){
            System.out.println("数据修改成功！");
            return Result.success();
        }else{
            System.out.println("数据修改失败！");
            return Result.error();
        }
    }


    //删除部分
    @DeleteMapping("/dogs/{id}")
    Result deleteById(@PathVariable Integer id){
        int i = dogMapper.deleteById(id);
        if(i>0){
            System.out.println("数据查询成功！");
            return Result.success();
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

}
