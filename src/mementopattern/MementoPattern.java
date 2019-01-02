package mementopattern;

/**
 * 备忘录模式：
 * 例子是模拟电影《预见未来》中男主认识女主的过程。
 *
 * 定义：在不破坏封装性的前提下，捕获一个对象的内部状态，
 * 并在该对象之外保存这个状态，这样以后就可以将该对象恢复到原先保存的状态。
 * 通俗的说，备忘录模式就是一个对象的备份模式，提供了一种程序数据的备份方法。
 *
 * 备忘录模式的三个角色：
 * 1、Originator发起人角色：记录当前时刻的内部状态，负责定义哪些属于备份范围的状态，负责创建和恢复备忘录数据；
 * 2、Memento备忘录角色：负责存储Originator发起人对象的内部状态，在需要的时候提供给发起人需要的内部状态；
 * 3、Caretaker备忘录管理员角色：对备忘录进行管理、保存和提供备忘录。
 *
 * 备忘录模式的使用场景：
 * 1、需要保存和恢复数据的相关状态场景；
 * 2、提供一个可回滚（rollback）的操作，比如Word中的Control+Z组合键；
 * 3、需要监控的副本场景；
 * 4、数据库的事务管理。
 *
 * 备忘录模式的注意事项：
 * 1、备忘录的生命期：备忘录创建出来就要在“最近”的代码中使用，要主动管理它的生命周期，建立就要使用，
 * 不使用就要删除其引用，等待垃圾回收器对它的回收处理；
 * 2、备忘录的性能：不要在频繁建立备份的场景中使用备忘录模式（比如一个for循环中），原因有两个：
 * 一是控制不了备忘录建立的对象数量，二是大量对象的建立是要消耗资源的，系统的性能需要考虑。
 *
 * 以下展示中介者模式的通用源码。
 *
 */

//发起人角色
class Originator{
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public Memento0 createMemento0(){
        return new Memento0(this.state);
    }

    //恢复一个备忘录
    public void restoreMemento0(Memento0 _memento0){
        this.setState(_memento0.getState());
    }

}

//备忘录角色
class Memento0{
    //发起人的内部状态
    private String state = "";
    //构造函数传递参数
    public Memento0(String _state){
        this.state = _state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//备忘录管理员角色
class Caretaker0{
    //备忘录对象
    private Memento0 memento0;

    public Memento0 getMemento0() {
        return memento0;
    }

    public void setMemento0(Memento0 memento0) {
        this.memento0 = memento0;
    }
}

//场景类
public class MementoPattern {
    public static void main(String[] args){
        //定义出发起人
        Originator originator = new Originator();
        //定义出备忘录管理员
        Caretaker0 caretaker = new Caretaker0();
        //创建一个备忘录
        caretaker.setMemento0(originator.createMemento0());
        //恢复一个备忘录
        originator.restoreMemento0(caretaker.getMemento0());
    }
}
