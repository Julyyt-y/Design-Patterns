package factorymethodpattern;

/**
 * 抽象类制造货物的工厂：
 * 这个工厂是生产的管理者；
 * 作为生产的管理者，只需要知道生产的是什么即可，不需要知道所生产的东西的具体信息；
 * 所以此处定义一个泛型方法用于生产产品。
 *
 * 这里通过泛型对createGoods的输入参数产生两层限制：
 * 必须是Class类型；
 * 必须是Goods的实现类。
 * 其中？表示的是，只要实现了Goods接口的类都可以作为参数。
 */
//抽象类制造货物的工厂，这个工厂是生产的管理者；
//作为生产的管理者，只需要知道生产的是什么即可；
//不需要知道所生产的东西的具体信息
//所以此处定义一个泛型方法用于生产产品
public abstract class Factory {
    public abstract <T extends Goods> T createGoods(Class<T> c);
}
