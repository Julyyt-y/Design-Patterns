package factorymethodpattern;

//货物A
public class GoodsA implements Goods{

    @Override
    public void getColor() {
        System.out.println("货物A的颜色是红色");
    }

    @Override
    public void weight() {
        System.out.println("货物A的重量是2kg");
    }
}
