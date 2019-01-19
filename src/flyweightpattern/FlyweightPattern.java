package flyweightpattern;

import java.util.HashMap;

/**
 * 享元模式：
 * 池技术的重要实现方式；
 * 定义：使用共享对象可有效地支持大量的细粒度的对象。
 * 要求细粒度对象，那么不可避免的使得对象数量多且性质相近，
 * 那么就将这些对象的信息分为两个部分：内部状态和外部状态。
 * 内部状态：对象可共享出来的信息，存储在享元对象内部并且不会随环境改变而改变，
 * 如例子中的id、postAddress等，它们可以作为一个对象的动态附加信息，
 * 不必直接储存在具体的某个对象中，属于可以共享的成分；
 * 外部状态：对象得以依赖的一个标记，是随环境的改变而改变的、不可以共享的状态，
 * 如我们例子中的考试科目+考试地点复合字符串，它是一批对象的统一标识，是唯一的一个索引值。
 *
 * 享元模式的4个角色：
 * 1、Flyweight抽象享元角色：简单地说就是一个产品的抽象类，
 * 同时定义出对象的外部状态和内部状态的接口或实现；
 * 2、ConcreteFlyweight具体享元角色：具体的一个产品类，实现抽象角色定义的业务，
 * 该角色中需要注意的是内部状态处理应该与环境无关，不应该出现一个操作改变了内部状态，
 * 同时修改了外部状态，这是绝对不允许的；
 * 3、unsharedConcreteFlyweight不可共享的享元角色：
 * 不存在外部状态或者安全要求（如线程安全）不能够共享技术的对象，该对象一般不会出现在享元工厂中；
 * 4、FlyweightFactory享元工厂：职责非常简单，就是构造一个池容器，同时提供从池中获得对象的方法。
 *
 * 享元模式的优点和缺点：
 * 享元模式是一个非常简单的模式，它可以大大减少应用程序创建的对象，降低程序内存的占用，
 * 增强程序的性能，但它同时也提高了系统复杂性，需要分离出外部状态和内部状态，
 * 而且外部状态具有固化特性，不应该随内部状态的改变而改变，否则会导致程序的逻辑混乱。
 *
 * 享元模式的使用场景：
 * 1、系统中存在大量的相似对象；
 * 2、细粒度的对象都具备较接近的外部状态，而且内部状态与环境无关，也就是说对象没有特定身份；
 * 3、需要缓冲池的场景。
 */

//抽象享元角色
abstract class Flyweight{
    //内部状态
    private String intrinsic;
    //外部状态
    protected final String extrinsic;
    public Flyweight(String _extrinsic){
        this.extrinsic = _extrinsic;
    }
    //定义业务操作
    public abstract void operate();
    //内部状态的getter/setter

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}

//具体享元角色
class ConcreteFlyweight1 extends Flyweight{

    //接收外部状态
    public ConcreteFlyweight1(String _extrinsic) {
        super(_extrinsic);
    }

    //根据外部状态进行逻辑处理
    @Override
    public void operate() {
        //业务逻辑
    }
}
class ConcreteFlyweight2 extends Flyweight{

    //接收外部状态
    public ConcreteFlyweight2(String _extrinsic) {
        super(_extrinsic);
    }

    //根据外部状态进行逻辑处理
    @Override
    public void operate() {
        //业务逻辑
    }
}

//享元工厂
class FlyweightFactory{
    //定义一个容器池
    private static HashMap<String,Flyweight> pool = new HashMap<>();
    //享元工厂
    public static Flyweight getFlyweight(String extrinsic){
        //需要返回的对象
        Flyweight flyweight = null;
        //在池中没有该对象
        if (pool.containsKey(extrinsic)){
            flyweight = pool.get(extrinsic);
        }else {
            //根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight1(extrinsic);
            //放入到池中
            pool.put(extrinsic,flyweight);
        }
        return flyweight;
    }
}

//场景类
public class FlyweightPattern {
    public static void main(String[] args){

    }
}
