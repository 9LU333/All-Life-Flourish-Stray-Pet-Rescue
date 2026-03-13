package com.cupk.controller;

import com.cupk.common.Result;
import com.cupk.mapper.VolunteerMapper;
import com.cupk.pojo.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerMapper volunteerMapper;

    //查询类都是Get
    //查询全部
    @GetMapping("/volunteers")
    Result selectALl(){
        List<Volunteer> volunteerList=volunteerMapper.selectList(null);
        for(Volunteer volunteer:volunteerList){
            System.out.println(volunteer);
        }

        return Result.success(volunteerList);
    }

    //查询部分
    @GetMapping("/volunteers/{id}")
    Result selectById(@RequestParam Integer id ){
        Volunteer volunteer=volunteerMapper.selectById(id);

        if(volunteer!=null){
            System.out.println("数据查询成功！");
            return Result.success(volunteer);
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

    //添加类都是Post
    //添加
    @PostMapping("/volunteers")
    Result insertUser(@RequestBody Volunteer volunteer){
        int i = volunteerMapper.insert(volunteer);
        if(i>0){
            System.out.println("数据添加成功！");
            return Result.success(volunteer);
        }else{
            System.out.println("数据添加失败！");
            return Result.error();
        }
    }

    //修改类都是Put
    //修改
    @PutMapping("/volunteers")
    Result updateUser(@RequestBody Volunteer volunteer){
        int i = volunteerMapper.updateById(volunteer);
        if(i>0){
            System.out.println("数据修改成功！");
            return Result.success();
        }else{
            System.out.println("数据修改失败！");
            return Result.error();
        }
    }


    //删除部分
    @DeleteMapping("/volunteers/{id}")
    Result deleteById(@PathVariable Integer id){
        int i = volunteerMapper.deleteById(id);
        if(i>0){
            System.out.println("数据查询成功！");
            return Result.success();
        }else{
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }

}
