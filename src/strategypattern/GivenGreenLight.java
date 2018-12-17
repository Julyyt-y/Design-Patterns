package strategypattern;

/**
 * 妙计二：找吴国太哭诉，企图给自己开绿灯
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {

        System.out.println("求吴国太开绿灯，放行！");
    }
}
