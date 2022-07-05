package com.xlh.service;

import com.xlh.entity.Userinfo;

import java.util.ArrayList;

/**
 * @author Xlh
 * @create 2022-07-05 21:32
 */
public interface UserinfoService {
    int insert(Userinfo record);

    ArrayList<Userinfo> selectSelective(Userinfo record);
}
