package compositepattern;

import java.util.ArrayList;

/**
 * 组合模式的扩展——透明模式（透明的组合模式）
 * 把用来组合使用的方法放到抽象类中，比如add()、remove()、getChildren()等方法，
 * 不管是叶子对象还是树枝对象都有相同的结构，通过判断是getChildren()的返回值确认是叶子结点还是树枝结点，
 * 如果处理不当，这个会在运行期出现问题，不建议使用。
 */

//抽象构件
abstract class Component1{
    //个体和整体都具有的共享
    public void doSomething(){
        //业务逻辑
    }
    //增加一个叶子构件或者树枝构件
    public abstract void add1(Component1 component1);
    //删除一个叶子构件或者树枝构件
    public abstract void remove(Component1 component1);
    //获得分支下所有叶子构件和树枝构件
    public abstract ArrayList<Component1> getChildren();
}

//叶子结点
class Leaf2 extends Component1{

    @Deprecated
    public void add1(Component1 component1) throws UnsupportedOperationException {
        //空实现，直接抛一个“不支持请求”异常
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Component1 component1) throws UnsupportedOperationException{
        //空实现
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public ArrayList<Component1> getChildren() throws UnsupportedOperationException{
        //空实现
        throw new UnsupportedOperationException();
    }
}

//场景类
public class CompositePattern1 {
    public static void main(String[] args){

    }

    //通过递归遍历树
    public static void display(Component1 root){
        for (Component1 c : root.getChildren()){
            if (c instanceof Leaf2){    //树枝结点
                c.doSomething();
            }else {     //树叶结点
                display(c);
            }
        }
    }
}

