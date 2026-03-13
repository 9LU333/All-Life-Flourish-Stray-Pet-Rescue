package com.cupk.controller;

import com.cupk.common.Result;
import com.cupk.mapper.ActivityMapper;
import com.cupk.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityMapper activityMapper;

    //查询类都是Get
    //查询全部
    @GetMapping("/activities")
    Result selectALl(){
        List<Activity> activityList= activityMapper.selectList(null);
        for(Activity activity:activityList){
            System.out.println(activity);
        }

        return Result.success(activityList);
    }

    //查询部分
    @GetMapping("/activities/{id}")
    Result selectById(@RequestParam Integer id ){
        Activity activity= activityMapper.selectById(id);

        if(activity!=null){
            System.out.println("数据查询成功！");
            return Result.success(activity);
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

    //添加类都是Post
    //添加
    @PostMapping("/activities")
    Result insertUser(@RequestBody Activity activity){
        int i = activityMapper.insert(activity);
        if(i>0){
            System.out.println("数据添加成功！");
            return Result.success(activity);
        }else{
            System.out.println("数据添加失败！");
            return Result.error();
        }
    }

    //修改类都是Put
    //修改
    @PutMapping("/activities")
    Result updateUser(@RequestBody Activity activity){
        int i = activityMapper.updateById(activity);
        if(i>0){
            System.out.println("数据修改成功！");
            return Result.success();
        }else{
            System.out.println("数据修改失败！");
            return Result.error();
        }
    }


    //删除部分
    @DeleteMapping("/activities/{id}")
    Result deleteById(@PathVariable Integer id){
        int i = activityMapper.deleteById(id);
        if(i>0){
            System.out.println("数据查询成功！");
            return Result.success();
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

}
