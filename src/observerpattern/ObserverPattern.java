package observerpattern;

import java.util.Vector;

/**
 * 观察者模式（发布订阅模式）
 * 定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，
 * 则所有依赖于它的对象都会得到通知被自动更新。
 *
 * 观察者模式的四个角色：
 * 1、Subject被观察者：定义被观察者必须实现的职责，它必须能够动态的增加、取消观察者，
 * 一般是抽象类或者实现类，仅仅完成作为被观察者必须实现的职责：管理观察者并通知观察者；
 * 2、Observer观察者：观察者接收到消息后，即进行update（更新方法）操作，对接收到的信息进行处理；
 * 3、ConcreteSubject具体的被观察者：定义被观察者自己的业务逻辑，同时定义对哪些事件进行通知；
 * 4、ConcreteObserver具体的观察者：每个观察者在接收到消息后的处理反应是不同的，
 * 各个观察者都有自己的处理逻辑。
 *
 * 观察者模式的优点：
 * 观察者和被观察者之间是抽象耦合：增加观察者和增加被观察者都是非常容易扩展的；
 * 建立一套触发机制。
 *
 * 观察者模式的缺点：
 * 观察者模式需要考虑开发效率和运行效率问题，一个观察者，多个被观察者，开发和调试就会比较复杂，
 * 而且Java中消息的通知默认是顺序执行的，一个观察者卡壳，会影响整体的执行效率，
 * 在这种情况下，一般采取异步的方式。
 *
 * 观察者模式的使用场景：
 * 1、关联行为场景（注意关联行为是可拆分的）；
 * 2、事件多级触发场景；
 * 3、跨系统的消息交换场景，如消息队列的处理机制。
 *
 * 以下展示观察者模式的通用源码。
 */

//被观察者
abstract class Subject{
    //定义一个观察者数组
    private Vector<Observer0> obsVector = new Vector<>();
    //增加一个观察者
    public void addObserver(Observer0 o){
        this.obsVector.add(o);
    }
    //删除一个观察者
    public void delObserver(Observer0 o){
        this.obsVector.remove(o);
    }
    //通知所有观察者
    public void notifyObservers(){
        for (Observer0 o:this.obsVector) {
            o.update();
        }
    }
}

//具体被观察者
class ConcreteSubject extends Subject {
    //具体的业务
    public void doSomething(){
        System.out.println("doSomething");
        super.notifyObservers();
    }
}

//观察者
interface Observer0{
    //更新方法
    public void update();
}

//具体观察者
class ConcreteObserver implements Observer0 {

    //实现更新方法
    @Override
    public void update() {
        System.out.println("收到！");
    }
}

//场景类
public class ObserverPattern {
    public static void main(String[] args){
        //创建一个被观察者
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer0 obs = new ConcreteObserver();
        //观察者观察被观察者
        subject.addObserver(obs);
        //观察者开始活动
        subject.doSomething();
    }
}
