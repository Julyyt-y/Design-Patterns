package compositepattern;

import java.util.ArrayList;

/**
 * 树枝实现类
 */
public class Branch implements IBranch {
    //经理的名字
    private String name = "";
    //经理的具体职位
    private String position = "";
    //经理的薪水
    private int salary = 0;
    //经理的下级（所有子孙结点）
    ArrayList<Root> subordinateList = new ArrayList<>();
    //通过构造函数传递领导的信息
    public Branch(String name,String position,int salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    //增加一个下属（结点），可能是叶子结点也可能不是叶子结点
    @Override
    public void addSubordinate(Root root) {
        this.subordinateList.add(root);
    }

    //获得某一经理的所有子孙结点
    @Override
    public ArrayList<Root> getSubordinate() {
        return this.subordinateList;
    }

    //经理的信息
    @Override
    public String getInfo() {
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位：" + this.position;
        info = info + "\t薪水：" + this.salary;
        return info;
    }
}
