package observerpattern;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 */
public class Observed implements Observer, observerpattern.Observable {

    //定义一个可变长数组，存放所有的观察者
    private ArrayList<observerpattern.Observer> observerList = new ArrayList<>();


    public void haveBreakfast() {
        System.out.println("被观察者开始吃饭");
        this.notifyObserver("被观察者在吃饭");
    }

    public void haveFun() {
        System.out.println("被观察者开始娱乐");
        this.notifyObserver("被观察者在娱乐");
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    //增加观察者
    @Override
    public void addObserver(observerpattern.Observer observer) {
        this.observerList.add(observer);
    }

    //删除观察者
    @Override
    public void deleteObserver(observerpattern.Observer observer) {
        this.observerList.remove(observer);
    }

    //通知所有观察者
    @Override
    public void notifyObserver(String context) {
        for (observerpattern.Observer observer : observerList){
            observer.update(context);
        }
    }
}
