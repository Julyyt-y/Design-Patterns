package mementopattern;

import java.util.HashMap;

/**
 * 备忘录模式的扩展（3）——多备份的备忘录
 */

//备忘录管理员
class Caretaker3 {
    //备忘录对象
    private IMemento memento;

    public IMemento getMemento() {
        return memento;
    }

    public void setMemento(IMemento memento) {
        this.memento = memento;
    }

//    private HashMap<String,Memento> memMap = new HashMap<>();
//    public Memento getMemento(String idx){
//        return memMap.get(idx);
//    }
//    public void setMemento(String idx,Memento memento){
//        this.memMap.put(idx,memento);
//    }
}

//发起人角色
class Originator3{
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public Memento createMemento() {
        return new Memento(this.state);
    }
    //恢复一个备忘录
    public void restoreMemento (IMemento _memento) {
        this.setState(((Memento)_memento).getState());
    }
    //内部类
    private class Memento implements IMemento{
        //发起人的内部状态
        private String state = "";
        //构造函数传递参数
        private Memento(String _state){
            this.state = _state;
        }
        private String getState(){
            return state;
        }
        private void setState(String state){
            this.state = state;
        }
    }
}

//备忘录的空接口
interface IMemento{

}
public class MementoPatternExtension3 {
    public static void main(String[] args){
        //定义发起人
        Originator3 originator = new Originator3();
        //定义出备忘录管理员
        Caretaker3 caretaker = new Caretaker3();
        //创建两个备忘录
        caretaker.setMemento(originator.createMemento());
        //恢复一个指定标记的备忘录
        originator.restoreMemento(caretaker.getMemento());
    }
}
