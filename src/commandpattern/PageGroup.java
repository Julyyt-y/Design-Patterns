package commandpattern;

/**
 * 美工组
 */
public class PageGroup extends Group {

    //找到这个美工组
    @Override
    public void find() {

        System.out.println("找到美工组...");
    }

    //美工组被要求增加一个页面
    @Override
    public void add() {

        System.out.println("客户要求增加一个页面...");
    }

    //客户要求删除一些页面
    @Override
    public void delete() {

        System.out.println("客户要求删除一些页面...");
    }

    //客户要求对现有页面进行修改
    @Override
    public void change() {

        System.out.println("客户要求对现有页面进行修改...");
    }

    //客户要求给出所有增删改的计划
    @Override
    public void plan() {

        System.out.println("客户要页面变更计划...");
    }
}
