package bridgepattern;

/**
 * 桥梁模式：
 * 也叫作桥接模式，是一种比较简单的设计模式；
 * 定义：将抽象和实现解耦，使两者可以独立地变化。
 *
 * 桥梁模式的4个角色：
 * 1、Abstraction抽象化角色：定义出该角色的行为，
 * 同时保存一个对实现化角色的引用，该角色一般是抽象类；
 * 2、Implementor实现化角色：接口或者抽象类，定义角色必须的行为或属性；
 * 3、RefinedAbstraction修正抽象化角色：引用实现化角色对抽象化角色进行修正；
 * 4、ConcreteImplementor具体实现化角色：实现接口或抽象类定义的方法或属性。
 *
 * 桥梁模式的优点：
 * 1、抽象和实现分离；
 * 2、优秀的扩充能力；
 * 3、实现细节对客户透明。
 *
 * 桥梁模式的使用场景：
 * 1、不希望或不适用使用继承的场景；
 * 2、接口或抽象类不稳定的场景；
 * 3、重用性要求较高的场景。
 *
 */

//实现化角色
interface Implementor{
    //基本方法
    public void doSomething();
    public void doAnything();
}

//具体实现化角色
class ConcreteImplementor1 implements Implementor{

    @Override
    public void doSomething() {

    }

    @Override
    public void doAnything() {

    }
}
class ConcreteImplementor2 implements Implementor{

    @Override
    public void doSomething() {

    }

    @Override
    public void doAnything() {

    }
}

//抽象化角色
abstract class Abstraction{
    //定义对实现化角色的引用
    private Implementor imp;
    //约束子类必须实现该构造函数
    public Abstraction(Implementor _imp){
        this.imp = _imp;
    }
    //自身的行为和属性
    public void request(){
        this.imp.doSomething();
    }
    //活动实现化角色

    public Implementor getImp() {
        return imp;
    }
}

//具体抽象化角色
class RefinedAbstraction extends Abstraction{

    //复写构造函数
    public RefinedAbstraction(Implementor _imp) {
        super(_imp);
    }
    //修正父类的行为
    @Override
    public void request(){
        super.request();
        super.getImp().doAnything();
    }
}

//场景类
public class BridgePattern {
    public static void main(String[] args){
        //定义一个实现化角色
        Implementor imp = new ConcreteImplementor1();
        //定义一个抽象化角色
        Abstraction ads = new RefinedAbstraction(imp);
        //执行行文
        ads.request();
    }
}
