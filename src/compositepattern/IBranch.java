package compositepattern;

import java.util.ArrayList;

/**
 * 树枝接口
 */
public interface IBranch extends Root {
    //增加叶子结点（员工）或树枝结点（经理）
    public void addSubordinate(Root root);
    //获得员工信息
    public ArrayList<Root> getSubordinate();
    //解雇员工（删除叶子结点）

}
