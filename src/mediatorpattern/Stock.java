package mediatorpattern;

/**
 * 库存管理
 */
public class Stock extends AbstractColleague{
    //刚开始有100台电脑
    private static int COMPUTER_NUMBER = 100;

    public Stock(AbstractMediator _mediator) {
        super(_mediator);
    }

    //库存增加
    public void increase(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER + number;
        System.out.println("库存数量为：" + COMPUTER_NUMBER);
    }
    //库存降低
    public void decrease(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER - number;
        System.out.println("库存数量为：" + COMPUTER_NUMBER);
    }
    //获得库存数量
    public int getStockNumber() {
        return COMPUTER_NUMBER;
    }
    //库存太大时，通知采购人员不要采购，先尽快销售
    public void clearStock(){
//        Purchase purchase = new Purchase();
//        Sale sale = new Sale();
//        System.out.println("清理存货数量为：" + COMPUTER_NUMBER);
//        //要求折价销售
//        sale.offSale();
//        //要求采购人员不要采购
//        purchase.refuseBuyIBM();

        System.out.println("清理存货数量为：" + COMPUTER_NUMBER);
        super.mediator.execute("stock.clear");
    }
}
