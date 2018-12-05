package builderpattern;

import java.util.ArrayList;

/**
 * 场景类：
 * 需求：BenzMode类的benz对象要：先发动引擎，再启动，再停车。
 */
public class Client {

    public static void main(String[] args){
//        //存放run的顺序
//        ArrayList<String> sequence = new ArrayList<>();
//        //存放run的地址
//        sequence.add("engine boom");
//        sequence.add("start");
//        sequence.add("stop");
//        //要制造一个奔驰车
//        BenzBuilder benzBuilder = new BenzBuilder();
//        //把顺序给BenzBuilder的对象，制造此车
//        benzBuilder.setSequence(sequence);
//        //制造
//        BenzMode benz = (BenzMode)benzBuilder.getCarMode();
//        //跑模型
//        benz.run();
//        //按照同样的顺序，再制造一个宝马
//        BMWBuilder bmwBuilder = new BMWBuilder();
//        bmwBuilder.setSequence(sequence);
//        BMWMode bmw = (BMWMode) bmwBuilder.getCarMode();
//        bmw.run();

        Director director = new Director();
        //100辆A类型的奔驰车
        for (int i=0;i<100;i++){
            director.getABenzMode().run();
        }
        //50辆B类型奔驰车
        for (int i=0;i<50;i++){
            director.getBBenzMode().run();
        }
        //100辆C类型宝马车
        for (int i=0;i<100;i++){
            director.getCBMWMode().run();
        }
        //50辆D类型宝马车
        for (int i=0;i<50;i++){
            director.getDBMWMode().run();
        }
    }
}
