package com.nucandroid.entend;

//自定义接口
public class JDBCDao {
    public interface SavaListener{
        void onSucceed(String jsonResponse);
        void onFail();
    }
}
