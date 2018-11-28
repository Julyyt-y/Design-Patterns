package singletonmethodparttern;

/**
 * 单例设计模式的静态初始化：
 * 这种方法不需要显式地编写线程安全代码即可解决多线程环境下的不安全问题
 * 同时也能保证只有一个实例
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){ }

    //私有静态内部类
    private static class Holder{

        //由这个私有静态内部类创建实例
        private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {

        //返回私有静态内部类创建的实例
        return Holder.instance;
    }
}
