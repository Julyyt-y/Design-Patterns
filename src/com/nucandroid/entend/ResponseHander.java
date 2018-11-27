package com.nucandroid.entend;

public class ResponseHander implements JDBCDao.SavaListener {
    @Override
    public void onSucceed(String jsonResponse) {

        System.out.println("在这里处理服务器响应" + jsonResponse);
    }

    @Override
    public void onFail() {

        System.out.println("请求失败哦");
    }
}
