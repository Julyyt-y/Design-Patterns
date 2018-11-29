package factorymethodpattern;

//货物B
public class GoodsB implements Goods {

    @Override
    public void getColor() {
        System.out.println("货物B的颜色是黑色");
    }

    @Override
    public void weight() {
        System.out.println("货物B的重量是5kg");
    }
}
