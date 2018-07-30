package com.zhou.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper {
    //插入一条file记录
    int insertFile(@Param("originalFilename")String filename,@Param("realPath")String url);
}
