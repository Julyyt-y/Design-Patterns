package visitorpattern;

/**
 * 访问者接口
 */
public interface IVisitor {
    //定义访问普通员工
    public void visit(CommonEmployee commonEmployee);
    //访问经理
    public void visit(Manager manager);
}
