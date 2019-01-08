package visitorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        for (Employee emp : mockEmployee()){
            emp.accept(new Visitor());
        }
    }
    //模拟公司人员情况
    public static List<Employee> mockEmployee(){
        List<Employee> empList = new ArrayList<>();
        //产生一个员工
        CommonEmployee employee1 = new CommonEmployee();
        employee1.setName("employee1");
        employee1.setJob("Java开发");
        employee1.setSalary(10000);
        employee1.setSex(Employee.MALE);
        empList.add(employee1);
        //产生一个员工
        CommonEmployee employee2 = new CommonEmployee();
        employee2.setName("employee2");
        employee2.setJob("Java Web开发");
        employee2.setSalary(10000);
        employee2.setSex(Employee.FEMALE);
        empList.add(employee2);
        //产生一个经理
        Manager manager1 = new Manager();
        manager1.setName("manager1");
        manager1.setPerformance("提需求");
        manager1.setSalary(15000);
        manager1.setSex(Employee.MALE);
        empList.add(manager1);
        return empList;
    }
}
