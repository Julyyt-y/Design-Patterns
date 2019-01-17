package statepattern;

public class RunningState extends LiftState {
    @Override
    public void open() {
//        System.out.println("电梯门打开...RunningState");
    }

    @Override
    public void close() {
//        System.out.println("电梯门关闭...RunningState");
    }

    @Override
    public void run() {
        System.out.println("电梯上下运行...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
