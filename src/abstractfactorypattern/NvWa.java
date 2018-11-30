package abstractfactorypattern;

//女娲造人（场景类）
public class NvWa {
    public static void main(String[] args){
        //第一条生产线，男性生产线
        HumanFactory maleHumanFactory = new MaleFactory();
        //第二条生产线，女性生产线
        HumanFactory femaleHumanFactory = new FemaleFactory();
        //开始生产
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        System.out.println("——————生产一个黄色人种的女性——————");
        femaleYellowHuman.getColor();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
        System.out.println("——————生产一个黄色人种的男性——————");
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();
        //生产白色人种男女性和黑色人种男女性都是如此步骤，不再演示
    }
}
