package observerpattern;

import observerpattern.Observed;
import observerpattern.Observer1;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) throws InterruptedException{
        Observer1 observer1 = new Observer1();
        Observer1 observer2 = new Observer1();
        Observer1 observer3 = new Observer1();

        //定义出被观察者
        Observed observed1 = new Observed();

        observed1.addObserver(observer1);
        observed1.addObserver(observer2);
        observed1.addObserver(observer3);

        observed1.haveBreakfast();
    }
}
