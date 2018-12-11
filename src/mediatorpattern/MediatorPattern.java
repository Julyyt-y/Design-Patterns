package mediatorpattern;

/**
 * 中介者模式：
 * 用一个中介对象封装一系列的对象交互，中介者使各对象不需要显式地相互作用，
 * 从而使其耦合松散，而且可以独立的改变他们之间的交互。
 *
 * 中介者模式由以下几部分组成：
 * 1、Mediator抽象中介者类：抽象中介者角色统一的接口，用于个同事角色之间的通信；
 * 2、ConcreteMediator具体中介者角色：通过协调各同事角色实现协作行为，因此它必须依赖于各个同事角色；
 * 3、Colleague同事角色：每个同事角色都知道中介者角色，而且与其他的同事角色通信时，
 * 一定要通过中介者角色协作；每个同事类的行为分为两种：
 * 一种是同事本身行为，比如改变一个对象本身状态，处理自己的行为等，这种方法叫做自发行为，
 * 与其他同事之间没有任何依赖；；另一种是必须依赖中介者才能完成的行为，叫做依赖方法。
 *
 * 同事类用构造函数注入中介者，而中介者使用getter/setter注入同事类的原因：
 * 同事类必须有中介者，而中介者却可以只有部分同事类。
 *
 * 中介者模式的优点：
 * 减少类间的依赖，把原有的一对多的依赖变成一对一的依赖，
 * 同事类只依赖中介者，减少了依赖，当然也降低了类间耦合。
 *
 * 中介者模式的人缺点：
 * 缺点会死中介者会膨胀的很大，而且逻辑复杂，
 * 原本N个对象的直接的相互依赖关系转换为中介者和同事类的依赖关系，
 * 同事类越多，中介者的逻辑就约复杂。
 *
 * 中介者模式的使用场景：
 * 中介者模式适用于多个对象之间紧密耦合的情况，紧密耦合的标准是：
 * 在类图中出现了蜘蛛网状结构（此时使用中介者模式有利于把混乱复杂的关系变得清晰简单）。
 */

//通用抽象中介者
abstract class Mediator1{
    //定义同事类
    protected ConcreteColleague1 c1;
    protected ConcreteColleague2 c2;
    //通过getter/setter方法把同事类注入进来
    public ConcreteColleague1 getC1() {
        return c1;
    }
    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }
    public ConcreteColleague2 getC2() {
        return c2;
    }
    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }
    //中介者模式的业务逻辑
    public abstract void doSomething1();
    public abstract void doSomething2();
}

//通用中介者
class ConcreteMediator1 extends Mediator1{

    @Override
    public void doSomething1() {
        //调用同事类的方法，只要是public方法都可以调用
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }
}

//抽象同事类
abstract class Colleague1{
    protected Mediator1 mediator1;
    public Colleague1(Mediator1 _mediator1){
        this.mediator1 = _mediator1;
    }
}

//具体同事类
class ConcreteColleague1 extends Colleague1{
    //通过构造函数传递中介者
    public ConcreteColleague1(Mediator1 _mediator1){
        super(_mediator1);
    }
    //自有方法
    public void selfMethod1(){
        //处理自己的业务逻辑
    }
    //依赖方法
    public void depMethod1(){
        //处理自己的业务逻辑
        //自己不能处理的业务逻辑委托给中介者处理
        super.mediator1.doSomething1();
    }
}
class ConcreteColleague2 extends Colleague1{
    //通过构造函数传递中介者
    public ConcreteColleague2(Mediator1 _mediator1){
        super(_mediator1);
    }
    //自有方法
    public void selfMethod2(){
        //处理自己的业务逻辑
    }
    //依赖方法
    public void depMethod2(){
        //处理自己的业务逻辑
        //自己不能处理的业务逻辑委托给中介者处理
        super.mediator1.doSomething2();
    }
}

public class MediatorPattern {
    public static void main(String[] args){
        
    }
}
