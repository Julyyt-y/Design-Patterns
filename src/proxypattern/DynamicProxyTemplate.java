package proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的通用源码
 *
 * 动态代理类（DynamicProxy<T>）：
 * 由InvocationHandler的实现类实现所有的方法，由其invoke()方法接管所有的实现方法。
 *
 * 要实现动态代理的首要条件是：被代理类必须实现一个借口，
 * 当然现在也有很多技术如CGLIB可以实现不需要借口也可以实现动态代理的方式。
 */

//抽象主题
interface Subject2{
    //一种标识方法，可以有多个逻辑处理方法
    public void doSomething(String str);
}

//真实主题
class RealSubject2 implements Subject2{

    @Override
    public void doSomething(String str) {

        System.out.println("do Something!---->" + str);
    }
}

//动态代理的Handler类
//重点
class MyInvocationHandler implements InvocationHandler{

    //被代理对象
    private Object target = null;
    //通过构造函数传递一个对象
    public MyInvocationHandler(Object _obj){
        this.target = _obj;
    }

    //代理方法
    //所有动态代理的方法全部通过invoke()方法调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行被代理方法
        return method.invoke(this.target,args);
    }
}

//动态代理类
class DynamicProxy<T> {
    /**
     * 该方法重新生成了一个对象。
     * getInterfaces()方法是查找该类的所有接口，然后实现接口的所有方法；
     * 然而这些方法都是空的，new MyInvocationHandler(_obj)这个对象负责管理这些方法；
     *
     */
    public static <T> T newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h){
        //寻找JoinPoint连接点，AOP框架使用元数据定义
        if (true){
            //执行一个前置通知
            (new BeforeAdvice()).exec();
        }
        //执行目标，并返回结果
        return (T) java.lang.reflect.Proxy.newProxyInstance(loader,interfaces,h);
    }
}

//通知接口及实现
interface IAdvice{
    //通知只有一个方法，执行即可
    public void exec();
}
class BeforeAdvice implements IAdvice{

    @Override
    public void exec() {

        System.out.println("我是前置通知，我被执行了！");
    }
}

//具体业务的动态代理
class SubjectDynamicProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject2 subject){
        //获得ClassLoader
        ClassLoader loader = subject.getClass().getClassLoader();
        //获得接口数组
        Class<?>[] classes = subject.getClass().getInterfaces();
        //获得handler
        InvocationHandler handler = new MyInvocationHandler(subject);
        return newProxyInstance(loader,classes,handler);
    }
}

//动态代理的场景类
public class DynamicProxyTemplate {
    public static void main(String[] args){

        //定义一个主题
        Subject2 subject = new RealSubject2();
        //定义主题的代理
        Subject2 proxy = SubjectDynamicProxy.newProxyInstance(subject);
        //代理的行为
        proxy.doSomething("Finish");
    }
}
