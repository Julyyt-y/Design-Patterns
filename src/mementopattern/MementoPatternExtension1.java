package mementopattern;

/**
 * 备忘录模式的扩展（1）——clone方式的备忘录
 *
 */

//融合备忘录的发起人角色
class Originator1 implements Cloneable{
    private Originator1 backup;
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public void createMemento(){
        this.backup = this.clone();
    }
    //恢复一个备忘录
    public void restoreMemento(){
        //在恢复之前应该断言，防止空指针
        this.setState(this.backup.getState());
    }
    //克隆当前对象
    @Override
    protected Originator1 clone(){
        try {
            return (Originator1)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
}

//备忘录管理员角色
class Caretaker1{
    //发起人对象
    private Originator1 originator1;

    public Originator1 getOriginator1() {
        return originator1;
    }

    public void setOriginator1(Originator1 originator1) {
        this.originator1 = originator1;
    }
}

//场景类
public class MementoPatternExtension1 {
    public static void main(String[] args){
        //定义发起人
        Originator1 originator1 = new Originator1();
        //建立初始状态
        originator1.setState("初始状态。");
        System.out.println("初始状态是：" + originator1.getState());
        //建立备份
        originator1.createMemento();
        //修改状态
        originator1.setState("修改后的状态。");
        System.out.println("修改后的状态是：" + originator1.getState());
        //恢复原来的状态
        originator1.restoreMemento();
        System.out.println("回复后的状态是：" + originator1.getState());
    }
}
