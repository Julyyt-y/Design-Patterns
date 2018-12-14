package commandpattern;

/**
 * 命令模式的扩展：
 * 扩展一：在AddRequirementCommand类中增加了两行代码
 * 扩展二：反悔问题，客户发出命令后要撤回
 */

//撤销命令
class CancelDeletePageCommand extends Command{

    //撤销删除一个页面的命令
    @Override
    public void execute() {

        super.pg.rollBack();
    }
}
public class PatternExtension {
    public static void main(String[] args){

    }
}
