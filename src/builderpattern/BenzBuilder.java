package builderpattern;

import java.util.ArrayList;

/**
 * 奔驰车组装者
 */
public class BenzBuilder extends CarBuilder {

    private BenzMode benz = new BenzMode();

    @Override
    public void setSequence(ArrayList<String> sequence) {

        this.benz.setSequence(sequence);
    }

    @Override
    public CarMode getCarMode() {

        return this.benz;
    }
}
