package com.example.demo.controller;

import com.example.demo.exception.ConvertException;
import com.example.demo.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    @Autowired
    IConvertService convertService;

    @RequestMapping("/{from}/{to}")
    public Object convert(String amount, @PathVariable String from, @PathVariable String to){
        try {
            return convertService.convert(amount, from, to);
        }catch (ConvertException ce){
            return ce.getMessage();
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
