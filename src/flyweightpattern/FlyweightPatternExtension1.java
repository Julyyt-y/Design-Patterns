package flyweightpattern;

import java.util.HashMap;

/**
 * 享元模式的扩展：
 * 此处只是展示了会出现线程安全问题。
 */

//报考信息工厂
class SingInfoFactory1{
    //池容器
    private static HashMap<String,SingInfo> pool = new HashMap<>();
    //从池中获得对象
    public static SingInfo getSingInfo(String key){
        //设置返回对象
        SingInfo result = null;
        //池中没有该对象，则建立该对象，并放入池中
        if (!pool.containsKey(key)){
            System.out.println(key + "建立对象，并放入池中");
            result = new SingInfo();
            pool.put(key,result);
        }else {
            result = pool.get(key);
            System.out.println(key + "直接从池中获得");
        }
        return result;
    }
}

//多线程场景
class MultiThread extends Thread{
    private SingInfo singInfo;
    public MultiThread(SingInfo _singInfo){
        this.singInfo = _singInfo;
    }
    public void run(){
        if (!singInfo.getId().equals(singInfo.getLocation())){
            System.out.println("编号" + singInfo.getId());
            System.out.println("考试地址" + singInfo.getLocation());
            System.out.println("线程不安全了");
        }
    }
}

//场景类
public class FlyweightPatternExtension1 {
    public static void main(String[] args){
        //在对象池中初始化4个对象
        SingInfoFactory1.getSingInfo("科目1");
        SingInfoFactory1.getSingInfo("科目2");
        SingInfoFactory1.getSingInfo("科目3");
        SingInfoFactory1.getSingInfo("科目4");
        //取得对象
        SingInfo singInfo = SingInfoFactory1.getSingInfo("科目2");
        while (true){
            singInfo.setId("张三");
            singInfo.setLocation("张三的地址");
            (new MultiThread(singInfo)).start();
            singInfo.setId("李四");
            singInfo.setLocation("李四的地址");
            (new MultiThread(singInfo)).start();
        }
    }
}
