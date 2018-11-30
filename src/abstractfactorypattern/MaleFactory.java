package abstractfactorypattern;

//生产男性八卦炉（工厂）
//有生产三种肤色的男性的方法
public class MaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
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
