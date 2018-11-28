package factorymethodpattern;

//制造货物
public class Client {

    public static void main(String[] args){
        //声明工厂
        Factory factory = new GoodsFactory();
        //制造第一种货物
        System.out.println("——————制造货物A——————");
        GoodsA goodsA = factory.createGoods(GoodsA.class);
        goodsA.getColor();
        goodsA.weignt();
        //制造第二种货物
        System.out.println("——————制造货物B——————");
        GoodsB goodsB = factory.createGoods(GoodsB.class);
        goodsB.getColor();
        goodsB.weignt();

    }
}
