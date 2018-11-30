package abstractfactorypattern;

//生产女性八卦炉（工厂）
//有生产三种肤色的女性的方法
public class FemaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return null;
    }

    @Override
    public Human createBlackHuman() {
        return null;
    }
}
