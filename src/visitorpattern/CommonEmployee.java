package visitorpattern;

/**
 * 普通员工
 */
public class CommonEmployee extends Employee{
    //工作内容
    private String job;
    public String getJob(){
        return job;
    }
    public void setJob(String job){
        this.job = job;
    }
    @Override
    protected String getOtherInfo() {
        return "工作" + this.job + "\t";
    }
}
