package templateMethodpattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模板方法的扩展（钩子函数）
 * 利用钩子函数人为控制某个功能是否执行；
 * 其他的基本方法由于不需要对外提供访问，因此设置为protected类型。
 *
 * 【注】：为了演示方便（还有就是不报红）下面各个类都不是public方法，
 *         但具体使用时下面各个类应分别写成.java文件，并且都是public的。
 */

//扩展后的抽象模板类
abstract class HummerMode1{
    /**
     * 首先，这个模型要能够被法定起来，具体怎么发动的无所谓
     */
    protected abstract void start();
    //不仅要发动还要能停下来
    protected abstract void stop();
    //喇叭会发出声音，不管是嘀嘀叫还是哔哔叫
    protected abstract void alarm();
    //引擎会轰隆隆的响
    protected abstract void engineBoom();
    //模型得会跑，不管怎么跑
    final public void run(){
        //先发动汽车
        this.start();
        //引擎开始轰鸣
        this.engineBoom();
        //想让它鸣笛它就鸣笛，不想让它鸣笛就不让它鸣笛
        if (this.isAlarm()){
            this.alarm();
        }
        //达到目的地停车
        this.stop();
    }

    /**
     * 钩子方法，默认喇叭是会响的
     */
    protected boolean isAlarm(){
        return true;
    }
}

//扩展后的H1悍马
class HummerH1Mode1 extends HummerMode1{

    private boolean alarmFlag = true;

    @Override
    protected void start() {

        System.out.println("悍马H1发动");
    }

    @Override
    protected void stop() {

        System.out.println("悍马H1停车");
    }

    @Override
    protected void alarm() {

        System.out.println("悍马H1鸣笛");
    }

    @Override
    protected void engineBoom() {

        System.out.println("悍马H1引擎发动。。。");
    }

    protected boolean isAlarm(){
        return this.alarmFlag;
    }

    //让用户自己来决定要不要鸣笛
    public void setAlarm(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}

//此处省略其他扩展后的悍马

//扩展后的场景类
public class TemplateMethodPatternExtension {

    public static void main(String[] args) throws IOException{
        System.out.println("————H1型悍马————");
        System.out.println("H1型号的悍马是否需要鸣笛：1表示需要，0表示不需要");
        HummerH1Mode1 h1 = new HummerH1Mode1();
        String type = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        if (type.equals("0")){
            h1.setAlarm(false); //h1默认不鸣笛
        }
        h1.run();
    }
}
