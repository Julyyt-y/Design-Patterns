package decoratorpattern;

/**
 * 装饰模式：
 * 动态地给一个对象添加一些额外的职责。
 * 就增加功能来说，装饰模式相比生成子类更为灵活。
 *
 * 装饰模式有四个角色：
 * 1、Component抽象构件：Component是一个接口或者抽象类，就是定义核心的对象，
 * 也就是最原始的对象，如上面的成绩单；
 * 2、ConcreteComponent具体构件：最原始、最核心、最基本的接口或抽象类的实现，
 * 要装饰的就是这个构件；
 * 3、Decorator装饰角色：一般是个抽象类，用于实现接口剖或抽象方法，
 * 此抽象类里不一定有抽象方法，在它的属性里必有一个private变量指向Component抽象构件；
 * 4、具体装饰角色：把最核心、最原始、最基本的东西装饰成其他东西。
 *
 * 装饰模式的优点：
 * 1、装饰类和被装饰类可以独立发展，而不会相互耦合。换句话说，Component无须知道Decorator1类，
 * Decorator1类是用来从外部来扩展Component类的功能，而Decorator1也不用知道具体的构件；
 * 2、装饰模式是继承关系的一个替代方案；
 * 3、装饰模式可以动态的扩展䘝实现类的功能（装饰模式的定义）。
 *
 * 装饰模式的缺点：
 * 多层装饰非常复杂。
 *
 * 装饰模式的使用场景：
 * 1、需要扩展一个类的功能，或者给一个类增加附加功能；
 * 2、需要动态的给对象增加功能，这些功能可以再动态地撤销；
 * 3、需要为一批兄弟类进行改装或加装功能。
 */

//抽象构件
abstract class Component{
    //抽象的方法
    public abstract void operate();
}

//具体构件
class ConcreteComponent extends Component{
    //具体实现
    @Override
    public void operate() {

        System.out.println("do Something.");
    }
}

//抽象装饰者
abstract class Decorator1 extends Component{
    private Component component = null;
    //通过构造函数传递被修饰者
    public Decorator1(Component _component){

        this.component = _component;
    }
    //委托给被修饰者执行
    @Override
    public void operate(){

        this.component.operate();
    }
}

//具体的装饰类
class ConcreteDecorator1 extends Decorator1{
    //定义被修饰者
    public ConcreteDecorator1(Component _component) {

        super(_component);
    }
    //定义自己的修饰方法
    private void method1(){

        System.out.println("method1修饰。");
    }
    //重写父类的operation方法
    public void operate(){
        this.method1();
        super.operate();
    }
}
class ConcreteDecorator2 extends Decorator1{
    //定义被修饰者
    public ConcreteDecorator2(Component _component) {

        super(_component);
    }
    //定义自己的修饰方法
    private void method2(){

        System.out.println("method2修饰。");
    }
    //重写父类的operation方法
    public void operate(){
        this.method2();
        super.operate();
    }
}

//场景类
public class DecoratorPattern {
    public static void main(String[] args){
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
        //修饰后运行
        component.operate();
    }
}
