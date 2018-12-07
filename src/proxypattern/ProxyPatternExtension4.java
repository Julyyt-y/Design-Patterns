package proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Proxy;

/**
 * 代理模式的扩展（4）——动态代理（重点）
 * 动态代理在实现阶段不用关系代理谁，而是在运行阶段才指定代理哪一个对象。
 * 面向横切面编程的核心就是采用了动态代理机制。
 *
 * invoke()方法是InvocationHandler接口定义必须实现的，它完成对真实方法的调用；
 * 动态代理是根据被代理的接口生成所有的方法。
 */

interface IGamePlayer3 {
    //登录游戏
    public void login(String user,String password);
    //打怪
    public void killBoss();
    //升级
    public void upgrade();
}

class GamePlayer3 implements IGamePlayer3 {

    private String name = "";

    //通过构造函数传递名称
    public GamePlayer3(String _name){

        this.name = _name;
    }

//    /**
//     * 第一个改动的地方：GamePlayer的构造函数
//     * 将构造函数限制谁能创建对象，并同时传递姓名
//     */
//    public GamePlayer3(IGamePlayer3 _gamePlayer3,String _name) throws Exception{
//        if (null == _gamePlayer3) {
//            throw new Exception("不能创建真实角色！");
//        }else{
//            this.name = _name;
//        }
//    }

    @Override
    public void login(String user, String password) {

        System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
    }

    @Override
    public void killBoss() {

        System.out.println(this.name + "打怪！");
    }

    @Override
    public void upgrade() {

        System.out.println(this.name + "又升了一级！");
    }
}

class GamePlayerProxy3 implements IGamePlayer3 {

    //此处的gamePlayer用户名，不是代理者名，就是雇佣代理者帮忙打怪的那个人
    private IGamePlayer3 gamePlayer = null;

    //构造函数初始化，传递被代理者
    public GamePlayerProxy3 (IGamePlayer3 _gamePlayer){

        this.gamePlayer = _gamePlayer;
    }

//    /**
//     * 第二个改动的地方：GamePlayerProxy类的构造函数
//     * 通过构造函数传递要对谁进行代练
//     */
//    public GamePlayerProxy3(String name){
//        try {
//            gamePlayer = new GamePlayer3(this,name);
//        } catch (Exception e){
//
//            //异常处理
//        }
//    }

    @Override
    public void login(String user, String password) {

        //此处的login是IGamePlayer里的方法
        this.gamePlayer.login(user,password);
    }

    @Override
    public void killBoss() {

        //此处的killBoss是IGamePlayer里的方法
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {

        //此处的upgrade是IGamePlayer里的方法
        this.gamePlayer.upgrade();
    }
}

/**
 * 动态代理类
 * InvocationHandler是JDK提供的动态代理接口
 */
class GamePlayIH implements InvocationHandler{

    //被代理者
    Class cls = null;
    //被代理的实例
    Object obj = null;
    //要代理的人
    public GamePlayIH(Object _obj){
        this.obj = _obj;
    }

    //调用被代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj,args);
        if (method.getName().equalsIgnoreCase("login")){
            System.out.println("有人在用我的账号登录！");
        }
        return result;
    }
}

public class ProxyPatternExtension4 {
    public static void main(String[] args) throws Exception {

        IGamePlayer3 player = new GamePlayer3("张三");
        InvocationHandler handler = new GamePlayIH(player);
        System.out.println("开始时间：2018年12月7日15:29:15");
        ClassLoader cl = player.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer3 proxy = (IGamePlayer3) java.lang.reflect.Proxy.newProxyInstance
                (cl,new Class[]{IGamePlayer3.class},handler);
        proxy.login("李四","password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间：2018年12月7日15:33:03");
    }
}

