package proxypattern;

/**
 * 代理模式（也叫委托模式）：
 * 一种使用率非常高的模式，定义：为其他对象提供一种代理以控制对这个对象的访问。
 *
 * 代理模式的三个角色：
 * 1、Subject抽象主题角色：抽象主题类也可以是接口，是一个最普通的业务类型定义，无特殊要求；
 * 2、RealSubject具体主题角色：也叫代理角色，是业务逻辑的具体执行者；
 * 3、Prox代理主题角色：也叫作委托类、代理类，它负责对真是角色的应用，
 * 把所有抽象主题类定义的方法限制委托给真实主题角色实现，并在真实主题角色处理完毕前后做预处理和善后处理工作。
 *
 * 代理类具体实现哪个真实主题角色是由场景类决定的，最简单的情况是一个主题类和一个代理类；
 * 通常情况下，一个借口只需要一个代理类，具体代理哪个实现类由高层模块来决定，
 * 也就是代理类的构造函数中传递被代理者，例如可以在Proxy代理类中增加一个构造函数，
 * 要代理谁就产生谁的实例，然后把被代理者传递进去。
 *
 * 代理模式的优点：
 * 1、职责清晰：真实的角色就是实现实际的业务逻辑，不用关心其他非本职责的事物，
 * 通过后期的代理完成一件事物，附带结果就是编程清晰；
 * 2、高扩展性：具体主题角色是随时都会发生变化的，只要它实现了接口，不管它如何变化，都会被接口限制，
 * 所以代理类完全可以在不做任何修改的情况下使用；
 * 3、智能化。
 *
 * 下面演示代理模式的通用源码。
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 *
 */

//抽象主题类
interface Subject{
    //定义一个方法
    public void request();
}

//真实主题类
class RealSubject implements Subject{

    @Override
    public void request() {

        //业务逻辑处理
    }
}

//代理类
class Proxy implements Subject{

    //要代理哪个实现类
    private Subject subject = null;

    //默认被代理者
    public Proxy(){
        this.subject = new Proxy();
    }

    //通过构造函数传递代理者
    public Proxy(Object objects){

        //业务处理逻辑
    }

    //增加的构造函数
    //要代理谁就产生谁的实例，然后把被代理者传递进来
    public Proxy(Subject _subject){

        this.subject = _subject;
    }

    //实现接口中定义的方法
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
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
public class ProxyPattern {

}
