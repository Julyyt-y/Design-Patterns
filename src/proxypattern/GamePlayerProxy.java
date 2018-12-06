package proxypattern;

/**
 * 游戏代练者类
 * 继承自IGamePlayer接口；
 * 通过构造函数说明谁要打怪，然后通过手动开始代用户打怪、升级。
 */
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer gamePlayer = null;

    public GamePlayerProxy (IGamePlayer _gamePlayer){

        this.gamePlayer = _gamePlayer;
    }

    @Override
    public void login(String user, String password) {

        this.gamePlayer.login(user,password);
    }

    @Override
    public void killBoss() {

        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {

        this.gamePlayer.upgrade();
    }
}
