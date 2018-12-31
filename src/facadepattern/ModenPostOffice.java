package facadepattern;

/**
 * 现代化邮局
 */
public class ModenPostOffice {
    private ILetterProcess letterProcess = new LetterProcessImpl();
    private Police letterPolice = new Police();
    //写信，封装，投递一体化
    public void sendLetter(String context,String address){
        //帮你写信
        letterProcess.writeContext(context);
        //写好信封
        letterProcess.fillEnvelope(address);
        //检查信件
        letterPolice.checkLetter(letterProcess);
        //把信放到信封中
        letterProcess.letterIntoEnvelope();
        //邮寄信件
        letterProcess.sendLetter();
    }
}
