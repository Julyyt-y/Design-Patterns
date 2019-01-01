package facadepattern;

/**
 * 外观不参与子系统内的逻辑业务
 */

//封装类
class Context{
    //委托处理
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    //复杂的计算
    public void complexMethod(){
        this.a.doSomethingA();
        this.b.doSomethingB();
    }
}
//修改外观
class FacadeExtension{
    //被委托的对象
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
//    private ClassC c = new ClassC();
    private Context context = new Context();
    //提供给外部访问的方法
    public void methodA(){
        this.a.doSomethingA();
    }
    public void methodB(){
        this.b.doSomethingB();
    }
    public void methodC(){
        this.context.complexMethod();
    }
}
public class FacadePatternExtension {
    public static void main(String[] args){
        FacadeExtension facade = new FacadeExtension();
        facade.methodC();
        facade.methodA();
    }
}
