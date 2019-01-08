package visitorpattern;

/**
 * 抽象员工
 */
public abstract class Employee {
    public final static int MALE = 0;   //0代表男性
    public final static int FEMALE = 1; //1代表女性
    private String name;    //员工姓名
    private int salary;     //员工薪水
    private int sex;        //员工性别

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
//    //打印员工信息
//    public final void report(){
//        String info = "姓名" + this.name + "\t";
//        info = info + "性别" + (this.sex == FEMALE ? "女":"男") + "\t";
//        info = info + "薪水" + this.salary + "\t";
//        //获得员工信息
//        info = info + this.getOtherInfo();
//        System.out.println(info);
//    }
//    //拼装员工的其它信息
//    protected abstract String getOtherInfo();

    //允许一个访问者访问
    public abstract void accept(IVisitor visitor);
}
