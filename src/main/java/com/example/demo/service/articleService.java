package com.example.demo.service;

import com.example.demo.entity.article;
import com.example.demo.mapper.articleMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class articleService {

    @Autowired
    articleMapper articleMapper;
    /**查询用户所有文章**/
    public List<article> selectAllArticle(Integer master_id){
        return articleMapper.selectAllArticle(master_id);
    }

}
