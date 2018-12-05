package builderpattern;

import java.util.ArrayList;

/**
 * 建造者模式：批量生产汽车
 */
public abstract class CarMode {
    //这个参数是各个基本方法执行的顺序
    private ArrayList<String> sequence = new ArrayList<>();
    //模型是启动开始跑了
    protected abstract void start();
    //能停下来
    protected abstract void stop();
    //喇叭会响，嘀嘀叫或者哔哔叫
    protected abstract void alarm();
    //引擎会轰隆隆响
    protected abstract void engineBoom();
    //此模型要跑起来
    //run()方法读取sequence，然后遍历sequence中的字符串，哪个字符在前就先执行哪个方法
    final public void run(){
        //循环一遍，谁在前就执行谁
        for (int i=0;i<this.sequence.size();i++){
            String actionName = this.sequence.get(i);
            if (actionName.equalsIgnoreCase("start")){
                this.start();   //开启汽车
            }else if (actionName.equalsIgnoreCase("stop")){
                this.stop();    //停止汽车
            }else if (actionName.equalsIgnoreCase("alarm")){
                this.alarm();   //喇叭响
            }else if (actionName.equalsIgnoreCase("engine boom")){
                this.engineBoom();      //引擎响
            }
        }
    }

    //把传递过来的值传递到类内
    final public void setSequence(ArrayList<String> sequence){
        this.sequence = sequence;
    }
}
