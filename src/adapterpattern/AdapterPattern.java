package adapterpattern;

/**
 * 适配器模式：
 * 又叫变压器模式、包装模式；
 * 定义：将一个类的接口变成客户端所期待的另一种接口，
 * 从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
 *
 * 适配器模式的三个角色：
 * 1、Target目标角色：该角色定义把其他类转换为何种接口，也就是我们期望的接口，如例子中的IUserInfo接口；
 * 2、Adaptee源角色：如果说我要把A角色转换成目标角色，那么这个A角色就是源角色，
 * 它是已经存在的、运行良好的类或对象，经适配器包装，它会称为一个崭新的角色；
 * 3、Adapter适配器角色：适配器模式的核心角色，其他两个角色都是已经存在的角色，而适配器角色是需要新建立的，
 * 它的职责非常简单，就是把源角色转换为目标角色（用过继承或是类关联的方式转换）。
 *
 * 适配器模式的优点：
 * 1、可以让两个没有任何关系的类在一起运行；
 * 2、增加了类的透明性；
 * 3、提高了类的复用度；
 * 4、灵活性非常好。
 *
 * 适配器模式的使用场景：
 * 有动机修改一个已经投入产品中的接口时，适配器模式是最适合的模式。
 *
 * 适配器模式的注意事项：
 * 在详细设计阶段最好不要考虑适配器模式，它不是为了解决还在处于开发阶段的问题，
 * 而是解决正在服役的项目问题。
 *
 * 以下展示适配器模式的通用源码：
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 *
 */

//目标角色
interface Target{
    //目标角色有自己的方法
    public void request();
}

//目标角色的实现类
class ConcreteTarget implements Target{
    @Override
    public void request() {

        System.out.println("If you need any help , please call me !");
    }
}

//源角色
class Adaptee{
    //原有的业务逻辑
    public void doSomething(){

        System.out.println(" I am kind of busy , leave me alone , please!");
    }
}

//适配器角色
class Adapter extends Adaptee implements Target{

    @Override
    public void request() {

        super.doSomething();
    }
}
public class AdapterPattern {
    public static void main(String[] args){
        //原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();
        //增加了适配器角色之后的业务逻辑
        Target target1 = new Adapter();
        target.request();
    }
}
