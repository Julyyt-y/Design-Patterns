package observerpattern;

/**
 * 间谍：
 * 间谍的职责是观察被观察者，然后汇报给观察者
 */
public class Spy implements Observer{

    @Override
    public void update(String context) {
        System.out.println("被观察者有活动！");
    }

    private void cry(String context){
        System.out.println("因为" + context + "所以我悲伤");
    }

}

class RealObserver implements Observer{
    @Override
    public void update(String context) {
        System.out.println("观察到被观察者活动。开始行动");
        this.happy(context);
        System.out.println("开心死了");
    }

    private void happy(String context){
        System.out.println("因为" + context + "所以我快乐");
    }
}
