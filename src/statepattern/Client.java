package statepattern;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
