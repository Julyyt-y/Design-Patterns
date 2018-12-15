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
 */
public class DecoratorPattern {
}
