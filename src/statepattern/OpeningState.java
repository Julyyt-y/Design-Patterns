package statepattern;

public class OpeningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯门打开...");
    }

    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.closingState);
        //动作委托CloseState来执行
        super.context.getLiftState().close();
    }

    @Override
    public void run() {

//        System.out.println("电梯运行...OpeningState");
    }

    @Override
    public void stop() {
//        System.out.println("电梯暂停...OpeningState");
    }
}
