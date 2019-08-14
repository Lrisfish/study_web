package com.example.demo.controller;

import com.example.demo.entity.master;
import com.example.demo.service.masterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping(value = {"/user"})
public class MasterController {

        @Autowired
        private masterService masterService;

        /**登陆页面**/
        @RequestMapping(value = {"/userLogin"})
        public String userLogin(){
            return "userLogin";
        }

        /**注册页面**/
        @RequestMapping(value = {"/userRegister"})
        public String userRegister(){
            return "userRegister";
        }


        /**登陆结果-跳转-首页**/
        @RequestMapping(value = {"/welcome"}, method = RequestMethod.POST)
        public String welcome(@RequestParam("username") String master_name,
                              @RequestParam("password") String password,
                              HttpServletRequest request, RedirectAttributes attributes){
            if(StringUtils.isEmpty(master_name)){
                attributes.addFlashAttribute("message","用户名不能为空");
            }
            if(StringUtils.isEmpty(password)){
                attributes.addFlashAttribute("message","密码不能为空");
            }
            master master = masterService.masterLogin(master_name,password);
            if(master != null){
                int master_id = master.getId();
                HttpSession session = request.getSession(true);
                session.setAttribute("master_id", master_id);
                session.setAttribute("master_name",master_name);
                return "welcome";
            }
            return "userLogin";
        }


        /***退出登陆*/
        @RequestMapping(value = {"/exit"})
        @ResponseBody
        public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            HttpSession session = request.getSession(false);
            int master_id = (int)session.getAttribute("master_id");
            String master_name = (String)session.getAttribute("master_name");
            String html = "<html><body>welcome!<br>master_id:"+master_id+"<br>master_name:"+master_name+"</a><body><html>";
            PrintWriter writer = response.getWriter();
            writer.write(html);
            session.removeAttribute("master_id");
            session.removeAttribute("master_name");
        }


        //验证session 以及 后端通过map向前端传递数据
    @RequestMapping(value = {"/showMasterMessage"})
    public String showMasterMessage(Map<String,Object> map,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        int master_id = (int)session.getAttribute("master_id");
        String master_name = (String)session.getAttribute("master_name");
        System.out.println(master_id);
        System.out.println(master_name);
        map.put("master_id",master_id);
        map.put("master_name", master_name);
        return "showMasterMessage";
    }



        /**注册结果显示**/
        @ResponseBody
        @RequestMapping(value = {"/registerRes"})
        public String addUser(@RequestParam("username") String username,
                              @RequestParam("password1") String password1,
                              @RequestParam("password2") String password2){

            if(StringUtils.isEmpty(username)){
                return "用户名不能为空";
            }
            if(StringUtils.isEmpty(password1)){
                return "密码不能为空";
            }
            if(StringUtils.isEmpty(password2)){
                return "密码确认不能为空";
            }
            if(!password1.equals(password2)){
                return "两次密码不相同，注册失败！！";
            }else {
                int res = masterService.masterRegister(username,password1);
                if(res == 0){
                    return "注册失败！";
                }else {
                    return "注册成功！";
                }
            }

        }

    }

