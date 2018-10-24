package com.cn.session_7.application_1_X_10;

public class WheatMill extends Mill{

    @Override
    Wheat process(){
        return new Wheat();
    }
}
