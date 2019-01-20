package bridgepattern;

/**
 * iPod山寨公司
 */
public class iPod extends Product{

    @Override
    public void beProduct() {
        System.out.println("生产出的iPod是这样的");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的iPod卖出去了");
    }
}
