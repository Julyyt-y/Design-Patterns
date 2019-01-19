package flyweightpattern;

import java.util.HashMap;

/**
 * 享元模式的扩展：性能平衡
 */

//外部状态类
class ExtrinsicState{
    //考试科目
    private String subject;
    //考试地点
    private String location;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof ExtrinsicState){
            ExtrinsicState state = (ExtrinsicState)obj;
            return state.getLocation().equals(location) && state.getSubject().equals(subject);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return subject.hashCode() + location.hashCode();
    }
}

//享元工厂
class SingInfoFactory2{
    //池容器
    private static HashMap<ExtrinsicState,SingInfo> pool = new HashMap<>();
    //从池中获得对象
    public static SingInfo getSingInfo(ExtrinsicState key){
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

//场景类
public class FlyweightPatternExtension2 {
    public static void main(String[] args){
//        method1();
//
//        method2();
    }

    public static void method1(){
        //初始化对象
        ExtrinsicState state1 = new ExtrinsicState();
        state1.setSubject("科目1");
        state1.setSubject("科目1的地点");
        SingInfoFactory2.getSingInfo(state1);
        ExtrinsicState state2 = new ExtrinsicState();
        state2.setSubject("科目2");
        state2.setLocation("科目2");
        //计算执行100万次需要的时间
        long currentTime = System.currentTimeMillis();
        for (int i=0;i<1000000;i++){
            SingInfoFactory2.getSingInfo(state2);
        }
        long tailTime = System.currentTimeMillis();
        System.out.println("执行时间" + (tailTime - currentTime) + "ms");
    }

    public static void method2(){
        String key1 = "科目1地点";
        String key2 = "科目2地点";
        //初始化对象池
        SingInfoFactory1.getSingInfo(key1);
        //计算执行100万次需要的时间
        long currentTime = System.currentTimeMillis();
        for (int i=0;i<1000000;i++){
            SingInfoFactory1.getSingInfo(key2);
        }
        long tailTime = System.currentTimeMillis();
        System.out.println("执行时间" + (tailTime - currentTime) + "ms");
    }
}
