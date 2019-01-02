package mementopattern;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        //声明出主角
        Boy boy = new Boy();
        //声明出备忘录的管理者
        Caretaker caretaker = new Caretaker();
        //初始化当前状态
        boy.setState("心情很棒！");
        System.out.println("=====男主现在的状态=====");
        System.out.println(boy.getState());
        //需要记录下当前状态
        caretaker.setMemento(boy.createMemento());
        //男主去搭讪女主，状态发生改变
        boy.changeState();
        System.out.println("\n=====男主追女主后的状态=====\n");
        System.out.println(boy.getState());
        //搭讪失败，恢复原状
        boy.restoreMemento(caretaker.getMemento());
        System.out.println("\n=====男主恢复后的状态=====\n");
        System.out.println(boy.getState());
    }
}
