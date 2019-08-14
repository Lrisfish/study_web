package com.example.demo.controller;

import com.example.demo.Response.ResponseView;
import com.example.demo.entity.article;
import com.example.demo.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/article"})
public class ArticleController {

    @Autowired
    private articleService articleService;

    /**根据用户id查询所有文章**/
    //两种方法数据均可取到，主要是前端不会写
    @RequestMapping(value = "/showAllArticle", method = RequestMethod.POST)
    public String showAllArticle(Map<String,Object> map, HttpServletRequest request){
    //public ResponseView showAllArticle(Map<String,Object> map, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        int master_id = (int)session.getAttribute("master_id");
        System.out.println(master_id);
        ResponseView responseView = new ResponseView();
        try{
            List<article> articleList = articleService.selectAllArticle(master_id);
            responseView.setResult(articleList);
        }catch (Exception e){
            responseView.setCode(ResponseView.ERROR_CODE);
            responseView.setMessage(ResponseView.ERROR_MESSAGE);
        }
        map.put("MasterArticleList", responseView);
        return "showAllArticle";
        //return responseView;
    }

}
