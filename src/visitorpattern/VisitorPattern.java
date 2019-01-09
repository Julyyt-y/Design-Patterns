package visitorpattern;

import java.util.Random;

/**
 * 访问者模式：
 * 定义：封装一些作用于某种数据结构中各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。
 *
 * 访问者模式的5个角色：
 * 1、Visitor抽象访问者：抽象类或者接口，声明访问者可以访问哪些元素，
 * 具体到程序中就是visit方法的参数定义哪些对象是可以被访问的；
 * 2、ConcreteVisitor具体访问者：影响访问者访问到一个类后要做什么事；
 * 3、Element抽象元素：接口或者抽象类，声明接受哪一类访问者的访问，
 * 程序上是通过accept方法中的参数来定义的；
 * 4、ConcreteElement具体元素：实现accept方法，通常是visitor.visit(this)；
 * 5、ObjectStructure结构对象：元素产生者，一般容纳在多个不同类、不同接口的容器中，如List，Set，Map等，
 * 在项目中，一般很少抽象出这个角色。
 *
 * 访问者模式的优点：
 * 1、符合单一职责原则：具体元素角色（Employee抽象类）的两个子类负责数据加载，而Visitor类负责报表的展现，
 * 两个不同的职责非常明确的分离开来，各自演绎变化；
 * 2、优秀的扩展性：由于职责分开，继续增加数据的操作是非常快捷的，直接在Visitor中增加1方法即可；
 * 3、灵活性非常高。
 *
 * 访问者模式的缺点：
 * 1、具体元素对访问者公布细节：访问者要访问一个类就必然要求这个类公布一些方法和数据，也就是说访问者关注了其他类的内部细节；
 * 2、具体元素变更比较困难：具体元素的增加、删除、修改都是比较困难的；
 * 3、违背了依赖倒置转原则：访问者依赖的是具体元素，而不是抽象元素，这破坏了依赖倒置原则，
 * 特别是在面向对象编程中，抛弃了对接口的依赖，而直接依赖实现类，扩展比较困难。
 *
 * 访问者模式的使用场景：
 * 1、一个对象结构包含很多类对象，它们有不同的接口，而我们想对这些对象实施一些依赖于其具体类的操作，
 * 也就是用迭代器模式已经不能胜任的情景；
 * 2、需要对一个对象结构中的对象进行很多不同并且不相关的操作，而我们想避免这些操作“污染”这些对象的类的场景。
 *
 * 下面展示访问者模式的通用代码：
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 *
 */

//抽象元素
abstract class Element {
    //定义业务逻辑
    public abstract void doSomething();
    //允许谁来访问
    public abstract void accept(IVisitor1 visitor);
}

//具体元素
class ConcreteElement1 extends Element{
    //完善业务逻辑
    @Override
    public void doSomething() {
        System.out.println("doSomething method1 extend from Element.");
    }
    //允许哪个访问者访问
    @Override
    public void accept(IVisitor1 visitor) {
        visitor.visit(this);
    }
}

class ConcreteElement2 extends Element{
    //完善业务逻辑
    @Override
    public void doSomething() {
        System.out.println("doSomething method2 extend from Element.");
    }
    //允许哪个访问者访问
    @Override
    public void accept(IVisitor1 visitor) {
        visitor.visit(this);
    }
}

//抽象访问者
interface IVisitor1 {
    //可以访问哪些对象
    public void visit(ConcreteElement1 element1);
    public void visit(ConcreteElement2 element2);
}

//具体访问者
class Visitor1 implements IVisitor1 {
    //访问element1元素
    @Override
    public void visit(ConcreteElement1 element1) {
        element1.doSomething();
    }
    //访问element2元素
    @Override
    public void visit(ConcreteElement2 element2) {
        element2.doSomething();
    }
}

//结构对象
class ObjectStructure {
    public static Element createElement (){
        Random rand = new Random();
        if (rand.nextInt(100) > 50){
            return new ConcreteElement1();
        }else {
            return new ConcreteElement2();
        }
    }
}

//场景类
public class VisitorPattern {
    public static void main(String[] args){
        for (int i = 0;i < 10;i++){
            //获得元素对象
            Element el = ObjectStructure.createElement();
            //接受访问者访问
            el.accept(new Visitor1());
        }
    }
}
