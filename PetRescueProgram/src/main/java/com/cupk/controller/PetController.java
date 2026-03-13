package com.cupk.controller;

import com.cupk.common.Result;
import com.cupk.mapper.PetMapper;
import com.cupk.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetMapper petMapper;

    //查询类都是Get
    //查询全部
    @GetMapping("/pets")
    Result selectALl(){
        List<Pet> petList=petMapper.selectList(null);
        for(Pet pet:petList){
            System.out.println(pet);
        }

        return Result.success(petList);
    }

    //查询部分
    @GetMapping("/pets/{id}")
    Result selectById(@RequestParam Integer id ){
        Pet pet=petMapper.selectById(id);

        if(pet!=null){
            System.out.println("数据查询成功！");
            return Result.success(pet);
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

    //添加类都是Post
    //添加
    @PostMapping("/pets")
    Result insertUser(@RequestBody Pet pet){
        int i = petMapper.insert(pet);
        if(i>0){
            System.out.println("数据添加成功！");
            return Result.success(pet);
        }else{
            System.out.println("数据添加失败！");
            return Result.error();
        }
    }

    //修改类都是Put
    //修改
    @PutMapping("/pets")
    Result updateUser(@RequestBody Pet pet){
        int i = petMapper.updateById(pet);
        if(i>0){
            System.out.println("数据修改成功！");
            return Result.success();
        }else{
            System.out.println("数据修改失败！");
            return Result.error();
        }
    }


    //删除部分
    @DeleteMapping("/pets/{id}")
    Result deleteById(@PathVariable Integer id){
        int i = petMapper.deleteById(id);
        if(i>0){
            System.out.println("数据查询成功！");
            return Result.success();
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

}
