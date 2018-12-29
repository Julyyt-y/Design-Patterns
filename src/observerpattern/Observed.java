package observerpattern;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 */
public class Observed implements Observer, observerpattern.Observable {
//    // 被观察者是否在吃饭作为监控的标准
//    private boolean isHavingBreakfast = false;
//    // 被观察者是否在娱乐作为监控的标准
//    private boolean isHavingFun = false;

    //定义一个可变长数组，存放所有的观察者
    private ArrayList<observerpattern.Observer> observerList = new ArrayList<>();

//    //声明观察者
//    private observerpattern.Observer observer = new observerpattern.Observer();

    //被观察者吃饭
//    @Override
    public void haveBreakfast() {
        System.out.println("被观察者开始吃饭");
//        this.isHavingBreakfast = true;
//        this.observer.update("被观察者在吃饭");
        this.notifyObserver("被观察者在吃饭");
    }

    //被观察者开始娱乐
//    @Override
    public void haveFun() {
        System.out.println("被观察者开始娱乐");
//        this.isHavingFun = true;
//        this.observer.update("被观察者在娱乐");
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

    // 以下是setter/getter方法

//    public boolean isHavingBreakfast() {
//        return isHavingBreakfast;
//    }
//
//    public void setHavingBreakfast(boolean havingBreakfast) {
//        isHavingBreakfast = havingBreakfast;
//    }
//
//    public boolean isHavingFun() {
//        return isHavingFun;
//    }
//
//    public void setHavingFun(boolean havingFun) {
//        isHavingFun = havingFun;
//    }

}
