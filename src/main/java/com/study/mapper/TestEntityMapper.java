package com.study.mapper;


import com.study.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestEntityMapper {
    //@Select("select * from Test where id = #{id}")
    public TestEntity getById(Integer id);

}