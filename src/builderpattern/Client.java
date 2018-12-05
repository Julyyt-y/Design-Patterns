package builderpattern;

import java.util.ArrayList;

/**
 * 场景类：
 * 需求：BenzMode类的benz对象要：先发动引擎，再启动，再停车。
 */
public class Client {

    public static void main(String[] args){
        //存放run的顺序
        ArrayList<String> sequence = new ArrayList<>();
        //存放run的地址
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");
        //要制造一个奔驰车
        BenzBuilder benzBuilder = new BenzBuilder();
        //把顺序给BenzBuilder的对象，制造此车
        benzBuilder.setSequence(sequence);
        //制造
        BenzMode benz = (BenzMode)benzBuilder.getCarMode();
        //跑模型
        benz.run();
    }
}
