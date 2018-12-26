package compositepattern;

import java.util.ArrayList;

/**
 * 树枝实现类
 */
public class Branch extends Node {
    //经理的下级（所有子孙结点）
    ArrayList<Node> subordinateList = new ArrayList<>();
    //通过构造函数传递领导的信息
    public Branch(String _name,String _position,int _salary){
        super(_name,_position,_salary);
    }
    //增加一个下属（结点），可能是叶子结点也可能不是叶子结点
    public void addSubordinate(Node node) {
        this.subordinateList.add(node);
    }

    //获得某一经理的所有子孙结点
    public ArrayList<Node> getSubordinate() {
        return this.subordinateList;
    }

}
