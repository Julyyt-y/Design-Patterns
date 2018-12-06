package builderpattern;

import java.util.ArrayList;

/**
 * 宝马车组装者
 * 给定一个汽车的运行顺序，然后就返回一个宝马车
 */
public class BMWBuilder extends CarBuilder {

    private BMWMode bmw = new BMWMode();

    //此处的setSequence()方法是复写CarBuilder的方法
    @Override
    public void setSequence(ArrayList<String> sequence) {

        //此处的setSequence()方法是复写CarMode的方法
        this.bmw.setSequence(sequence);
    }

    @Override
    public CarMode getCarMode() {
        return this.bmw;
    }
}
