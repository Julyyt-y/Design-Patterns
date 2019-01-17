package statepattern;

public class StoppingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(Context.openingState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
//        System.out.println("电梯门关闭...RunningState");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯暂停...OpeningState");
    }
}
