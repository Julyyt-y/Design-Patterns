package facadepattern;

/**
 * 外观模式（门面模式）：
 * 定义：要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。
 * 外观模式提供一个高层次的接口，使得子系统更易于使用。
 * 外观模式注重“统一的对象”，也就是提供一个访问子系统的接口，
 * 除了这个接口外不允许有任何访问子系统的行为发生。
 *
 * 外观模式的两个角色：
 * 1、Facade门面角色：客户端可以调用这个角色的方法，此角色知晓子系统的所有功能和职责，
 * 一般情况下，本角色会将所有从客户端发出的请求委派到相应的子系统中去，
 * 也就是说该角色没有实际的业务逻辑，只是一个委托类；
 * 2、subsystem子系统角色：可以同时有一个或多个子系统，每个子系统都不是一个单独的类，而是一个类的合集。
 * 子系统并不知道门面的存在，对于子系统而言，门面仅仅是另一个客户端而已。
 *
 * 外观模式的优点：
 * 1、减少系统的相互依赖；
 * 2、提高了灵活性；
 * 3、提高了安全性。
 *
 * 外观模式的缺点：
 * 最大的缺点是不符合开闭原则，对修改关闭，对扩展开放。
 *
 * 外观模式的应用场景：
 * 1、为一个复杂的模块或子系统提供一个共外界访问的接口；
 * 2、子系统相对独立——外界对子系统的访问只需要黑箱操作即可；
 * 3、预防低水平人员带来的风险（某个低水平人员只在指定的子系统中进行开发，然后再提供外观接口进行访问操作）。
 *
 * 外观模式的注意事项：
 * 一个子系统可以有多个外观（门面）；
 */

//子系统
class ClassA{
    public void doSomethingA(){
        System.out.println("do something A.");
    }
}
class ClassB{
    public void doSomethingB(){
        System.out.println("do something B.");
    }
}
class ClassC{
    public void doSomethingC(){
        System.out.println("do something C.");
    }
}

//外观对象
class Facade{
    //被委托的对象
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();
    //提供给外部访问的方法
    public void methodA(){
        this.a.doSomethingA();
    }
    public void methodB(){
        this.b.doSomethingB();
    }
    public void methodC(){
        this.c.doSomethingC();
    }
}
public class FacadePattern {
    public static void main(String[] args){
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}

//新增外观
//委托给已经存在的外观对象Facade进行处理
class Facade2{
    //引用原有的外观
    private Facade facade = new Facade();
    //对外提供唯一访问子系统的方法
    public void methodB(){
        this.facade.methodB();
    }
}
