package singleton.method.pattern;

/**
 * 单例模式的线程安全问题：
 * 多个线程同时访问这个类时，就有可能会创建出多个实例；
 * 解决方法：
 * 双重锁定，以下面这个类为例，
 * 当singletonThreads为null并且有A和B两个线程同时调用getSingletonThreads()方法时，
 * 他们将都会通过第一重null == singletonThreads的判断；
 * 然后由于synchronized的作用，只会有一个线程进入创建对象（假设是A），另一个线程B在外等候，
 * 当A出来后，B才能进去，这时第二重null == singletonThreads判断出这个类已经有了一个实例，
 * 所以B线程就不会创建对象，直接出来。
 * 这种双重锁定的机制可以确保这个类在多线程的情况下只会产生一个对象。
 */
public class SingletonThreads{

    private static SingletonThreads instance = null;

    //构造器私有化，限制产生多个对象
    private SingletonThreads(){ }

    //双重锁定确保类中只会有一个实例
    public static SingletonThreads getInstance(){
        //第一重判断，先判断实例是否已存在，若不存在则加锁
        if (null == instance){
            synchronized (SingletonThreads.class){
                //第二重判断，若前面的线程已经创建了对象，则后面的线程都没法创建对象
                if (null == instance){
                    instance = new SingletonThreads();
                }
            }
        }
        return instance;
    }
}
