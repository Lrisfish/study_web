package com.example.demo.controller;

import com.example.demo.entity.ResultDto;
import com.example.demo.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/sendEmail"})
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;

    /**邮件发送页面**/
    @RequestMapping(value = {"/emailIndex"})
    public String emailIndex(){
        return "emailIndex";
    }


    /**通过发件组名称查询发件组的邮箱**/
    @GetMapping("/getGroupEmailByGroupName")
    public ResultDto<ResultDto> getGroupEmailByGroupName(@RequestParam(value = "groupName") String groupName) {

        ResultDto<ResultDto> result = new ResultDto<>();
        if (StringUtils.isEmpty(groupName)) {
            result.setErrors("缺少参数，请检查！");
            return result;
        }
        ResultDto config = sendEmailService.getGroupEmailByGroupName(groupName);
        result.setData(config);
        return result;
    }





}
