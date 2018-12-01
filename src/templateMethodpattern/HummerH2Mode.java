package templateMethodpattern;

public class HummerH2Mode extends HummerMode {
    //H2型号悍马发动
    @Override
    public void start() {

        System.out.println("H2悍马发动。");
    }

    //H2悍马停车
    @Override
    public void stop() {

        System.out.println("H2悍马停车。");
    }

    //H2悍马鸣笛
    @Override
    public void alarm() {

        System.out.println("H2悍马鸣笛");
    }

    //H2悍马引擎轰鸣声
    @Override
    public void engineBoom() {

        System.out.println("H2悍马引擎声音。。。");
    }

}
