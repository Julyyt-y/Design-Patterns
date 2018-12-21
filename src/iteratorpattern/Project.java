package iteratorpattern;

import java.util.ArrayList;

public class Project implements IProject {

    //项目列表，所有的项目都放在这里
    private ArrayList<IProject> projectList = new ArrayList<>();
    //项目名称
    private String name = "";
    //项目成员数量
    private int num = 0;
    //项目费用
    private int cost = 0;
    public Project(){

    }
    //定义一个构造函数，把所有要看到的信息都储存下来
    private Project(String name,int num,int cost){
        //赋值到成员变量中
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    //增加项目
    @Override
    public void add(String name, int num, int cost) {

        this.projectList.add(new Project(name,num,cost));
    }

    //得到项目的信息
    @Override
    public String getProjectInfo() {
        String info = "";
        //获得项目名称
        info = info + "项目名称是：" + this.name;
        //获得项目人数
        info = info + "\t项目人数是：" + this.num;
        //项目费用
        info = info + "\t项目费用是：" + this.cost;
        return info;
    }

    //产生一个遍历对象
    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
