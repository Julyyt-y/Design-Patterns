package compositepattern;

public class Leaf implements ILeft{
    //员工姓名
    private String name = "";
    //员工的职位
    private String position = "";
    //职员的工资
    private int salary = 0;
    //通过构造函数传递员工信息
    public Leaf(String name,String position,int salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    //获得职员的信息
    @Override
    public String getInfo() {
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位：" + this.position;
        info = info + "\t薪水：" + this.salary;
        return info;
    }
}
