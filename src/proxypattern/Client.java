package proxypattern;

public class Client {
    public static void main(String[] args){
        //定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        //定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy(player);
        //开始打游戏，记下时间戳
        System.out.println("开始时间是：2018年12月6日11:25:58");
        player.login("张三","password");
        //开始打怪
        player.killBoss();
        //升级
        player.upgrade();
        //记录结束游戏时间
        System.out.println("结束时间是：2018年12月6日11:26:07");
    }
}
