package strategypattern;

/**
 * 场景类，使用计谋
 */
public class Client {
    public static void main(String[] args){
        Context context;
        //刚到吴国的时候拆第一个
        System.out.println("————刚到吴国的时候拆第一个————");
        context = new Context(new BackDoor());
        context.operate();  //拆开执行
        System.out.println("\n\n");
        //拆第二个
        System.out.println("————拆第二个————");
        context = new Context(new GivenGreenLight());
        context.operate();  //拆开执行
        System.out.println("\n\n");
        //拆第三个
        System.out.println("————刘备的追兵过来了，拆第三个————");
        context = new Context(new BlockEnemy());
        context.operate();

    }
}
