package builderpattern;

/**
 * 建造者模式（也叫生成器模式）：
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 *
 * 在建造者模式中，有如下4个角色：
 * 1、Product产品类：通常是实现模板方法，也就是有模板方法和基本方法，
 * 例子中的BenzMode和BMWMode就属于产品类；
 * 2、Builder抽象建造者：规范产品的组建，一般是由子类实现，
 * 例子中的CarBuilder就属于抽象建造者；
 * 3、ConcreteBuilder具体建造者：实现抽象类定义的所有方法，并且返回一个组建好的对象，
 * 例子中的BenzBuilder和BMWBuilder就属于具体建造者；
 * 4、Director导演类：负责安排已有模块的顺序，然后告诉Builder开始建造。
 *
 * 导演类起到封装的作用，避免高层模块深入到建造者内部的实现类，
 * 当然，在建造者模式比较庞大时，导演类可以有多个。
 *
 * 建造者模式的优点：
 * 封装性很好：客户端不必知道产品内部组成得细节；
 * 建造者独立，容易扩展：例如BenzBuilder类和BMWBuilder类是相互独立的，对系统扩展非常有利；
 * 便于控制细节风险：由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不必对其他模块产生任何影响。
 *
 * 建造者模式的使用场景：
 * 1、相同的方法，不同的执行顺序，产生不同的时间结果时；
 * 2、多个部件或零件。都可以装配到一个对象中，但是运行结果又不同时；
 * 3、产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能时；
 * 4、在对象创建过程中会使用到系统中的一些其他对象，这些对象在产品对象的创建过程中不易得到时，
 * 也可以采用建造者模式封装该对象的创建过程。该种场景只能是一个补偿方法，
 * 因为一个对象不易获得，而在设计阶段没有发觉，而要通过建造者模式柔化创建过程，本身已经违反了设计模式法的最初目标。
 *
 * 使用建造者模式的注意事项：
 * 建造者模式关注的事零件类型和装配工艺（顺序的），这是它与工厂方法模式最大不同的地方。
 *
 * 以下展示建造者模式的通用源码。
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 *
 */

//产品类
class Product{
    public void doSomething(){

        //业务处理
    }
}

//抽象建造者
abstract class Builder{
    //设置产品的不同部分，以获取不同的产品
    public abstract void setPart();
    //建造产品
    public abstract Product buildproduct();
}

//具体建造者
//注意：有几个产品类就有几个具体的建造者，而且这几个产品类都具有相同接口或抽象类
class ConcreteProduct extends Builder{

    private Product product = new Product();

    //设置产品零件
    @Override
    public void setPart() {

        //产品类的逻辑处理
    }

    //组建一个产品
    @Override
    public Product buildproduct() {

        return product;
    }
}

//导演类
class Director1{
    private Builder builder = new ConcreteProduct();
    //构建不同的产品
    public Product getProduct(){
        builder.setPart();
        /**
         * 设置不同的零件，产生不同的产品
         */
        return builder.buildproduct();
    }
}

//场景类
public class BuilderPattern {
    public static void main(String[] args){

    }
}
