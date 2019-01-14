package statepattern;

/**
 * 场景类
 */
public class Cilent {
    public static void main(String[] args){
        ILift lift = new Lift();
        //电梯的初始状态应该是停止状态
        lift.setState(ILift.STOPPING_STATE);
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
