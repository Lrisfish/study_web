package com.example.demo.controller;

import com.example.demo.entity.ResultDto;
import com.example.demo.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**通过邮件模板名称查询收件人邮箱**/
    @GetMapping("/getEmailRecipientByTemplateName")
    public ResultDto<ResultDto> getEmailRecipientByTemplateName(@RequestParam(value = "templateName") String templateName) {

        ResultDto<ResultDto> result = new ResultDto<>();
        if (StringUtils.isEmpty(templateName)) {
            result.setErrors("缺少参数，请检查！");
            return result;
        }
        ResultDto config = sendEmailService.getEmailRecipientByTemplateName(templateName);
        result.setData(config);
        return result;
    }

    /**查询历史邮件**/
    @GetMapping("/queryHistoryEmail")
    public ResultDto<ResultDto> queryHistoryEmail(@RequestParam(value = "groupName") String groupName,
                                                  @RequestParam(value = "templateName") String templateName,
                                                  @RequestParam(value = "historyNumber") int historyNumber) {

        ResultDto<ResultDto> result = new ResultDto<>();
        if (StringUtils.isEmpty(groupName) || StringUtils.isEmpty(templateName) || StringUtils.isEmpty(historyNumber)) {
            result.setErrors("缺少参数，请检查！");
            return result;
        }
        ResultDto config = sendEmailService.queryHistoryEmail(groupName,templateName,historyNumber);
        result.setData(config);
        return result;
    }

    /**邮件合并**/
    @GetMapping(value = "/emailMerge")
    public ResultDto<ResultDto> emailMerge(@RequestBody List<String> groupNameList, @RequestBody List<Integer> historyNumberList){
        ResultDto<ResultDto> result = new ResultDto<>();
        if(groupNameList.size()==0){
            result.setErrors("请选择合并组及其合并内容");
            return result;
        }
        if(groupNameList.size()!=historyNumberList.size()){
            result.setErrors("请选择合并组及其合并内容");
            return result;
        }
        ResultDto config = sendEmailService.emailMerge(groupNameList,historyNumberList);
        result.setData(config);
        return result;
    }


}
