package decoratorpattern;

/**
 * 修饰成绩单
 */
public class DecorateFouthSchoolReport extends FouthGradeSchoolReport{
    //首先定义美化的方法，比如先说最高成绩
    private void reportHighScore(){

        System.out.println("这次语文最高成绩是100；数学是100；英语是100。");
    }
    //汇报完成绩之后，再汇报在学校的排名情况
    private void reportSort(){

        System.out.println("这次是第3名。");
    }
    //由于汇报内容发生变化，所以要重写父类
    @Override
    public void report(){
        this.reportHighScore();;
        super.report();
        this.reportSort();
    }
}
