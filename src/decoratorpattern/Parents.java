package decoratorpattern;

/**
 * 场景类（家长看成绩单）
 */
public class Parents {
    public static void main(String[] args){
        //成绩单
        SchoolReport sr;
        //原装的成绩单
        sr = new FouthGradeSchoolReport();
        //加了最高分说明后的成绩单
        sr = new HighScoreDecorator(sr);
        //又加了排名后的成绩单
        sr = new SortDecorator(sr);
        //看成绩单
        sr.report();
        //签字
        sr.sign("张三");
    }
}
