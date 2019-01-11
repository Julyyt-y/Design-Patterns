package visitorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式的扩展：统计功能
 */

//抽象访问者
interface IVisitor2 {
    //可以访问普通员工
    public void visit(CommonEmployee2 commonEmployee);
    //可以访问经理
    public void visit(Manager2 manager);
    //统计所有员工工资总和
    public int getTotalSalary();
}

//具体访问者
class Visitor2 implements IVisitor2{
    //经理的工资系数是5
    private final static int MANAGER_COEFFICIENT = 5;
    //员工的工资系数的2
    private final static int COMMONEMPLOYEE_COEFFICIENT = 2;
    //普通员工的工资总和
    private int commonTotalSalary = 0;
    //经理的工资总和
    private int managerTotalSalary = 0;

    //访问普通员工，打印出报表
    @Override
    public void visit(CommonEmployee2 commonEmployee) {
        System.out.println(this.getCommonEmployee(commonEmployee));
    }

    //访问经理，打印出报表
    @Override
    public void visit(Manager2 manager) {
        System.out.println(this.getManagerInfo(manager));
    }

    //组装出基本信息
    private String getBasicInfo(Employee2 employee){
        String info = "姓名" + employee.getName() + "\t";
        info = info + "性别" + (employee.getSex() == Employee.FEMALE ? "女" : "男") + "\t";
        info = info + "薪水" + employee.getSalary() + "\t";
        return info;
    }

    //组装出经理信息
    private String getManagerInfo(Manager2 manager){
        String basicInfo = this.getBasicInfo(manager);
        String otherInfo = "业绩" + manager.getPerformance() + "\t";
        return basicInfo + otherInfo;
    }

    //组装出普通员工信息
    private String getCommonEmployee(CommonEmployee2 commonEmployee){
        String basicInfo = this.getBasicInfo(commonEmployee);
        String otherInfo = "工作" + commonEmployee.getJob() + "\t";
        return basicInfo + otherInfo;
    }

    //计算经理工资总和
    private void calManagerSalary(int salary){
        this.managerTotalSalary = this.managerTotalSalary + salary * MANAGER_COEFFICIENT;
    }

    //计算普通员工工资总和
    private void calCommonSalary(int salary){
        this.commonTotalSalary = this.commonTotalSalary + salary * COMMONEMPLOYEE_COEFFICIENT;
    }

    //获得所有员工工资总和
    @Override
    public int getTotalSalary() {
        return this.commonTotalSalary + this.managerTotalSalary;
    }
}

//抽象员工
abstract class Employee2 {
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

    //允许一个访问者访问
    public abstract void accept(IVisitor2 visitor);
}

//普通员工
class CommonEmployee2 extends Employee2{
    //工作内容
    private String job;
    public String getJob(){
        return job;
    }
    public void setJob(String job){
        this.job = job;
    }

    @Override
    public void accept(IVisitor2 visitor) {
        visitor.visit(this);
    }
}

//管理阶层
class Manager2 extends Employee2{
    //人物职责：业绩
    private String performance;

    public String getPerformance(){
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor2 visitor) {
        visitor.visit(this);
    }
}

//场景类
public class VisitorPatternExtension1 {
    public static void main(String[] args){
        IVisitor2 visitor = new Visitor2();
        for (Employee2 emp : mockEmployee()){
            emp.accept(visitor);
        }
        System.out.println("本月工资总额是：" + visitor.getTotalSalary());
    }

    //模拟公司人员情况
    public static List<Employee2> mockEmployee(){
        List<Employee2> empList = new ArrayList<>();
        //产生一个员工
        CommonEmployee2 employee1 = new CommonEmployee2();
        employee1.setName("employee1");
        employee1.setJob("Java开发");
        employee1.setSalary(10000);
        employee1.setSex(Employee.MALE);
        empList.add(employee1);

        //产生一个员工
        CommonEmployee2 employee2 = new CommonEmployee2();
        employee2.setName("employee2");
        employee2.setJob("Java Web开发");
        employee2.setSalary(10000);
        employee2.setSex(Employee.FEMALE);
        empList.add(employee2);
        //产生一个经理
        Manager2 manager1 = new Manager2();
        manager1.setName("manager1");
        manager1.setPerformance("提需求");
        manager1.setSalary(15000);
        manager1.setSex(Employee.MALE);
        empList.add(manager1);
        return empList;
    }
}
