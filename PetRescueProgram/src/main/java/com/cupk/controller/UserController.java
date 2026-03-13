package com.cupk.controller;

import com.cupk.common.Result;
import com.cupk.mapper.UserMapper;
import com.cupk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //查询类都是Get
    //查询全部
    @GetMapping("/users")
    Result selectALl(){
        List<User> userList=userMapper.selectList(null);
        for(User user:userList){
            System.out.println(user);
        }

        return Result.success(userList);
    }

    //查询部分
    @GetMapping("/users/{id}")
    Result selectById(@RequestParam Integer id ){
        User user=userMapper.selectById(id);

        if(user!=null){
            System.out.println("数据查询成功！");
            return Result.success(user);
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

    //添加类都是Post
    //添加
    @PostMapping("/users")
    Result insertUser(@RequestBody User user){
        int i = userMapper.insert(user);
        if(i>0){
            System.out.println("数据添加成功！");
            return Result.success(user);
        }else{
            System.out.println("数据添加失败！");
            return Result.error();
        }
    }

    //修改类都是Put
    //修改
    @PutMapping("/users")
    Result updateUser(@RequestBody User user){
        int i = userMapper.updateById(user);
        if(i>0){
            System.out.println("数据修改成功！");
            return Result.success();
        }else{
            System.out.println("数据修改失败！");
            return Result.error();
        }
    }


    //删除部分
    @DeleteMapping("/users/{id}")
    Result deleteById(@PathVariable Integer id){
        int i = userMapper.deleteById(id);
        if(i>0){
            System.out.println("数据查询成功！");
            return Result.success();
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

}
