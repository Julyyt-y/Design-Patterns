package strategypattern;

/**
 * 策略模式：
 * 也叫政策模式。定义：一组算法，将每个算法都封装起来，并且使它们之间可以互换。
 *
 * 策略模式的三个角色：
 * 1、Context封装角色：也叫上下文角色，起承上启下封装作用，
 * 屏蔽高层模块对策略、算法的直接访问，封装可能存在变化；
 * 2、Strategy抽象策略角色：策略、算法家族的抽象，通常为接口，
 * 定义每个策略或算法必须具有的方法和属性；
 * ConcreteStrategy具体策略角色：实现抽象策略的操作，该类含有具体的算法。
 *
 * 策略模式的优点：
 * 算法可以自由切换；避免使用多重条件判断；扩展性良好。
 *
 * 策略模式的缺点：
 * 策略类数量增多；所有的策略类都需要对外暴露。
 *
 * 策略模式的使用场景：
 * 多个类只有在算法或行为上稍有不同的场景；算法需要自由切换的场景；需要屏蔽算法规则的场景。
 *
 * 通用源码如下：
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 *
 */

//抽象的策略模式
interface Strategy{
    //策略模式的运算法则
    public void doSomething();
}

//具体策略角色
class ConcreteStrategy1 implements Strategy{
    @Override
    public void doSomething() {

        System.out.println("具体策略1的运算法则");
    }
}
class ConcreteStrategy2 implements Strategy{
    @Override
    public void doSomething() {

        System.out.println("具体策略2的运算法则");
    }
}

//封装角色，策略模式的重点
class Context1{
    //抽象策略
    private Strategy strategy = null;
    //构造函数设置具体策略
    public Context1(Strategy _strategy){

        this.strategy = _strategy;
    }
    //封装后的策略方法
    public void doAnything(){

        this.strategy.doSomething();
    }
}

//高层模块，知道要用那个策略，产生出它的对象，然后放到封装角色中
public class StrategyPattern {
    public static void main(String[] args){
        //声明一个具体的策略
        Strategy strategy = new ConcreteStrategy1();
        //声明上下文对象
        Context1 context1 = new Context1(strategy);
        //执行封装后的方法
        context1.doAnything();
    }
}
