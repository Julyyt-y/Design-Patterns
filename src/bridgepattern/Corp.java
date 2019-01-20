package bridgepattern;

/**
 * 抽象公司
 */
public abstract class Corp {
    //抽象产品对象
    private Product product;

    //构造函数，由子类定义传递具体的产品进来
    public Corp(Product product){
        this.product = product;
    }

    //赚钱
    public void makeMoney(){
        //先生产
        this.product.beProduct();
        //再销售
        this.product.beSelled();
    }
}
