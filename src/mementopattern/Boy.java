package mementopattern;

/**
 * 例子是模拟电影《预见未来》中男主认识女主的过程。
 * 男主状态类
 */
public class Boy {
    //男主的状态
    private String state = "";
    //认识女主后状态发生变化
    public void changeState(){
        this.state = "心情可能不好";
    }
    public String getState() {
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    //保留一个备份
    public Memento createMemento(){
        return new Memento(this.state);
    }
    //恢复一个备份
    public void restoreMemento(Memento _memento){
        this.setState(_memento.getState());
    }
}
