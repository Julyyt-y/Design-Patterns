package observerpattern;

/**
 * 具体观察者
 */
public class Observer1 implements Observer {

    //给上级汇报
    private void report(String reportText){
        System.out.println("报告，XXX有行动！" + reportText);
    }

    @Override
    public void update(String context) {
        System.out.println("观察到XXX开始活动，向上级汇报。");
        this.report(context);
        System.out.println("汇报完毕。\n");
    }
}
