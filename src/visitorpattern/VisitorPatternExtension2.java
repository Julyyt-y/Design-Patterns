package visitorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式的扩展：多个访问者
 */

//展示表接口
interface IShowVisitor extends IVisitor2{
    //展示报表
    public void report();
}

//具体展示表
class ShowVisitor implements IShowVisitor{

    private String info = "";

    //打印出报表
    @Override
    public void report() {
        System.out.println(this.info);
    }

    //访问普通员工，组装信息
    @Override
    public void visit(CommonEmployee2 commonEmployee) {
        this.info = this.info + this.getBasicInfo(commonEmployee)
                + "工作：" + commonEmployee.getJob() + "\t\n";
    }

    //访问经理，组装信息
    @Override
    public void visit(Manager2 manager) {
        this.info = this.info + this.getBasicInfo(manager)
                + "工作：" + manager.getPerformance() + "\t\n";
    }

    @Override
    public int getTotalSalary() {
        return 0;
    }

    //组装出基本信息
    private String getBasicInfo(Employee2 employee){
        String info = "姓名" + employee.getName() + "\t";
        info = info + "性别" + (employee.getSex() == Employee.FEMALE ? "女" : "男") + "\t";
        info = info + "薪水" + employee.getSalary() + "\t";
        return info;
    }
}

//汇总表接口
interface ITotalVisitor extends IVisitor2{
    //统计所有员工工资总和
    public void totalSalary();
}

//具体汇总表
class TotalVisitor implements ITotalVisitor{

    //经理的工资系数是5
    private final static int MANAGER_COEFFICIENT = 5;
    //员工的工资系数的2
    private final static int COMMONEMPLOYEE_COEFFICIENT = 2;
    //普通员工的工资总和
    private int commonTotalSalary = 0;
    //经理的工资总和
    private int managerTotalSalary = 0;

    @Override
    public void totalSalary() {
        System.out.println("本月的月工资总额是：" + (this.commonTotalSalary + this.managerTotalSalary));
    }

    //访问普通员工，计算工资总和
    @Override
    public void visit(CommonEmployee2 commonEmployee) {
        this.commonTotalSalary  = this.commonTotalSalary + commonEmployee.getSalary() * COMMONEMPLOYEE_COEFFICIENT;
    }

    //访问经理，计算工资总和
    @Override
    public void visit(Manager2 manager) {
        this.managerTotalSalary = this.managerTotalSalary + manager.getSalary() * MANAGER_COEFFICIENT;
    }

    @Override
    public int getTotalSalary() {
        return 0;
    }
}

//场景类
public class VisitorPatternExtension2 {
    public static void main(String[] args){
        //展示报表访问者
        IShowVisitor showVisitor = new ShowVisitor();
        //汇总报表访问者
        ITotalVisitor totalVisitor = new TotalVisitor();
        for (Employee2 emp : mockEmployee()){
            //接受展示报表访问者
            emp.accept(showVisitor);
            //接受汇总表访问者
            emp.accept(totalVisitor);
        }
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
