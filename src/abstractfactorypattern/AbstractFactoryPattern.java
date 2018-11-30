package abstractfactorypattern;

/**
 * 抽象工厂模式：
 * 定义：为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类。
 * 抽象工厂模式是工厂方法模式的升级版，
 * 在有多个业务品种、业务分类时、通过抽象工厂米模式产生需要的对象是一种非常好的解决方式。
 *
 * 抽象工厂模式的优点：
 * 封装性很好。每个产品的实现类不是高层模块需要关心的，高层模块只需要关心接口和抽象；对象如何创建出来由工厂负责；
 * 产品族内的约束为非公开状态。生产过程对调用工厂类的高层模块来说的透明的，它不需要知道这个约束。
 *
 * 抽象工厂模式的缺点：
 * 最大的缺点就是产品族（不是产品等级）扩展非常困难。以下面代码为例，如果要增加一个产品C。也就是产品家族由两个增加到三个，
 * 那么抽象类AbstractCreator要增加一个createProductC()方法，然后两个实现类都要改，这严重违反了开闭原则。
 *
 * 抽象工厂模式的使用场景：
 * 抽象工厂模式的使用场景定义非常简单：
 * 一个对象族（或一组没有任何关系的对象）都有相同的约束，则可以使用抽象工厂模式。
 *
 * 抽象工厂模式的注意事项：
 * 抽象工厂模式的产品族扩展非常困难，但是其产品等级扩展非常容易，
 * 要扩展产品等级，只要增加一个工厂类复写新增产品增加出来的产品生产任务即可。
 * 也就是说横向扩展困难，纵向扩展容易。
 *
 * 抽象工厂模式的通用代码如下：
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类（和一个接口）都不是public方法，
 *         但具体使用时下面各个类（和一个接口）应分别写成.java文件，并且都是public的。
 */

//抽象产品类
abstract class AbstractProductA{
    //每个产品共有的方法
    public void shareMethod(){ }
    //每个产品相同方法、不同实现
    public abstract void doSomething();
}
abstract class AbstractProductB{

    public void shareMethod(){ }

    public abstract void doSomething();
}

//产品A1的实现类
class ProductA1 extends AbstractProductA{

    @Override
    public void doSomething() {
        System.out.println("产品A1的实现方法");
    }
}

//产品A2的实现类
class ProductA2 extends AbstractProductA{

    @Override
    public void doSomething() {
        System.out.println("产品A2的实现方法");
    }
}

//产品B1的实现类
class ProductB1 extends AbstractProductB{

    @Override
    public void doSomething() {
        System.out.println("产品B1的实现方法");
    }
}

class ProductB2 extends AbstractProductB{

    @Override
    public void doSomething() {
        System.out.println("产品B2的实现方法");
    }
}

//抽象工厂类。职责是定义每个工厂要实现的功能，
//在同用代码中，抽象工厂类定义了两个产品族的产品创建
abstract class AbstractCreator{
    //创建A产品家族
    public abstract AbstractProductA createProductA();
    //创建B产品家族
    public abstract AbstractProductB createProductB();
}

//产品等级为1（A1和B1）的实现类（因为有共性）
class Creator1 extends AbstractCreator {

    //只生产产品等级为1的A产品
    @Override
    public AbstractProductA createProductA(){
        return new ProductA1();
    }
    //只生产产品等级为1的B产品
    @Override
    public AbstractProductB createProductB(){
        return new ProductB1();
    }
}

//产品等级为2（A2和B2）生物实现类
class Creator2 extends AbstractCreator{

    //只生产产品等级为2的A产品
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    //只生产产品等级为2的B产品
    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

//场景类
public class AbstractFactoryPattern {
    public static void main(String[] args){

        //定义出两个工厂
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();
        //产生A1对象
        AbstractProductA a1 = creator1.createProductA();
        //产生A2对象
        AbstractProductA a2 = creator2.createProductA();
        //产生B1对象
        AbstractProductB b1 = creator1.createProductB();
        //产生B2对象
        AbstractProductB b2 = creator2.createProductB();
    }
}