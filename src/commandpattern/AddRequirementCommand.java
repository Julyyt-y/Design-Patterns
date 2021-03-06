package commandpattern;

/**
 * 增加需求的命令
 */
public class AddRequirementCommand extends Command{

    //执行增加一项需求的命令
    @Override
    public void execute() {
        //找到需求组
        super.rg.find();
        //增加一份需求
        super.rg.add();

        /**
         * 扩展所增加的代码
         */
        //页面也要增加
        super.pg.add();
        super.rg.add();

        //给出计划
        super.rg.plan();
    }
}
