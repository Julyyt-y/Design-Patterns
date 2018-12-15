package decoratorpattern;

public class FouthGradeSchoolReport extends SchoolReport {
    //某个学生的成绩单
    @Override
    public void report() {
        //成绩单的格式
        System.out.println("尊敬的XXX家长：");
        System.out.println("......");
        System.out.println("语文99；数学99；英语99");
        System.out.println("......");
        System.out.println("家长签名：");
    }

    //家长签名
    @Override
    public void sign(String name) {

        System.out.println("家长签名为：" + name);
    }
}
