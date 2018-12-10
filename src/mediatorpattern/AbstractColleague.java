package mediatorpattern;

/**
 * 抽象同事类
 */
public abstract class AbstractColleague {
    protected AbstractMediator mediator;
    public AbstractColleague(AbstractMediator _mediator){

        this.mediator = _mediator;
    }
}
