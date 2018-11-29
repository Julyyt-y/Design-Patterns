package factorymethodpattern;

import java.lang.reflect.Constructor;

/**
 * 工厂方法模式的扩展（3）——代替单例模式
 * 单例模式的核心是要求内存中只有一个对象，通过工厂方法模式也可以只在内存中产生一个对象。
 *
 * 具体实现：
 * 获得类构造器，设置访问权限（私有），生成一个对象，然后提供方外部访问，保证内存中对象唯一；
 *
 */

class Singleton{
    //构造器私有化，不允许通过new产生一个对象
    private Singleton(){ }

    //其他方法
    public void doSomething(){ }
}

//负责生成单例的工厂类
//通过反射创建
class SingletonFactory{
    private static Singleton singleton;
    static {
        try{
            Class cl = Class.forName(Singleton.class.getName());
            //获得无参构造
            Constructor constructor = cl.getDeclaredConstructor();
            //设置无参构造是可访问的
            constructor .setAccessible(true);
            //产生一个实例对象
            singleton = (Singleton)constructor.newInstance();
        }catch (Exception e){
            //异常处理
        }
    }

    public static Singleton getSingleton(){
        return singleton;
    }
}
public class FactoryMethodExtension3 {
}
