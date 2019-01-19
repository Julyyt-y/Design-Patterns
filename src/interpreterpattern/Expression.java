package interpreterpattern;
import java.util.HashMap;

/**
 * 抽象表达式类
 */
public abstract class Expression {
    //解析数值和公式，其中var和key值是公式中的参数，value值是具体的数字
    public abstract int interpreter(HashMap<String,Integer> var);
}
