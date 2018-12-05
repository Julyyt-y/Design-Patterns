package builderpattern;

import java.util.ArrayList;

/**
 * 宝马车组装者
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
