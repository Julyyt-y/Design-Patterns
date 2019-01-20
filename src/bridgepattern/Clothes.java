package bridgepattern;

/**
 * 衣服
 */
public class Clothes extends Product{
    //盖房子
    @Override
    public void beProduct() {
        System.out.println("生产出的衣服");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的衣服卖出去了");
    }
}
