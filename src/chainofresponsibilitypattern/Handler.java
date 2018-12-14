package chainofresponsibilitypattern;

/**
 * 有处理权的人员（父亲、丈夫或儿子）接口
 */
public abstract class Handler {
    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEV_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;
    //能处理的级别
    private  int level = 0;
    //责任传递，下一个责任人是谁
    private Handler nextHandler;
    //每个类都要说明一下自己能处理哪些请求
    public Handler(int _level){
        this.level = _level;
    }
    //一个古代女性要求逛街，有处理权的人要处理这个请求
    public void HandleMessage(IWomen women){
        if (women.getType() == this.level){
            this.response(women);
        }else {
            if (this.nextHandler != null){
                this.nextHandler.HandleMessage(women);
            }else {
                System.out.println("——没地方请示，按不同意处理——");
            }
        }
    }
    //如果是不属于你的请求，你应该让她找下一个环节的人
    public void serNext(Handler _handler){
        this.nextHandler = _handler;
    }
    //有请示就得有回复
    protected abstract void response(IWomen women);
}
