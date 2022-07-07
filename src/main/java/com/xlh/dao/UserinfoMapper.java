package com.xlh.dao;

import com.xlh.entity.Userinfo;

public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);
}