package com.example.demo.service;

import com.example.demo.entity.ResultDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface SendEmailService {
    ResultDto getGroupEmailByGroupName( String groupName);
    ResultDto getEmailRecipientByTemplateName( String templateName);
    ResultDto queryHistoryEmail( String groupName,String templateName,int historyNumber);
    ResultDto emailMerge(List<String> groupNameList, List<Integer> historyNumberList);


}