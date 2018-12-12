package commandpattern;

/**
 * 三个组的共同负责人
 */
public class Invoker {
    private Command command;
    //客户发出的命令
    public void setCommand(Command command){

        this.command = command;
    }
    //执行客户的命令
    public void action(){

        this.command.execute();
    }
}
