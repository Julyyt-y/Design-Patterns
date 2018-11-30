package abstractfactorypattern;

public class MaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黄色人种，男性。");
    }
}
