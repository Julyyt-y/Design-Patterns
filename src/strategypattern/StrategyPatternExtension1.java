package strategypattern;

import java.util.Arrays;

/**
 * 策略模式的扩展：
 *
 */

//策略模式
interface Calculator{

    public int exec(int a,int b);
}

//具体策略
class Add implements Calculator{
    //加法运算
    @Override
    public int exec(int a, int b) {

        return a + b;
    }
}
class Sub implements Calculator{
    //减法运算
    @Override
    public int exec(int a, int b) {

        return a - b;
    }
}

//上下文
class Context2{
    private Calculator cal = null;
    public Context2(Calculator _cal){

        this.cal = _cal;
    }
    public int exec(int a,int b,String symbol){

        return this.cal.exec(a,b);
    }
}

//场景类
public class StrategyPatternExtension1 {

    //加符号
    private final static String ADD_SYMBOL = "+";
    //减符号
    private final static String SUB_SYMBOL = "-";

    public static void main(String[] args){
        //输入的两个参数是数字
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);
        System.out.println("输入的参数为：" + Arrays.toString(args));
        Context2 context2 = null;
        //判断初始化哪一个策略
        if (symbol.equals(ADD_SYMBOL)){
            context2 = new Context2(new Add());
        }else if (symbol.equals(SUB_SYMBOL)){
            context2 = new Context2(new Sub());
        }
        System.out.println("运行结果为：" + a + symbol + b + "=" + context2.exec(a,b,symbol));
    }
}
