package statepattern;

/**
 * 上下文类
 */
public class Context {
    //定义出所有的电梯状态
    public final static OpeningState openingState = new OpeningState();
    public final static RunningState runningState = new RunningState();
    public final static ClosingState closingState = new ClosingState();
    public final static StoppingState stoppingState = new StoppingState();

    private LiftState liftState ;
    public LiftState getLiftState(){
        return liftState;
    }
    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }
    public void open(){
        this.liftState.open();
    }
    public void close(){
        this.liftState.close();
    }
    public void run(){
        this.liftState.run();
    }
    public void stop(){
        this.liftState.stop();
    }
}
