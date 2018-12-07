package proxypattern;

/**
 * 代理模式的扩展（1）——普通代理
 * 以代理打怪升级为例，两个改动的地方
 *
 * 在此扩展下，系统只需要知道代理者名称即可代理，不用知道代理了谁，
 * 屏蔽了真实角色的变更对高层模块的影响；真实主题角色可随意更改，对高层模块没有任何影响。
 * 非常适合对扩展性要求较高的项目。
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 *
 */

interface IGamePlayer1 {
    //登录游戏
    public void login(String user,String password);
    //打怪
    public void killBoss();
    //升级
    public void upgrade();
}

class GamePlayer1 implements IGamePlayer1 {

    private String name = "";

//    //通过构造函数传递名称
//    public GamePlayer1(String _name){
//
//        this.name = _name;
//    }

    /**
     * 第一个改动的地方：GamePlayer的构造函数
     * 将构造函数限制谁能创建对象，并同时传递姓名
     */
    public GamePlayer1(IGamePlayer1 _gamePlayer1,String _name) throws Exception{
        if (null == _gamePlayer1) {
            throw new Exception("不能创建真实角色！");
        }else{
            this.name = _name;
        }
    }

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

class GamePlayerProxy1 implements IGamePlayer1 {

    //此处的gamePlayer用户名，不是代理者名，就是雇佣代理者帮忙打怪的那个人
    private IGamePlayer1 gamePlayer = null;

//    //构造函数初始化，传递被代理者
//    public GamePlayerProxy1 (IGamePlayer1 _gamePlayer){
//
//        this.gamePlayer = _gamePlayer;
//    }

    /**
     * 第二个改动的地方：GamePlayerProxy类的构造函数
     * 通过构造函数传递要对谁进行代练
     */
    public GamePlayerProxy1(String name){
        try {
            gamePlayer = new GamePlayer1(this,name);
        } catch (Exception e){

            //异常处理
        }
    }

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

public class ProxyPatternExtension1{
    public static void main(String[] args){

        //在此扩展下，系统只需要知道代理者名称即可代理，不用知道代理了谁
        IGamePlayer1 proxy = new GamePlayerProxy1("张三");
        //开始打游戏，记下时间戳
        System.out.println("代练者开始时间是：2018年12月7日12:20:15");
        proxy.login("张三","password");
        //游戏代练者开始打怪
        proxy.killBoss();
        //游戏代练者打怪升级
        proxy.upgrade();
        //记录结束游戏时间
        System.out.println("代练者结束时间是：2018年12月7日12:20:25");
    }
}