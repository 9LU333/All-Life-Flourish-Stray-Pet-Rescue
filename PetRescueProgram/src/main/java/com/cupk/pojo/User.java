package com.cupk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("users")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date time;
    Integer age;
    String password;
}

