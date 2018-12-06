package builderpattern;

import java.util.ArrayList;

/**
 * 奔驰车组装者
 * 给定一个汽车的运行顺序，然后就返回一个奔驰车
 */
public class BenzBuilder extends CarBuilder {

    private BenzMode benz = new BenzMode();

    //此处的setSequence()方法是复写CarBuilder的方法
    @Override
    public void setSequence(ArrayList<String> sequence) {

        //此处的setSequence()方法是复写CarMode的方法
        this.benz.setSequence(sequence);
    }

    @Override
    public CarMode getCarMode() {

        return this.benz;
    }
}
