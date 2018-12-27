package compositepattern;

import java.util.ArrayList;

/**
 * 组合模式：也叫合成模式或部分-整体模式；树状结构的构建和遍历
 * 定义：将对象组合成树形结构以表示部分-整体的层次结构，
 * 使得用户对单个对象和组合对象的使用具有一致性。
 *
 * 组合模式的三个角色：
 * 1、Component抽象构件角色：定义参加组合对象的共有方法和属性，
 * 可以定义一些默认的行为或属性，比如上面例子中getInfo就封装在抽象类中
 * （抽象构建是组合模式的精髓所在）；
 * 2、Leaf叶子构件：叶子对象，其下再也没有其他的分支，也就是遍历的最小单位；
 * 3、Composite树枝构件：树枝对象，作用是组合树枝节点和叶子结点形成一个树形结构。
 *
 * 组合模式的优点：
 * 高层模块调用简单；结点自由增加。
 *
 * 组合模式的缺点：树叶和树枝使用时直接使用了实现类。
 *
 * 组合模式的使用场景：
 * 1、维护和展示部分-整体关系的场景，如树形菜单、文件和文件夹管理；
 * 2、从一个整体中能够独立出部分模块或功能的场景。
 *
 * 下面展示通用源码：
 */

//抽象构件
abstract class Component{
    //个体和整体都有的
    public void doSomething(){
        //逻辑
        System.out.println("...");
    }
}

//树枝构件
class Composite extends Component{
    //构件容器
    private ArrayList<Component> componentArrayList = new ArrayList<>();
    //增加一个叶子构件或者树枝构件
    public void add(Component component){
        this.componentArrayList.add(component);
    }
    //删除一个叶子构件或者树枝构件
    public void remove(Component component){
        this.componentArrayList.remove(component);
    }
    //获得分支下所有叶子构件和树枝构件

    public ArrayList<Component> getChildren() {
        return this.componentArrayList;
    }
}

//树叶构件
class Leaf1 extends Component{
    //可以复写父类方法
    @Override
    public void doSomething(){
        System.out.println("......");
    }
}

//场景类
public class CompositePattern {
    public static void main(String[] args){
        //创建一个根结点
        Composite root = new Composite();
        root.doSomething();
        //创建一个树枝构件
        Composite branch = new Composite();
        //创建一个叶子结点
        Leaf1 leaf = new Leaf1();
        //建立整体
        root.add(branch);
        branch.add(leaf);
    }

    //通过递归遍历树
    public static void display(Composite root){
        for (Component c:root.getChildren()){
            if (c instanceof Leaf1){
                c.doSomething();
            }else {
                display((Composite)c);
            }
        }
    }
}
