package factorymethodpattern;

//制造货物的工厂
public class GoodsFactory extends Factory {

    @Override
    public <T extends Goods> T createGoods(Class<T> c) {
        //定义一个产生的货物
        Goods goods = null;
        try{
            //产生一种货物
            goods = (Goods)Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            System.out.println("制造货物出错！");
        }
        return (T)goods;
    }
}
