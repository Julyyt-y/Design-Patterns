package strategypattern;

import java.util.Arrays;

/**
 * 策略模式的扩展：策略枚举
 *
 * 枚举策略的定义：
 * 一个浓缩了策略模式的枚举。
 */

enum Calculator1{
    //加法运算
    ADD("+"){
        public int exec(int a,int b){

            return a + b;
        }
    },
    //减法运算
    SUB("-"){
        public int exec(int a,int b){

            return a - b;
        }
    };
    String value = "";
    //定义成员值类型
    private Calculator1(String _value){

        this.value = _value;
    }
    //获得枚举成员的值
    public String getValue(){

        return this.value;
    }
    //声明一个抽象函数
    public abstract int exec(int a,int b);
}

//场景类
public class StrategyPatternExtension2 {
    public static void main(String[] args){
        //输入的两个参数是数字
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);
        System.out.println("输入的参数为：" + Arrays.toString(args));
        System.out.println("运行结果为：" + a + symbol + b + Calculator1.ADD.exec(a,b));
    }
}
