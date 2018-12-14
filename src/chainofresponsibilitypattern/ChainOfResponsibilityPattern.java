package chainofresponsibilitypattern;

/**
 * 责任链模式：
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系，
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。
 *
 * 责任链模式的优点：
 * 将请求和处理分开，请求者可以不需要知道是谁处理的，处理者可以不用知道请求的全貌，
 * 两者解耦，提高了系统的灵活性。
 *
 * 责任链模式的缺点：
 * 责任链模式有两个非常显著的缺点：
 * 1、性能问题：每个请求都是从链头遍历到链尾，特别是在链比较长的时候，性能是个很大的问题；
 * 2、调试不方便：特别是在链较长的时候，环节较多的时候，由于采用的类似递归的方式，
 * 调试的时候逻辑可能比较复杂。
 *
 * 责任链模式使用时注意：
 * 链中节点数量要控制，避免出现超长链的情况，一般做法是在Handler中设置一个最大节点数量，
 * 在setNext()方法中判断是否已超过其阈值，超过则不允许建立，不超过则允许建立。
 */

//抽象处理者
abstract class Handler1 {

    protected Handler1 successor;

    public abstract void handleRequest(String condition);

}
//具体处理者
class ConcreteHandler1 extends Handler1 {
    @Override
    public void handleRequest(String condition) {
        if (condition.equals("ConcreteHandler1")) {
            System.out.println("ConcreteHandler1 handled");
        } else {
            successor.handleRequest(condition);
        }
    }
}
//具体处理者
class ConcreteHandler2 extends Handler1 {
    @Override
    public void handleRequest(String condition) {
        if (condition.equals("ConcreteHandler2")) {
            System.out.println("ConcreteHandler2 handled");
        } else {
            successor.handleRequest(condition);
        }
    }
}
//场景类
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler1 handler1 = new ConcreteHandler1();
        Handler1 handler2 = new ConcreteHandler2();

        handler1.successor = handler2;
        handler2.successor = handler1;

        handler1.handleRequest("ConcreteHandler2");
    }
}
