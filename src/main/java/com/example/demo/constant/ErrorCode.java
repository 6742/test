package com.example.demo.constant;

import java.util.HashMap;

/**
 * 错误码
 */
public class ErrorCode {
    private static final HashMap<String, String> API_ERR = new HashMap<String, String>() {
        {
            put("201", "要兑换的货币为空");
            put("202", "兑换后的货币为空");
            put("203", "兑换数量为空");
            put("204", "要兑换的货币有误");
            put("205", "兑换后的货币有误");
            put("206", "货币为空");
            put("207", "货币有误");
            put("208", "没有信息");
        }
    };

    private static final HashMap<String, String> SYS_ERR = new HashMap<String, String>() {
        {
            put("101", "APPKEY为空或不存在");
            put("102", "APPKEY已过期");
            put("103", "APPKEY无请求此数据权限");
            put("104", "请求超过次数限制");
            put("105", "IP被禁止");
            put("106", "IP请求超过限制");
            put("107", "接口维护中");
            put("108", "接口已停用");
        }
    };

    public static String getMsg(String errCode) {
        if (API_ERR.get(errCode) != null) {
            return API_ERR.get(errCode);
        } else if (SYS_ERR.get(errCode) != null) {
            System.out.println(SYS_ERR.get(errCode));
            return String.format("系统错误，请联系管理员。{}",errCode);
        }
        return String.format("未知错误。{}",errCode);
    }
}
