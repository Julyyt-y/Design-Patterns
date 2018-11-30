package abstractfactorypattern;

//八卦炉（制造人类的工厂）
//生产三种不同肤色的人种
public interface HumanFactory {
    //制造一个黄色人种
    public Human createYellowHuman();
    //制造一个白色人种
    public Human createWhiteHuman();
    //制造一个黑色人种
    public Human createBlackHuman();
}
