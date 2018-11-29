package factorymethodpattern;

/**
 * 工厂方法模式：
 * 定义一个用于创建对象的接口，让子类去决定实例化哪一个类。
 * 工厂方法使一个类的实例化延迟到其子类。
 *
 * 在工厂方法模式中（以此包中实现的工厂方法为例），
 * 抽象产品类Goods负责定义产品的共性，实现对事物最抽象的定义；
 * Factory为抽象创建类，也就是抽象工厂；
 * 具体如何创建产品类是由具体的实现工厂也就是GoodsFactory类完成的。
 *
 * 工厂方法模式的优点：
 * 1、良好的封装性，代码结构清晰。一个对象的创建是有条件约束的，
 * 如一个调用者需要一个具体的产品对象，只要知道这个产品的类名（或约束字符串）就可以了，这要降低了模块间的耦合。
 * 2、扩展性非常优秀。在增加产品类的情况下，只要适当的修改具体的工厂类或扩展一个工厂类，就可以完成“拥抱变化”。
 * 3、屏蔽产品类。这一点非常重要，调用者只需要关心产品的接口，只要接口保持不变，系统中的上层模块就不要发生变化。
 * 因为产品类的实例化工作是由工厂类负责的，一个产品对象具体由哪一个产品生产是由工厂类决定的。
 * 4、典型的耦合框架。高层模块值只需要知道产品的抽象类，其他的实现类都不用关心。
 *
 * 工厂方法模式的使用场景：
 * 需要灵活地、可扩展的框架时，可考虑使用工厂方法模式；也可以用在异构项目中；可以使用在测试驱动开发的框架下。
 *
 * 工厂方法模式的变种较多，下面展示一种比较实用的通用实现方式。
 * 该通用代码是一个比较实用、易扩展的框架，可根据实际情况进行扩展。
 *
 * 【注】：此处只是为了展示工厂方法模式而将这些类放在一个.java文件中的，
 *         把下面几个类都变成.java文件就不会报红，
 */
public class FactoryMethodPattern {
}

////抽象产品类：
//public abstract class Product{
//    //产品类的公共方法
//    public void method1(){
//        //业务逻辑处理
//    }
//    //抽象方法
//    public abstract void method2();
//}
//
////具体产品类。具体产品类可以有多个，都继承于抽象产品类
//public class ConcreteProduct1 extends Product{
//    public void method2(){
//        //业务逻辑处理
//    }
//}
//public class ConcreteProduct2 extends Product{
//    public void method2(){
//        //业务逻辑处理
//    }
//}
//
////抽象工厂类
//public abstract class Creator{
//    /**
//     * 创建一个产品对象，其输入参数类型可以自行设置；
//     * 通常为String、Enume、Class等，当然也可以为空。
//     */
//    public abstract <T extends Product> T createProduct(Class<T> c);
//}
//
////具体工厂类。具体工厂类负责实现具体如何生产一个产品的对象
//public class ConcreteCreater extends Creator {
//    public <T extends Product> T createProduct(Class<T> c){
//        Product product = null;
//        try {
//            product = (Product)Class.forName(c.getName()).newInstance();
//        }catch (Exception e){
//            //异常处理
//        }
//        return (T)product;
//    }
//}
//
////场景类
//public class Clientt {
//    public static void main(String[] args){
//        Creator creator = new ConcreteCreater();
//        Product product = creator.createProduct(ConcreteProduct1.class);
//        /**
//         * 继续业务处理
//         */
//    }
//}