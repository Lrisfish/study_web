package com.example.demo.service.impl;

import com.example.demo.entity.ResultDto;
import com.example.demo.entity.email;
import com.example.demo.entity.emailGroup;
import com.example.demo.entity.emailTemplate;
import com.example.demo.mapper.emailGroupMapper;
import com.example.demo.mapper.emailMapper;
import com.example.demo.mapper.emailTemplateMapper;
import com.example.demo.service.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SendEmailServiceImpl implements SendEmailService {

    private final emailGroupMapper emailGroupMapper;
    private final emailMapper emailMapper;
    private final emailTemplateMapper emailTemplateMapper;

    @Autowired
    public SendEmailServiceImpl(emailGroupMapper emailGroupMapper,emailMapper emailMapper,emailTemplateMapper emailTemplateMapper){
        this.emailGroupMapper=emailGroupMapper;
        this.emailMapper=emailMapper;
        this.emailTemplateMapper=emailTemplateMapper;
    }

    @Override
    public ResultDto getGroupEmailByGroupName(String groupName) {
        ResultDto resultDto = new ResultDto();
        emailGroup copyEmailRecipient = emailGroupMapper.selectByGroupName(groupName);
        resultDto.setData(copyEmailRecipient);
        return resultDto ;
    }

    @Override
    public ResultDto getEmailRecipientByTemplateName(String templateName) {
        ResultDto resultDto = new ResultDto();
        emailTemplate mainEmailRecipient = emailTemplateMapper.selectByTemplateName(templateName);
        resultDto.setData(mainEmailRecipient);
        return resultDto ;
    }


    @Override
    public ResultDto queryHistoryEmail(String groupName,String templateName,int historyNumber) {
        ResultDto resultDto = new ResultDto();
        emailGroup copyEmailRecipient = emailGroupMapper.selectByGroupName(groupName);
        emailTemplate mainEmailRecipient = emailTemplateMapper.selectByTemplateName(templateName);
        int groupId = copyEmailRecipient.getGroupId();
        int templateId = mainEmailRecipient.getEmailTemplateId();
        List<email> historyEmail = emailMapper.selectByTemplateIdAndGroupId(groupId,templateId);
        if(historyEmail.size()<historyNumber){
            resultDto.setErrors("暂无历史发送邮件！");
            return resultDto;
        }
        email emailContent = historyEmail.get(historyNumber);
        resultDto.setData(emailContent);
        return resultDto ;
    }

    @Override
    public ResultDto emailMerge(List<String> groupNameList, List<Integer> historyNumberList){
        String templateName = "PRETEST_RELEASE";
        ResultDto resultDto = new ResultDto();
        List<String> contentList = new ArrayList<>();
        for (int i=0; i<groupNameList.size();i++){

            emailGroup copyEmailRecipient = emailGroupMapper.selectByGroupName(groupNameList.get(i));
            emailTemplate mainEmailRecipient = emailTemplateMapper.selectByTemplateName(templateName);
            int groupId = copyEmailRecipient.getGroupId();
            int templateId = mainEmailRecipient.getEmailTemplateId();
            List<email> historyEmail = emailMapper.selectByTemplateIdAndGroupId(groupId,templateId);
            if(historyEmail.size()<historyNumberList.get(i)){
                resultDto.setErrors("暂无历史发送邮件！");
                return resultDto;
            }
            email emailContent = historyEmail.get(historyNumberList.get(i));
            String content = emailContent.getEmailContent();
            contentList.add(content);
        }

        //解析 合并



        return resultDto ;
    }


}
