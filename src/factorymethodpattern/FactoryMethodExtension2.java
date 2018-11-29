package factorymethodpattern;

/**
 * 工厂方法模式的扩展（2）——升级成为多个工厂类
 * 所有产品类都放在一个工厂方法中会使代码结构不清晰；
 * 所以为每个产品定义一个创造者（类），然后由调用者自己去选择与哪个工厂方法关联。
 * 但是这种方法给可扩展性和可维护性带来了一定影响，
 * 如果要扩展一个产品类，就要建立一个相应的工厂类，这样就增加了扩展的难度；
 * 在复杂的应用中，一般采用多工厂的方法，然后再增加一个协调类，避免调用者与各个子工厂交流；
 * 协调类的作用是封装子工厂类，对高层模块提供统一的访问接口。
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类（和一个接口）都不是public方法，
 *         但具体使用时下面各个类（和一个接口）应分别写成.java文件，并且都是public的。
 */

//货物总称，每种货物的特性
interface Goods2 {

    //货物的颜色
    public void getColor();

    //货物的重量
    public void weight();
}

//货物A
class GoodsA2 implements Goods2{

    @Override
    public void getColor() {
        System.out.println("货物A的颜色是红色");
    }

    @Override
    public void weight() {
        System.out.println("货物A的重量是2kg");
    }
}

//货物B
class GoodsB2 implements Goods2 {

    @Override
    public void getColor() {
        System.out.println("货物B的颜色是黑色");
    }

    @Override
    public void weight() {
        System.out.println("货物B的重量是5kg");
    }
}

//多工厂模式的抽象类制造货物的工厂，这个工厂是生产的管理者；
abstract class Factory2 {
    public abstract Goods2 createGoods2();
}

class GoodsA2Factory extends Factory2{
    public Goods2 createGoods2(){
        return new GoodsA2();
    }
}
class GoodsB2Factory extends Factory2{

    @Override
    public Goods2 createGoods2() {
        return new GoodsB2();
    }
}
//场景类
public class FactoryMethodExtension2 {
    public static void main(String[] args){
        //制造第一种货物
        System.out.println("——————制造货物A——————");
        GoodsA2 goodsA2 = (GoodsA2) (new GoodsA2Factory()).createGoods2();
        goodsA2.getColor();
        goodsA2.weight();
        //制造第二种货物
        System.out.println("——————制造货物B——————");
        GoodsB2 goodsB2 = (GoodsB2) (new GoodsB2Factory()).createGoods2();
        goodsB2.getColor();
        goodsB2.weight();
    }
}
