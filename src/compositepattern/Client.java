package compositepattern;

import java.util.ArrayList;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        //组装出一个组织结构
        Branch ceo = compositeNodeTree();
        //打印CEO的信息
        System.out.println(ceo.getInfo());
        //打印所有员工信息
        System.out.println(getTreeInfo(ceo));
    }

    //把整个树组装出来
    public static Branch compositeNodeTree(){
        //总经理ceo（根结点）
        Branch root = new Branch("AAA","CEO",1000000);
        //三个部门经理
        Branch developDep = new Branch("BBB","研发部门经理",100000);
        Branch salasDep = new Branch("CCC","销售部门经理",100000);
        Branch financeDep = new Branch("CCC","财务部经理",100000);
        //三个小组长
        Branch firstDepGroup = new Branch("DDD","开发一组组长",10000);
        Branch secondDepGroup = new Branch("EEE","开发二组组长",10000);
        //所有底层员工
        Leaf a = new Leaf("0","开发人员",5000);
        Leaf b = new Leaf("1","开发人员",5000);
        Leaf c = new Leaf("2","开发人员",5000);
        Leaf d = new Leaf("3","开发人员",5000);
        Leaf e = new Leaf("4","开发人员",5000);
        Leaf f = new Leaf("5","开发人员",5000);
        Leaf g = new Leaf("6","开发人员",5000);
        Leaf h = new Leaf("7","开发人员",5000);
        Leaf i = new Leaf("8","开发人员",5000);
        Leaf j = new Leaf("9","开发人员",5000);
        Leaf K = new Leaf("0","CEO秘书",5000);
        //研发部门副经理
        Leaf H = new Leaf("10","研发部副经理",8000);

        //开始组装
        //CEO下有三个部门经理和一个秘书
        root.addSubordinate(K);
        root.addSubordinate(developDep);
        root.addSubordinate(salasDep);
        root.addSubordinate(financeDep);
        //研发部经理
        developDep.addSubordinate(H);
        developDep.addSubordinate(firstDepGroup);
        developDep.addSubordinate(secondDepGroup);
        //两个研发小组
        firstDepGroup.addSubordinate(a);
        firstDepGroup.addSubordinate(b);
        firstDepGroup.addSubordinate(c);
        secondDepGroup.addSubordinate(d);
        secondDepGroup.addSubordinate(e);
        secondDepGroup.addSubordinate(f);
        //销售部
        salasDep.addSubordinate(g);
        salasDep.addSubordinate(h);
        //财务部
        financeDep.addSubordinate(i);
        financeDep.addSubordinate(j);
        return root;
    }

    //从根结点开始遍历所有结点
    public static String getTreeInfo(Branch root){
        ArrayList<Root> subordinateList = root.getSubordinate();
        String info = "";
        for (Root n : subordinateList){
            if (n instanceof Leaf){
                info = info + n.getInfo() + "\n";
            }else {
                info = info + n.getInfo() + "\n" + getTreeInfo((Branch)n);
            }
        }
        return info;
    }
}
