package proxypattern;

/**
 * 代理模式的扩展（2）——强制代理
 *
 *
 */

interface IGamePlayer2 {
    //登录游戏
    public void login(String user,String password);
    //打怪
    public void killBoss();
    //升级
    public void upgrade();

    /**
     * 第一个改动的地方：在IGamePlayer接口里增加一个getProxy()方法
     * 这样真实角色GamePlayer可以指定一个自己的代理，除了代理以外谁都不能访问
     */
    public IGamePlayer2 getProxy();
}

class GamePlayer2 implements IGamePlayer2 {

    private String name = "";

    private IGamePlayer2 proxy = null;

    //通过构造函数传递名称
    public GamePlayer2(String _name){

        this.name = _name;
    }

    @Override
    public void login(String user, String password) {

        if (this.isProxy()){

            System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
        }else {

            System.out.println("请使用指定的代理访问。");
        }
    }

    /**
     * 此处也有改动
     */
    @Override
    public void killBoss() {
        if (this.isProxy()){

            System.out.println(this.name + "打怪！又升了一级。");
        }else {

            System.out.println("请使用指定的代理访问。");
        }
    }

    @Override
    public void upgrade() {
        if (this.isProxy()){

            System.out.println(this.name + "又升了一级！");
        }else {

            System.out.println("请使用指定的代理访问。");
        }
    }

    /**
     * 第二个改动的地方：
     * 重写IGamePlayer2里面的getProxy()方法和加一个isProxy()方法
     * 找到自己的代理
     */
    @Override
    public IGamePlayer2 getProxy(){
//        this.proxy = new GamePlayerProxy2(this.name); //有错
        return this.proxy;
    }
    private boolean isProxy(){
        if (null == this.proxy){
            return false;
        }else {
            return true;
        }
    }
}

class GamePlayerProxy2 implements IGamePlayer2 {

    //此处的gamePlayer用户名，不是代理者名，就是雇佣代理者帮忙打怪的那个人
    private IGamePlayer2 gamePlayer = null;

    //构造函数初始化，传递被代理者
    public GamePlayerProxy2 (IGamePlayer2 _name){
        this.gamePlayer = _name;
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

    /**
     * 第三处改动的地方
     * 代理得代理暂时还没有，就是自己
     */
    @Override
    public IGamePlayer2 getProxy() {
        return this;
    }
}

//场景类
public class ProxyPatternExtension2 {
    public static void main(String[] args) throws Exception {

        /**
         * 要求必须通过代理来访问，不能直接访问。
         */
        //定义一个玩家
        IGamePlayer2 player = new GamePlayer2("张三");
        //开始打游戏，记下时间戳
        System.out.println("代练者开始时间是：2018年12月7日12:59:29");
        player.login("张三","password");
        //游戏代练者开始打怪
        player.killBoss();
        //游戏代练者打怪升级
        player.upgrade();
        //记录结束游戏时间
        System.out.println("代练者结束时间是：2018年12月7日12:59:34");

        /**
         * 使用代理访问
         */
        //定义一个用户
        IGamePlayer2 player2 = new GamePlayer2("张三");
        //在此扩展下，必须使用代理来访问
        IGamePlayer2 proxy = new GamePlayerProxy2(player2);
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
