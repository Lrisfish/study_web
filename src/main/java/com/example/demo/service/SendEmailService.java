package com.example.demo.service;

import com.example.demo.entity.ResultDto;


public interface SendEmailService {
    ResultDto getGroupEmailByGroupName( String groupName);
}