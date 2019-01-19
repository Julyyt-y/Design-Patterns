package interpreterpattern;

import java.util.Stack;

/**
 * 解释器模式：
 * 一种按照规定语法进行解析的方案，在现在项目中使用较少。
 * 定义：给定一门语言，定义它的文法的一种表示，并定义一个解释器，
 * 该解释器使用该表示来解释语言中的句子。
 *
 * 例子解释：
 * 业务需求：输入一个模型公式（加减运算），然后输入模型中的参数，运算出结果；
 * 设计要求：公式可以运行时编辑，并且符合正常算术书写平方，例如a+b-c；
 * 高扩展性，未来增加指数，开放，极限，求导等运算符号时较少改动；
 * 效率暂时不用考虑；
 * 业务种类1的公式：a+b+c-d；
 * 业务种类2的公式：a+b+e-d；
 * 业务种类3的公式：a-f；
 *
 * 解释器模式的4个角色：
 * 1、AbstractExpression抽象解释器：具体解释任务由各个实现类完成，
 * 具体的解释器分别由TerminalExpression和NonterminalExpression完成；
 * 2、TerminalExpression终结符表达式：实现与文法中的元素相关联的解释操作，
 * 通常一个解释器模式中只有一个终结符表达式，但有多个实例，对应不同的终结符，
 * 具体到我们的例子就是VarExpression类，表达式中的每一个终结符都早栈中产生了一个VarExpression对象；
 * 3、NonterminalExpression非终结符表达式：文法中的每条规则对应于一个非终结表达式，
 * 具体到我我们的例子就是加减法规则分别对应的AddExpression和SubExpression两个类，
 * 非终结符表达式根据逻辑的复杂程度而增加，原则上每个文法规则都对应一个非终结符表达式；
 * 4、Context环境角色：具体到我们的例子中是采用HashMap代替。
 *
 * 解释器模式的优点：
 * 扩展性非常好。
 *
 * 解释器模式的缺点：
 * 1、解释器模式会引起类膨胀；
 * 2、解释器模式采用递归调用方法；
 * 3、效率问题
 *
 * 解释器模式的使用场景：
 * 1、重复发生的问题；
 * 2、一个简单语法需要解释的场景；
 *
 */

//抽象表达式
abstract class Expression0{
    //每个表达式必须有一个解析任务
    public abstract Object interpreter(Context ctx);
}

//终结符表达式
class TerminalExpression extends Expression0{

    @Override
    public Object interpreter(Context ctx) {
        return null;
    }
}

//非终结符表达式
class NonterminalExpression extends Expression0{

    public NonterminalExpression(Expression0...expression0s){

    }

    @Override
    public Object interpreter(Context ctx) {
        //进行文法处理
        return null;
    }
}

class Context{
    public Context context;

    public Context() {

    }
}

public class InterpreterPattern {
    public static void main(String[] args){
        Context ctx = new Context();
        //通常定义一个语法容器，容纳一个具体的表达式，通常为ListArray、LinkedArray、Stack等类型
        Stack<Expression0> stack = null;
        for (;;){
            //进行语法判断，并产生递归调用
        }
        //产生一个完整语法树，由各个具体的语法分析进行解析
//        Expression0 exp = stack.pop();
        //具体元素进入场景
//        exp.interpreter(ctx);
    }
}
