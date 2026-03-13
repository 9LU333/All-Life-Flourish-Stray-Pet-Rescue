package com.cupk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cupk.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetMapper extends BaseMapper<Pet> {


}
