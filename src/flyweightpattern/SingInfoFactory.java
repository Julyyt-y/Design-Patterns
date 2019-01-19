package flyweightpattern;

import java.util.HashMap;

/**
 * 带对象池的工厂类
 */
public class SingInfoFactory {
    //容器池
    private static HashMap<String,SingInfo> pool = new HashMap<>();

    //报名信息的对象工厂
//    @Deprecated
//    public static SingInfo(){
//        return new SingInfo();
//    }

    //从池中获得对象
    public static SingInfo getSingInfo(String key){
        //设置返回对象
        SingInfo result = null;
        //池中没有该对象，则建立该对象，并放入池中
        if (!pool.containsKey(key)){
            System.out.println(key + "建立对象，并放入池中");
            result = new SingInfo4Pool(key);
            pool.put(key,result);
        }else {
            result = pool.get(key);
            System.out.println(key + "直接从池中获得");
        }
        return result;
    }
}
