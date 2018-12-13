package commandpattern;

/**
 * 命令模式：
 * 将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，
 * 对请求排队或者记录请求日记，可以提供命令的撤销和恢复功能。
 *
 * 命令模式中有三个角色：
 * 1、Receiver接收者角色：命令传递到这里要被执行，如例子中的Group类；
 * 2、Command命令角色：需要执行的所有命令都在这里声明；
 * 3、Invoker调用者角色：接收到命令，并执行命令，例子中的负责人类就是这个角色。
 *
 * 命令模式的优点：
 * 1、封装性非常好，把请求方和执行方分开了；
 * 2、扩展性有很好的保障；
 * 3、类间解耦：调用者与接收者之间没有任何依赖关系，
 * 调用者实现功能时只需调用Command1抽象类的execute方法就可以，不需要知道到底是哪个接收者执行；
 * 4、命令模式结合其他模式会更加优秀。
 *
 * 命令模式的缺点：
 * 以Command的子类为例，Command的子类有N个，如果有N个命令，这个类会膨胀的非常大。
 *
 * 通用代码如下：
 *
 */

//通用Receiver类
abstract class Receiver1{
    //抽象接收者，定义每个接收者都必须完成的业务
    public abstract void doSomething();
}

//具体的Receiver类(可以有N多个)
class ConcreteReciver1 extends  Receiver1{
    //每个接收者都必须处理一定的业务逻辑
    @Override
    public void doSomething() {

    }
}
class ConcreteReciver2 extends Receiver1{
    @Override
    public void doSomething() {

    }
}

//抽象Command类
abstract class Command1{
    //每个命令类都必须有一个执行的方法
    public abstract void execute();
}

//具体的Command类
class ConcreteCommand1 extends Command1{
    //对哪个Receiver类进行命令处理
    private Receiver1 receiver1;
    //构造函数传递接收者
    public ConcreteCommand1(Receiver1 _receiver1){
        this.receiver1 = _receiver1;
    }
    //必须实现一个命令
    @Override
    public void execute() {
        //业务处理
        this.receiver1.doSomething();
    }
}
class ConcreteCommand2 extends Command1{
    //对哪个Receiver类进行命令处理
    private Receiver1 receiver1;
    //构造函数传递接收者
    public ConcreteCommand2(Receiver1 _receiver1){
        this.receiver1 = _receiver1;
    }
    //必须实现一个命令
    @Override
    public void execute() {
        //业务处理
        this.receiver1.doSomething();
    }
}

//调用者Invoker类
class Invoker1{
    private Command1 command1;
    //接收命令
    public void setCommand1(Command1 _command1){
        this.command1 = _command1;
    }
    //执行命令
    public void action(){
        this.command1.execute();
    }
}

//场景类
public class CommandPattern {
    public static void main(String[] args){
        //首先声明调用者Invoker
        Invoker1 invoker1 = new Invoker1();
        //定义接收者
        Receiver1 receiver1 = new ConcreteReciver1();
        //定义一个发送给接收者的命令
        Command1 command1 = new ConcreteCommand1(receiver1);
        //把命令交给调用者去执行
        invoker1.setCommand1(command1);
        invoker1.action();
    }
}
