package visitorpattern;

/**
 * 管理阶层
 */
public class Manager extends Employee{
    //人物职责：业绩
    private String performance;

    public String getPerformance(){
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    protected String getOtherInfo() {
        return "业绩" + this.performance + "\t";
    }
}
