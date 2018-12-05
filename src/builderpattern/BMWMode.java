package builderpattern;

/**
 * 宝马模型代码
 */
public class BMWMode extends CarMode {
    @Override
    protected void start() {

        System.out.println("宝马跑起来是这样的。。。");
    }

    @Override
    protected void stop() {

        System.out.println("宝马应该这样停车。。。");
    }

    @Override
    protected void alarm() {

        System.out.println("宝马喇叭这样响。。。");
    }

    @Override
    protected void engineBoom() {

        System.out.println("宝马的引擎是这样的。。。");
    }
}
