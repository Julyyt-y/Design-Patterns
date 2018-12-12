package commandpattern;

/**
 * 抽象命令类
 */
public abstract class Command {
    //把需求组、美工组、代码组都定义好
    protected RequirementGroup rg = new RequirementGroup();
    protected PageGroup pg = new PageGroup();
    protected CodeGroup cg = new CodeGroup();
    //只有一个方法
    public abstract void execute();
}
