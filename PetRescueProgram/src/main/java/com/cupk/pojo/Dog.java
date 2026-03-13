package com.cupk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("dogs")
public class Dog {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    String name;
    String weight;
    Integer age;
    String type;
    String category;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date time;
    String owner;
    String description;
    String state;
}
