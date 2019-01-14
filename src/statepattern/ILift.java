package statepattern;

/**
 * 电梯接口
 */
public interface ILift {
    //电梯的4个状态
    public final static int OPENING_STATE = 1;  //敞门状态
    public final static int CLOSING_STATE = 2;  //闭门状态
    public final static int RUNNING_STATE = 3;  //运行状态
    public final static int STOPPING_STATE = 4; //停止状态

    //设置电梯的状态
    public void setState(int state);

    //电梯门开启
    public void open();
    //电梯门关闭
    public void close();
    //电梯运行
    public void run();
    //电梯暂停
    public void stop();
}
