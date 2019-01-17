package statepattern;

/**
 * 抽象电梯状态
 */
public abstract class LiftState {
    //定义一个环境角色，也就是封装状态的变化引起的功能变化
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    //电梯门开启
    public abstract void open();
    //电梯门关闭
    public abstract void close();
    //电梯运行
    public abstract void run();
    //电梯暂停
    public abstract void stop();
}
