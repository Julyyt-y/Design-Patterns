package abstractfactorypattern;

//黄色人种抽象类；
//负责黄色人种的抽象属性定义：肤色和语言
public abstract class AbstractYellowHuman implements Human{
    //黄色人种的肤色都是黄色
    public void getColor(){

        System.out.println("黄色人种的肤色都是黄色。");
    }
    //黄色人种讲话
    public void talk(){

        System.out.println("黄色人种会讲话，一般都只多字节。");
    }
}
