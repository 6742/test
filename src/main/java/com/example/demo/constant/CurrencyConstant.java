package com.example.demo.constant;

/**
 * 货币常量
 */
public enum CurrencyConstant {
    CNY("人民币"),
    USD("美元"),
    JPY("日元"),
    EUR("欧元"),
    GBP("英镑"),
    KRW("韩元");


    private String cnName;

    CurrencyConstant(String cnName){
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }
}

