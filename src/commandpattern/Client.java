package commandpattern;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        //首先客户找到需求组
        System.out.println("————客户要求增加一项需求————");
        Group rg = new RequirementGroup();
        //找到需求组
        rg.find();
        //增加一个需求
        rg.add();
        //要求变更计划
        rg.plan();

        //定义负责人
        Invoker XXX = new Invoker();
        //客户要求增加一项需求
        System.out.println("————客户要求增加一项需求————");
        //客户给命令
        Command command = new AddRequirementCommand();
        //负责人收到命令
        XXX.setCommand(command);
        //负责人执行命令
        XXX.action();

        //客户要删除一个页面
        System.out.println("————客户要求删除一个页面————");
        Command command1 = new DeletePageCommand();
        XXX.setCommand(command1);
        XXX.action();
    }
}
