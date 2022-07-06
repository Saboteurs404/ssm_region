package com.xlh.service.impl;

import com.xlh.dao.UserinfoMapper;
import com.xlh.entity.Userinfo;
import com.xlh.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Xlh
 * @create 2022-07-06 21:48
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoMapper mapper;
    public int insert(Userinfo record){
        return mapper.insert(record);
    }

    public ArrayList<Userinfo> selectSelective(Userinfo record){
        return mapper.selectSelective(record);
    }


























}
