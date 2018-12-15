package decoratorpattern;

/**
 * 修饰的抽象类
 */
public abstract class Decorator extends SchoolReport{
    //首先要知道的事哪个成绩
    private SchoolReport sr;
    //构造函数，传递成绩单过来
    public Decorator(SchoolReport sr){
        this.sr = sr;
    }
    //成绩单还是要被看到
    public void report(){
        this.sr.report();
    }
    //看完也还是要签名
    public void sign(String name){
        this.sr.sign(name);
    }
}
