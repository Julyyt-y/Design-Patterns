package builderpattern;

import java.util.ArrayList;

/**
 * 导演类
 * 负责按照指定的顺序生产模型
 */
public class Director {

    private ArrayList<String> sequence = new ArrayList<>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();
    /**
     * 组建A型号的奔驰模型：先start，然后stop，其他的都没有。
     */
    public BenzMode getABenzMode(){
        //清理场景，这里是要注意的地方
        this.sequence.clear();
        //这是A类型的执行顺序
        this.sequence.add("start");
        this.sequence.add("stop");
        //按照顺序返回一个奔驰车
        this.benzBuilder.setSequence(this.sequence);
        return (BenzMode)this.benzBuilder.getCarMode();
    }
    /**
     * 组建B型号的奔驰模型：先发动引擎，再启动，再停止。
     */
    public BenzMode getBBenzMode(){
        //清理场景，这里是要注意的地方
        this.sequence.clear();
        //这是B类型的执行顺序
        this.sequence.add("engine boom");
        this.sequence.add("start");
        this.sequence.add("stop");
        //按照顺序返回一个奔驰车
        this.benzBuilder.setSequence(this.sequence);
        return (BenzMode)this.benzBuilder.getCarMode();
    }
    /**
     * 组建C型号的宝马模型：先按喇叭，再启动，再停止。
     */
    public BMWMode getCBMWMode(){
        //清理场景，这里是要注意的地方
        this.sequence.clear();
        //这是C类型的执行顺序
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        //按照顺序返回一个宝马车
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWMode) this.bmwBuilder.getCarMode();
    }
    /**
     * 组建D型号的宝马模型：只启动，其他的都没有。
     */
    public BMWMode getDBMWMode(){
        //清理场景，这里是要注意的地方
        this.sequence.clear();
        //这是C类型的执行顺序
        this.sequence.add("start");
        //按照顺序返回一个宝马车
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWMode) this.bmwBuilder.getCarMode();
    }
    /**
     * 还可以有更多方法...
     */
}
