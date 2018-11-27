package singleton.method.pattern;

/**
 * 单例设计模式：
 * 1、类中只能有一个实例，通过new关键字来实例化；
 * 2、将构造函数私有化（禁止外部创建对象）；
 * 3、提供一个访问该实例的方法（get）；
 * 让类自身负责保存它的唯一实例。这个类可以保证没有其他实例可以被创建（通过截取创建新对象的请求）。
 *
 * 单例设计模式的两种实现方式：懒汉式和饿汉式。
 *
 * 单例设计模式的优点：
 * 由于单例模式在内存中只有一个实例，减少了内存开支，减少了性能的开销。
 * 单例设计模式的缺点：
 * 单例模式一般没有接口，扩展很困难，只能修改代码；
 * 对测试不利，在并行开发环境中，如果单例模式没有完成，是不能进行测试的；
 * 单例模式与单一职责原则有冲突：一个类应该只实现一个逻辑，而不关心它是否是单例的，
 * 是不是要单例取决于环境，单例模式吧“要单例”的业务和逻辑融合在一个类中。
 *
 * 单例设计模式的应用场景：
 * 要求生成唯一序列号的环境；
 * 在整个项目中需要一个共享访问点或共享数据；
 * 创建一个对象需要消耗的资源过多（如要访问IO和数据库的资源）；
 * 需要定义大量的静态常量和静态方法的环境（当然也可直接声明为static的方式）。
 *
 */

/**
 * 懒汉式
 * 在创建对象时就将其实例化
 */
public class Singleton {

    //一个全局变量使得一个对象可以被访问（但不能防止实例化多个对象）
    private static final Singleton instance = new Singleton();

    //将构造器私有化，禁止外部创建对象
    private Singleton(){ }

    //提供一个访问该实例的方法（get方法）
    public static Singleton getInstance(){
        return instance;
    }
}

/**
 * 饿汉式
 * get方法中判断出对象还没有被实例化后再将其实例化
 * （此处注释掉的原因是个人不想看见有报红）
 */
//public class Singleton1{
//
//    private static Singleton1 instance;
//
//    private Singleton1() { }
//
//    public static Singleton1 getInstance(){
//        if (null == instance){
//            instance = new Singleton1();
//        }
//        return instance;
//    }
//}