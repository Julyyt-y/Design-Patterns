package proxypattern;

/**
 * 代理模式的扩展（3）——虚拟代理
 * 在需要的时候才初始化主题对象，
 * 可以避免被代理对象较多而引起的初始化非常缓慢的问题；
 * 缺点是需要在每个方法中判断主题对象是否被创建。
 *
 * 只对代理类进行修改即可。
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 *
 */

//抽象主题类
interface Subject1{
    //定义一个方法
    public void request();
}

//真实主题类
class RealSubject1 implements Subject1{

    @Override
    public void request() {

        //业务逻辑处理
    }
}

/**
 * 修改后的代理类
 */
//代理类
class Proxy1 implements Subject1{

    //要代理哪个实现类
    private Subject1 subject ;


    //实现接口中定义的方法
    @Override
    public void request() {
        if (null == subject){
            subject = new RealSubject1();
        }
        subject.request();
    }

    //预处理
    private void before(){

        //do something
    }

    //善后处理
    private void after(){

        //do something
    }
}

public class ProxPatternExtension3 {
    public static void main(String[] args){

    }
}
