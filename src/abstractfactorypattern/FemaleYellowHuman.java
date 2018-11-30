package abstractfactorypattern;

//每个抽象类都有两个实现类，分别实现公共最细节、最具体的事物：肤色和语言
//具体的实现类实现肤色、性别定义
//黄色人种又分男女性，故分别定义两个类具体实现男性和女性这两个属性（子类）
//黄色人种女性为例：
public class FemaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黄色人种，女性。");
    }
}
