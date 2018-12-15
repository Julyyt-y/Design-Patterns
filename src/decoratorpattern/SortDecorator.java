package decoratorpattern;

public class SortDecorator extends Decorator {
    //构造函数
    public SortDecorator(SchoolReport sr) {

        super(sr);
    }
    //告诉父母学校的排名情况
    private void reportSort(){

        System.out.println("我排名第3");
    }
    //父母看完成绩单后再告诉他们，加强作用
    @Override
    public void report(){
        super.report();
        this.reportSort();
    }
}
