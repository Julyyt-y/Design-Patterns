package abstractfactorypattern;

//黑色人种抽象类；
//负责黑色人种的抽象属性定义：肤色和语言
public abstract class AbstractBlackHuman implements Human{
    //黑色人种的肤色都是黑色
    public void getColor(){
        System.out.println("黑色人种的肤色都是黑色。");
    }
    //黑色人种讲话
    public void talk(){
        System.out.println("黑色人种会讲话，一般都只是双字节。");
    }
}
