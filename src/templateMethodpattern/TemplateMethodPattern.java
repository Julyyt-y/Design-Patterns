package templateMethodpattern;

/**
 * 模板方法模式：
 * 定义一个操作中的算法框架，而将一些步骤延迟到子类中，
 * 使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定步骤。
 * （为了防止恶意的操作，一般模板方法都加上final关键字，不允许被复写）
 * 基本方法：
 * 也叫作基本操作，是由子类实现的方法，并且在模板方法中被调用。
 * 模板方法：
 * 可以有一个或几个，一般是一个具体方法，也就是一个框架，实现对基本方法的调度，完成固定的逻辑。
 *
 * 注意：模板放中的基本方法尽量设计为protected类型，符合迪米特法则，
 * 不需要暴露的属性或方法尽量不要设置为protected类型。
 * 实现类若非必要，尽量不要扩大父类中的访问权限。
 *
 * 模板方法模式的优点：
 * （1）封装部分不变，扩展可变部分
 * 把认为是不变部分的算法封装到父类实现，而可变的部分则可以通过继承类继续扩展；
 * （2）提取公共部分代码，便于维护
 * （3）行为由父类控制，子类实现
 * 基本方法是由子类实现的，因此子类可以通过扩展的方式增加相应的功能。
 *
 * 模板方法模式的缺点：
 * 增加了代码的阅读难度，
 * 抽象类定义了部分抽象方法，由子类实现，子类执行的结果影响了父类的结果，
 * 也就是对父类产生了影响，这会增加代码的阅读难度。
 *
 * 模板方法的使用场景：
 * （1）多个子类共有的方法，并且逻辑基本相同时；
 * （2）重要、复杂的算法，可以把核心算法设计为模板方法，周边的相关细节则由各个子类实现；
 * （3）重构时，模板方法是一个经常使用的模式，把相同的代码抽取到父类中，然后通过钩子函数（见扩展）约束其行为。
 */

//抽象模板类
abstract class AbstractClass{
    //基本方法
    protected abstract void doSomething();
    //基本方法
    protected abstract void doAnything();
    //模板方法
    public void templateMethod(){
        /**
         * 调用基本方法，完成相关逻辑
         */
        this.doSomething();
        this.doAnything();
    }
}
//具体模板方法1
class ConcreteClass1 extends AbstractClass{

    @Override
    protected void doSomething() {

        //业务逻辑处理
    }

    @Override
    protected void doAnything() {

        //业务逻辑处理
    }
}

//具体模板方法2
class ConcreteClass2 extends AbstractClass{

    @Override
    protected void doSomething() {

        //业务逻辑处理
    }

    @Override
    protected void doAnything() {

        //业务逻辑处理
    }
}

//场景类
public class TemplateMethodPattern {
    public static void main(String[] args){
        AbstractClass class1 = new ConcreteClass1();
        AbstractClass class2 = new ConcreteClass2();
        class1.templateMethod();
        class2.templateMethod();
    }
}
