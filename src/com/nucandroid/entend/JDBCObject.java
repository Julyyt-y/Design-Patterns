package com.nucandroid.entend;

import okhttp3.Response;
import week01.extendandinterface.JDBCHelper;

public class JDBCObject {
    public void sava(JDBCDao.SavaListener listener){
        //假设网络通信在子线程运行
        Response response = JDBCHelper.getInstance().save(this);
        //201创建资源成功
        if (null != response && response.code() == 201){
            try{
                String json = response.body().string();
            }
            catch (Exception e){
                e.printStackTrace();
                listener.onFail();
            }
        }
        else {
            listener.onFail();
        }
    }
}
