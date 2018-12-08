package prototypepattern;

/**
 * 原型模式：
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 原型模式的简单程度仅次于单例模式和迭代器模式，所以它的使用场景非常多。
 *
 * 原型模式的核心是clone()方法，通过该方法进行对象的拷贝；
 * Java提供了一个Cloneable接口来标识这个对象是可拷贝的，
 * API文档中显示Cloneable接口中一个方法都没有，这个接口只是一个标识作用，
 * 在JVM中具有这个可标记的对象才能被拷贝；
 * 让对象变为可拷贝的方法：覆盖（重写）clone()方法。
 * 这个clone()方法是Object类中的（Java的每个类都默认继承了Object类）。
 *
 * 原型模式的优点：
 * 1、性能优良：原型模式是内存二进制流的拷贝，比直接new一个对象的性能要好很多，特别是要在一个循环体呢产生大量对象时；
 * 2、逃避构造函数的约束：这也是它的缺点；直接在内存中拷贝，构造函数是不会执行的。
 *
 * 原型模式的使用场景：
 * 1、资源优化场景：类初始化需要消耗非常多资源，这些西苑包括数据、硬件资源等；
 * 2、性能和安全要求的场景：通过new产生一个对象需要非常繁琐的数据追被或访问权限，则可以使用原型模式；
 * 3、一个对象多个修改者的场景：一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，
 * 可以考虑用原型模式拷贝多个对象共调用者调试。
 *
 * 以下展示原型模式的通用源码：
 *
 */

//原型模式的通用源码
public class PrototypePattern implements Cloneable{
    //复写父类Object的clone()方法

    @Override
    public PrototypePattern clone() {
        PrototypePattern prototypePattern = null;
        try {
            prototypePattern = (PrototypePattern)super.clone();
        }catch (CloneNotSupportedException e){
            //异常处理
        }
        return prototypePattern;
    }
}
