package chainofresponsibilitypattern;
/**
 * 以古代女性的三从为例
 */

/**
 * 女性接口
 */
public interface IWomen {
    //获得个人状况，是否结婚，丈夫是否在世，是否有儿子等
    public int getType();
    //获得个人请示，要做什么事
    public String getRequest();
}
