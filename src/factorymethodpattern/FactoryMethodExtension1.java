package factorymethodpattern;

/**
 * 工厂方法模式的扩展（1）——缩小为简单工厂模式
 * （在此包中那个制造货物的工厂方法模式的基础上扩展）
 * 去掉Factory抽象类，同时把createGoods方法设置为静态类型，简化了类的创建过程，
 * GoodsFactory和Client这两个类中的代码有所变更。
 * （此处用FactoryMethodExtension1代替Client，只是名字有所变化）
 *
 * 运行结果没有变化，只是类变简单了，调用者也较为简单，该模式数工厂方法模式的弱化；
 * 该方法即为“简单工厂模式”，也叫作静态工厂模式；
 * 缺点：扩展比较困难，不符合开闭原则，但仍不失为一个非常实用的设计模式。
 *
 *【注】：为了演示方便（还有就是不报红）下面各个类（和一个接口）都不是public方法，
 *         但具体使用时下面各个类（和一个接口）应分别写成.java文件，并且都是public的。
 */

//货物总称，每种货物的特性
interface Goods1 {

    //货物的颜色
    public void getColor();

    //货物的重量
    public void weight();
}

//货物A
class GoodsA1 implements Goods1{

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
class GoodsB1 implements Goods1 {

    @Override
    public void getColor() {
        System.out.println("货物B的颜色是黑色");
    }

    @Override
    public void weight() {
        System.out.println("货物B的重量是5kg");
    }
}

//制造货物的工厂
/** 两处变化：去掉继承类，createGoods方法变成静态的 */
class GoodsFactory1 {

    public static <T extends Goods1> T createGoods(Class<T> c) {
        //定义一个产生的货物
        Goods1 goods = null;
        try{
            //产生一种货物
            goods = (Goods1)Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            System.out.println("制造货物出错！");
        }
        return (T)goods;
    }
}

public class FactoryMethodExtension1 {
    public static void main(String[] args){

        System.out.println("——————制造货物A——————");
        Goods1 goods1 = GoodsFactory1.createGoods(GoodsA1.class);
        goods1.getColor();
        goods1.weight();
        //制造第二种货物
        System.out.println("——————制造货物B——————");
        Goods1 goods2 = GoodsFactory1.createGoods(GoodsB1.class);
        goods2.getColor();
        goods2.weight();
    }
}