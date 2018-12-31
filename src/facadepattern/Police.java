package facadepattern;

/**
 * 信件检查类
 */
public class Police {
    //检查信件，检查完毕后在信封上盖个戳
    public void checkLetter(ILetterProcess letterProcess){
        System.out.println(letterProcess + "信件已检查过。");
    }
}
