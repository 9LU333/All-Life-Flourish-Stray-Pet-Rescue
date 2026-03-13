package com.cupk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("activities")
public class Activity {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date time;
    String description;
    String type;

}