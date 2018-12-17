package strategypattern;

/**
 * 妙计三：让孙夫人断后
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {

        System.out.println("孙夫人断后，挡住追兵。");
    }
}
