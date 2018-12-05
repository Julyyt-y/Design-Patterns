package builderpattern;

/**
 * 奔驰模型代码
 */
public class BenzMode extends CarMode{
    @Override
    protected void start() {

        System.out.println("奔驰跑起来是这样的。。。");
    }

    @Override
    protected void stop() {

        System.out.println("奔驰应该这样停车。。。");
    }

    @Override
    protected void alarm() {

        System.out.println("奔驰的喇叭声音是这样的。。。");
    }

    @Override
    protected void engineBoom() {

        System.out.println("奔驰的引擎是这样的。。。");
    }
}
