package statepattern;

/**
 * 状态模式
 * 定义：当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。
 *
 * 状态模式中的3个角色：
 * 1、State抽象状态角色：接口或者抽象类，负责对象状态定义，并且封装环境角色以实现状态切换；
 * 2、ConcreteState具体状态角色：每一格具体状态必须完成两个职责：本状态的行为管理以及趋向状态处理，
 * 即就是本状态必须要做的事，以及本状态如何过渡到其他状态；
 * 3、Context环境角色：定义客户端需要的接口，并且负责具体状态的切换。
 *
 * 状态模式的优点：
 * 1、结构清晰；
 * 2、遵循设计原则；
 * 3、封装性非常好。
 *
 * 状态模式的缺点：
 * 只有一个缺点：子类会太多，也就是类膨胀。
 *
 * 状态模式的使用场景：
 * 1、行为虽状态改变而改变的场景；
 * 2、条件、分支语句的替代者。
 */

//抽象环境角色
abstract class State {
    //定义一个环境角色，提供子类访问
    protected Context0 context;
    //设置环境角色
    public void setContext(Context0 context){
        this.context = context;
    }

    //行为1
    public abstract void handle1();
    //行为2
    public abstract void handle2();
}

//环境角色
class ConcreteState1 extends State{
    @Override
    public void handle1() {
        //本状态下必须处理的逻辑
    }

    @Override
    public void handle2() {
        //设置当前状态为state2
        super.context.setCurrentState(Context0.STATE2);
        super.context.handle2();
    }
}
class ConcreteState2 extends State{
    @Override
    public void handle1() {
        //设置当前状态为state1
        super.context.setCurrentState(Context0.STATE1);
        super.context.handle1();
    }

    @Override
    public void handle2() {
        //本状态下必须处理的逻辑
    }
}

//具体环境角色
class Context0{
    //定义状态
    public final static State STATE1 = new ConcreteState1();
    public final static State STATE2 = new ConcreteState2();
    //当前状态
    private State CurrentState;
    //获得当前状态
    public State getCurrentState() {
        return CurrentState;
    }
    //设置当前状态

    public void setCurrentState(State currentState) {
        this.CurrentState = currentState;
        //切换状态
        this.CurrentState.setContext(this);
    }
    //行为委托
    public void handle1(){
        this.CurrentState.handle1();
    }
    public void handle2(){
        this.CurrentState.handle2();
    }
}

public class StatePattern {
    public static void main(String[] args){
        //定义环境角色
        Context0 context0 = new Context0();
        //初始化状态
        context0.setCurrentState(new ConcreteState1());
        //行为执行
        context0.handle1();
        context0.handle2();
    }
}
