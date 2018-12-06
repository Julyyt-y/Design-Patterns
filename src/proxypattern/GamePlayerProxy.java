package proxypattern;

/**
 * 游戏代练者类
 * 继承自IGamePlayer接口；
 * 通过构造函数说明谁要打怪，然后通过手动开始代用户打怪、升级。
 */
public class GamePlayerProxy implements IGamePlayer {

    //此处的gamePlayer用户名，不是代理者名，就是雇佣代理者帮忙打怪的那个人
    private IGamePlayer gamePlayer = null;

    //构造函数初始化，传递被代理者
    public GamePlayerProxy (IGamePlayer _gamePlayer){

        this.gamePlayer = _gamePlayer;
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
