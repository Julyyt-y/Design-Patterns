package bridgepattern;

/**
 * 房子
 */
public class House extends Product{
    //盖房子
    @Override
    public void beProduct() {
        System.out.println("盖出的房子");
    }

    @Override
    public void beSelled() {
        System.out.println("盖的房子卖出去了");
    }
}
