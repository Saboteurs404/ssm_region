package com.xlh.dao;

import com.xlh.entity.Userinfo;

import java.util.ArrayList;

public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    ArrayList<Userinfo> selectSelective(Userinfo record);
}