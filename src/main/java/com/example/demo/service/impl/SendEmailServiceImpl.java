package com.example.demo.service.impl;

import com.example.demo.entity.ResultDto;
import com.example.demo.entity.emailTemplate;
import com.example.demo.mapper.emailGroupMapper;
import com.example.demo.mapper.emailMapper;
import com.example.demo.service.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendEmailServiceImpl implements SendEmailService {

    private final emailGroupMapper emailGroupMapper;
    private final emailMapper emailMapper;
    private final emailTemplate emailTemplate;

    @Autowired
    public SendEmailServiceImpl(emailGroupMapper emailGroupMapper,emailMapper emailMapper,emailTemplate emailTemplate){
        this.emailGroupMapper=emailGroupMapper;
        this.emailMapper=emailMapper;
        this.emailTemplate=emailTemplate;
    }

    @Override
    public ResultDto getGroupEmailByGroupName(String groupName) {
        ResultDto resultDto = new ResultDto();
        String copyEmailRecipient = emailGroupMapper.selectByGroupName(groupName);
        resultDto.setData(copyEmailRecipient);
        return resultDto ;
    }
}
