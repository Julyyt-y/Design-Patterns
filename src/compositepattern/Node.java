package compositepattern;

/**
 * 树根（公司人员接口）
 */
public abstract class Node {
    //员工姓名
    private String name = "";
    //员工的职位
    private String position = "";
    //职员的工资
    private int salary = 0;
    //父亲结点，有了父亲结点就可以实现前、中、后序遍历
    private Node parent = null;
    //通过构造函数传递员工信息
    public Node(String _name,String _position,int _salary){
        this.name = _name;
        this.position = _position;
        this.salary = _salary;
    }
    //获得职员的信息
    public String getInfo() {
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位：" + this.position;
        info = info + "\t薪水：" + this.salary;
        return info;
    }
    //设置父结点
    protected void setParent(Node _parent){
        this.parent = _parent;
    }
    //得到父结点

    public Node getParent() {
        return this.parent;
    }
}
