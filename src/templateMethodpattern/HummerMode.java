package templateMethodpattern;

/**
 * 以制造悍马为例
 */
//抽象悍马模型
//抽象类，在此类中定义了悍马必须有的特征：能够发动、停止、引擎会响
public abstract class HummerMode {
    /**
     * 首先，这个模型要能够被法定起来，具体怎么发动的无所谓
     */
    public abstract void start();
    //不仅要发动还要能停下来
    public abstract void stop();
    //喇叭会发出声音，不管是嘀嘀叫还是哔哔叫
    public abstract void alarm();
    //引擎会轰隆隆的响
    public abstract void engineBoom();
    //模型得会跑，不管怎么跑
    public void run(){
        //先发动汽车
        this.start();
        //引擎开始轰鸣
        this.engineBoom();
        //开始跑，跑的过程中遇到有人挡路，鸣笛
        this.alarm();
        //达到目的地停车
        this.stop();
    }
}
