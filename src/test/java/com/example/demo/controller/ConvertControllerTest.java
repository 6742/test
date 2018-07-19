package com.example.demo.controller;

import com.example.demo.constant.CurrencyConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConvertControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void convert() {
        String cny = CurrencyConstant.CNY.name();
        String usd = CurrencyConstant.USD.name();
        String eur = CurrencyConstant.EUR.name();

        StringBuffer buffer = new StringBuffer("/convert");
        buffer.append("/").append(cny);// from
        buffer.append("/").append(eur);// to

        buffer.append("?amount=").append(100);
        try {
            mvc.perform(MockMvcRequestBuilders.get(buffer.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}