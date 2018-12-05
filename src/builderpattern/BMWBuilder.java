package builderpattern;

import java.util.ArrayList;

/**
 * 宝马车组装者
 * 给定一个汽车的运行顺序，然后就返回一个宝马车
 */
public class BMWBuilder extends CarBuilder {

    private BMWMode bmw = new BMWMode();

    @Override
    public void setSequence(ArrayList<String> sequence) {

        this.bmw.setSequence(sequence);
    }

    @Override
    public CarMode getCarMode() {
        return this.bmw;
    }
}
