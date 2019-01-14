package statepattern;

/**
 * 电梯实现类
 */
public class Lift implements ILift{

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    //电梯门打开
    @Override
    public void open() {
        //电梯门在什么状态下才能打开
        switch (this.state){
            case OPENING_STATE:     //开门状态，什么都不做
                //doSomething
                break;
            case CLOSING_STATE:     //关门状态，可以开门
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
            case RUNNING_STATE:     //运行状态，不停开门
                //doSomething
                break;
            case STOPPING_STATE:    //停止状态，可以开门
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
        }
    }

    @Override
    public void close() {
        //电梯门在什么状态下才能关闭
        switch (this.state){
            case OPENING_STATE:     //开门状态，可以关门
                this.closeWithoutLogic();
                this.setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:     //关门状态，什么也不做
                //doSomething
                break;
            case RUNNING_STATE:     //运行状态，门是关着的，所以什么都不做
                //doSomething
                break;
            case STOPPING_STATE:    //停止状态，门本来就是关着的，也是什么都不做
                //doSomething
                break;
        }
    }

    @Override
    public void run() {
        //电梯在什么状态下才能运行
        switch (this.state){
            case OPENING_STATE:     //开门状态，什么都不做
                //doSomething
                break;
            case CLOSING_STATE:     //关门状态，可以运行
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
            case RUNNING_STATE:     //运行状态，所以什么都不做
                //doSomething
                break;
            case STOPPING_STATE:    //停止状态，可以运行
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        //电梯在什么状态下才能暂停
        switch (this.state){
            case OPENING_STATE:     //开门状态，已经停下来了，所以什么都不做
                //doSomething
                break;
            case CLOSING_STATE:     //关门状态，可以暂停
                this.stopWithoutLogic();
                this.setState(STOPPING_STATE);
                break;
            case RUNNING_STATE:     //运行状态，可以暂停
                this.stopWithoutLogic();
                this.setState(STOPPING_STATE);
                break;
            case STOPPING_STATE:    //停止状态，可以运行
                //doSomething
                break;
        }
    }

    //纯粹的电梯关门，不考虑实际的逻辑
    private void closeWithoutLogic(){
        System.out.println("电梯门关闭...");
    }

    //纯粹的电梯开门，不考虑实际的逻辑
    private void openWithoutLogic(){
        System.out.println("电梯门打开...");
    }

    //纯粹的电梯运行，不考虑实际的逻辑
    private void runWithoutLogic(){
        System.out.println("电梯运行...");
    }

    //纯粹的电梯暂停，不考虑实际的逻辑
    private void stopWithoutLogic(){
        System.out.println("电梯暂停...");
    }

}
