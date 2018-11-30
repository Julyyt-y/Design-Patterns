package abstractfactorypattern;

/**
 * 以女娲造人为例
 */
//人种接口，每个人都有三种特性：肤色、讲话、性别
public interface Human {
    //每种人都有相应的肤色
    public void getColor();
    //人类都会说话
    public void talk();
    //每个人都有性别
    public void getSex();
}
