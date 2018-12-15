package decoratorpattern;

public class HighScoreDecorator extends Decorator{
    //构造函数
    public HighScoreDecorator(SchoolReport sr) {

        super(sr);
    }
    //要汇报最高成绩
    private void reportHighScore(){

        System.out.println("这次语文最高成绩是100；数学是100；英语是100。");
    }
    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }
}
