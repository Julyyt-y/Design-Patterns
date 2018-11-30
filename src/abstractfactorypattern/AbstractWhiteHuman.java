package abstractfactorypattern;

//白色人种抽象类；
//负责白色人种的抽象属性定义：肤色和语言
public abstract class AbstractWhiteHuman implements Human{
    //白色人种的肤色都是白色
    public void getColor(){
        System.out.println("白色人种的肤色都是白色。");
    }
    //白色人种讲话
    public void talk(){
        System.out.println("白色人种会讲话，一般都只单字节。");
    }
}
