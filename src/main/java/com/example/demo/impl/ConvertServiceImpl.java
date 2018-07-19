package com.example.demo.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.ErrorCode;
import com.example.demo.entity.Result;
import com.example.demo.exception.ConvertException;
import com.example.demo.service.IConvertService;
import com.example.demo.util.HttpUtil;
import org.springframework.stereotype.Component;

@Component
public class ConvertServiceImpl implements IConvertService {

    private static final String URL = "http://api.jisuapi.com/exchange/convert";
    private static final String APPKEY = "606912509964f0b0";


    @Override
    public Result convert(String amount, String ofrom, String oto) throws Exception{

        Result result = new Result();
        String url = URL + "?appkey=" + APPKEY + "&from=" + ofrom + "&to=" + oto + "&amount=" + amount;
        try {

            String resultStr = HttpUtil.sendGet(url);
            System.out.println(resultStr);
            JSONObject json = JSONObject.parseObject(resultStr);
            System.out.println(json);
            if (json.getIntValue("status") != 0) {
                System.out.println(json.getString("msg"));
                throw new ConvertException(ErrorCode.getMsg(json.getString("status")));
            } else {
                JSONObject resultarr = json.getJSONObject("result");
                String from = resultarr.getString("from");
                String to = resultarr.getString("to");
                String fromname = resultarr.getString("fromname");
                String toname = resultarr.getString("toname");
                String updatetime = resultarr.getString("updatetime");
                String rate = resultarr.getString("rate");
                String camount = resultarr.getString("camount");
                System.out.println(from + " " + to + " " + fromname + " " + toname + " " + updatetime + " " + rate + " " + camount);

                result = new Result(camount, rate, from, to);
            }
        } catch (ConvertException ce){
            throw ce;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
