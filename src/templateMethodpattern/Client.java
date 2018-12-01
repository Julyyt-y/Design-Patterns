package templateMethodpattern;

//场景类
public class Client {
    public static void main(String[] args){
        //生产H1模型悍马
        HummerMode h1 = new HummerH1Mode();
        //模型演示
        h1.run();
        HummerMode h2 = new HummerH2Mode();
        h2.run();
    }
}
