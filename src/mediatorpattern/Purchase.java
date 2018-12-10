package mediatorpattern;

/**
 * 采购管理
 */
public class Purchase {
    //采购IBM电脑
    public void buyIBMcomputer(int number){
        //访问库存
        Stock stock = new Stock();
        //访问销售
        Sale sale = new Sale();
        //电脑销售情况
        int saleStatue = sale.getSaleStstue();
        //如果销售情况良好
        if (saleStatue > 80){
            System.out.println("采购IBM电脑：" + number + "台。");
            stock.increase(number);
        }else {
            //否则的话折半采购
            int buyNumber = number / 2;
            System.out.println("采购IBM电脑：" + buyNumber + "台。");
        }
    }
    //不再采购IBM电脑
    public void refuseBuyIBM(){
        System.out.println("不再采购IBM电脑。");
    }
}
