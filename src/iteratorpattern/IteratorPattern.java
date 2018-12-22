package iteratorpattern;

import javax.jws.Oneway;
import java.util.Vector;

/**
 * 迭代器模式：
 * 定义：提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
 *
 * 迭代器模式的三个角色：
 * 1、Iterator抽象迭代器：负责定义访问和遍历元素的接口，而且基本上是由3个固定方法：
 * first()获得第一个元素、next()访问下一个元素、hasNext()是否已经访问到了底部；
 * 2、ConcreteIterator具体迭代器：实现迭代器接口，完成容器元素的遍历；
 * 3、Aggregate抽象角色：负责提供具体迭代器角色的接口；
 * 4、ConcreteAggregate具体容器：实现容器接口定义的方法，创建出容纳迭代器的对象。
 *
 * Java开发一般不写迭代器模式（有现成的迭代器用为啥要这么麻烦用迭代器模式）
 */

//抽象迭代器
interface Iterator{
    //遍历到下一个元素
    public Object next();
    //是否已经遍历到尾部
    public boolean hasNext();
    //删除当前指向的元素
    public boolean remove();
}

//具体迭代器
class ConcreteIterator implements Iterator{
    private Vector vector = new Vector();
    //定义当前游标
    public int cursor = 0;
    @SuppressWarnings("unchecked")
    public ConcreteIterator(Vector _vector){

        this.vector = _vector;
    }
    //返回下一个元素
    @Override
    public Object next() {
        Object result = null;
        if (this.hasNext()){
            result = this.vector.get(this.cursor++);
        }else {
            result = null;
        }
        return result;
    }
    //判断是否到达尾部
    @Override
    public boolean hasNext() {
        if (this.cursor == this.vector.size()){
            return false;
        }else {
            return true;
        }
    }
    //删除当前元素
    @Override
    public boolean remove() {
        this.vector.remove(this.cursor);
        return true;
    }
}

//抽象容器
interface Aggregate{
    //容器必然有元素的增加
    public void add(Object object);
    //减少元素
    public void remove(Object object);
    //由迭代器来遍历所有元素
    public Iterator iterator();
}

//具体容器
class ConcreteAggregate implements Aggregate{
    //容纳对象的容器
    private Vector vector = new Vector();
    //增加一个元素
    @Override
    public void add(Object object) {

        this.vector.add(object);
    }

    @Override
    public void remove(Object object) {

        this.remove(object);
    }
    //返回迭代器对象
    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }
}

//场景类
public class IteratorPattern {
    public static void main(String[] args){
        //声明出容器
        Aggregate agg = new ConcreteAggregate();
        //产生对象数据放进去
        agg.add("abc");
        agg.add("aaa");
        agg.add("1234");
        //遍历
        Iterator iterator = agg.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }
    }
}
