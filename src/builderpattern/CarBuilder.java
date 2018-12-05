package builderpattern;

import java.util.ArrayList;

/**
 * 抽象汽车组装者
 * 由此类来组装各种车的模型，
 * 要什么类型什么顺序的车辆模型，都由相关的子类完成。
 */
public abstract class CarBuilder {
    //建造一个模型，要知道组装顺序
    public abstract void setSequence(ArrayList<String> sequence);
    //设置完顺序后，就可以获取这个模型
    public abstract CarMode getCarMode();
}
