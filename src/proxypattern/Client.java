package proxypattern;

public class Client {
    public static void main(String[] args){
        //定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        //定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy(player);
        //开始打游戏，记下时间戳
        System.out.println("代练者开始时间是：2018年12月6日11:25:58");
        proxy.login("张三","password");
        //游戏代练者开始打怪
        proxy.killBoss();
        //游戏代练者打怪升级
        proxy.upgrade();
        //记录结束游戏时间
        System.out.println("代练者结束时间是：2018年12月6日11:26:07");
        System.out.println( );

        //不使用代理者，用户自己打怪升级
        IGamePlayer player1 = new GamePlayer("李四");
        System.out.println("用户开始时间是：2018年12月6日13:31:02");
        player1.login("李四","password");
        player1.killBoss();
        player1.upgrade();
        System.out.println("用户结束时间是：2018年12月6日13:32:40");
    }
}
