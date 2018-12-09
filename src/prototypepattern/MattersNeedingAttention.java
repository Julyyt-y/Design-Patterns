package prototypepattern;

/**
 * 原型模式的注意事项：
 *
 * （一）构造函数不会被执行
 * 一个实现了Cloneable并重写的clone方法的类A，有一个无参构造或有参构造函数B，通过new关键字产生一个对象S，
 * 再然后通过S.clone()方式产生了一个新对象T，name在对象拷贝是构造函数是不会被执行的；
 *
 * （二）浅拷贝和神拷贝
 * 浅拷贝：
 * Object类提供的方法clone()只是拷贝对象，
 * 其对象内部的数组、引用对象等都不拷贝，还是指向原生对象的内部元素地址。
 * 两个或几个对象公用一个私有变量，非常不安全，在实际项目中使用还是较少的；
 * 深拷贝：
 * 在浅拷贝的基础上增加了一行代码，对私有的类变量进行独立的拷贝。
 * 深拷贝和浅拷贝不建议混合使用，特别是在涉及类的继承时，父类有多个引用的情况就非常复杂。
 * （三）clone和final
 * 对象的clone与对象的final关键字是有冲突的；
 * 因为final修饰的成员变量不允许被深拷贝，
 * 但是可以被浅拷贝。
 */

import java.util.ArrayList;

/**
 * 演示构造函数不会被执行
 */
class Thing1 implements Cloneable{
    public Thing1(){
        //这句话只会执行一次
        System.out.println("我是Thing类的构造函数");
    }

    @Override
    public Thing1 clone() {
        Thing1 thing = null;
        try {
            thing = (Thing1)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return thing;
    }
}

/**
 * 演示浅拷贝和深拷贝
 */
//浅拷贝
class Thing2 implements Cloneable{
    //定义一个私有变量
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public Thing2 clone() {
        Thing2 thing = new Thing2();
        try {
            thing = (Thing2)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return thing;
    }
    //设置HashMap的值
    public void setValue(String value){

        this.arrayList.add(value);
    }
    //取得ArrayList的值
    public ArrayList<String> getValue() {
        return this.arrayList;
    }
}
//深拷贝
class Thing3 implements Cloneable{
    //定义一个私有变量
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public Thing3 clone() {
        Thing3 thing3 = null;
        try {
            thing3 = (Thing3)super.clone();
            thing3.arrayList = (ArrayList<String>)this.arrayList.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return thing3;
    }
    //设置HashMap的值
    public void setValue(String value){

        this.arrayList.add(value);
    }
    //取得ArrayList的值
    public ArrayList<String> getValue() {
        return this.arrayList;
    }
}

/**
 * 演示clone和final有冲突
 */
class Thing4 implements Cloneable{
    //定义一个私有变量
    private final ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public Thing4 clone() {
        Thing4 thing4 = null;
        try {
            thing4 = (Thing4)super.clone();
            //下面这行代码注释了的原因是报错了，
            //报错的原因是final修饰的成员变量不允许被深拷贝，但是可以被浅拷贝（比如上面这行代码）
//            thing4.arrayList = (ArrayList<String>)this.arrayList.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return thing4;
    }
}

//场景类
public class MattersNeedingAttention {
    public static void main(String[] args){

        //测试拷贝是构造函数不会被执行
        //产生一个对象
        Thing1 thing1 = new Thing1();
        //拷贝一个对象
        Thing1 cloneThing1 = thing1.clone();

        //测试浅拷贝
        //产生一个对象
        Thing2 thing2 = new Thing2();
        //设置一个值
        thing2.setValue("张三");
        //拷贝一个对象
        Thing2 cloneThing2 = thing2.clone();
        cloneThing2.setValue("张三。");
        System.out.println(thing2.getValue());

        //测试深拷贝
        //产生一个对象
        Thing3 thing3 = new Thing3();
        //设置一个值
        thing3.setValue("李四");
        //拷贝一个对象
        Thing3 cloneThing3 = thing3.clone();
        cloneThing3.setValue("李四。");
        System.out.println(thing3.getValue());

    }
}
