package com.example.demo.service;

import com.example.demo.entity.Result;

public interface IConvertService {

    Result convert(String amount, String from, String to) throws Exception;
}
