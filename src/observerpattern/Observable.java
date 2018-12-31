package observerpattern;

import observerpattern.Observer;

/**
 * 通用的被观察者接口，管理所有被观察者
 */
public interface Observable {
    //增加一个观察者
    public void addObserver(Observer observer);
    //删除一个观察者
    public void deleteObserver(Observer observer);
    //观察
    public void notifyObserver(String context);
}
