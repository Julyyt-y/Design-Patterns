package templateMethodpattern;

//具体悍马模型H1
public class HummerH1Mode extends HummerMode{
    //H1型号悍马发动
    @Override
    public void start() {

        System.out.println("悍马H1发动。");
    }

    //停车
    @Override
    public void stop() {

        System.out.println("悍马H1停车。");
    }

    //H1号悍马鸣笛
    @Override
    public void alarm() {

        System.out.println("悍马H1鸣笛。");
    }

    //引擎轰鸣声
    @Override
    public void engineBoom() {

        System.out.println("悍马H1引擎声音。。。" );
    }

}
