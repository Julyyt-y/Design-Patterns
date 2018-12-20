package adapterpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 适配器模式的扩展：
 *
 * 如上例子，如果用户的基本信息、工作信息、家庭信息分别是一个接口，
 * 此时只能使用类关联的方法（因为Java不支持多继承），
 * 声明一个OuterUserInfo实现类，实现IUserInfo接口，再关联其它三个类就可以解决。
 * 下面代码中OuterUserInfo变成了委托服务，把IUserInfo接口需要的所有操作都委托给其他接口下的实现类，
 * 它的委托是通过对象层次的关联关系进行委托的，而非继承。
 */

//用户基本信息接口
interface IOuterUserBaseInfo {
    //基本信息，如姓名性别手机号码
    public Map getUserBaseInfo();
}

//用户家庭信息接口
interface IOuterUserHomeInfo {
    //用户的家庭信息
    public Map getUserHomeInfo();
}

//用户的工作信息接口
interface IOuterUserOfficeInfo {
    //工作信息
    public Map getUserOfficeInfo();
}

//用户基本信息
class OuterUserBaseInfo implements IOuterUserBaseInfo {
    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("userName","这个员工叫AAA");
        baseInfoMap.put("mobileNumber","这个员工AAA的电话是12345678910");
        return baseInfoMap;
    }
}

//用户家庭信息
class OuterUserHomeInfo implements IOuterUserHomeInfo {
    @Override
    public Map getUserHomeInfo() {
        HashMap homeInfo = new HashMap();
        homeInfo.put("homeTelNumber","员工的家庭电话是：11111111");
        homeInfo.put("homeAddress","员工的家庭住址是...");
        return homeInfo;
    }
}

//用户工作信息
class OuterUserOfficeInfo implements IOuterUserOfficeInfo {

    @Override
    public Map getUserOfficeInfo() {
        HashMap officeInfo = new HashMap();
        officeInfo.put("jobPosition","这个人的职位是：...");
        officeInfo.put("officeTelNumber","这个人的办公室电话是：...");
        return officeInfo;
    }
}

//适配器
class OuterUserInfo1 implements IUserInfo {

    //源目标对象
    private IOuterUserBaseInfo baseInfo = null;
    private IOuterUserHomeInfo homeInfo = null;
    private IOuterUserOfficeInfo officeInfo = null;

    //数据处理
    private Map baseMap = null;
    private Map homeMap = null;
    private Map officeMap = null;

    //构造函数传递对象
    public OuterUserInfo1(IOuterUserBaseInfo _baseInfo,IOuterUserHomeInfo _homeInfo,IOuterUserOfficeInfo _officeInfo) {
        this.baseInfo = _baseInfo;
        this.homeInfo = _homeInfo;
        this.officeInfo = _officeInfo;
        //数据处理
        this.baseMap = this.baseInfo.getUserBaseInfo();
        this.homeMap = this.homeInfo.getUserHomeInfo();
        this.officeMap = this.officeInfo.getUserOfficeInfo();
    }

    @Override
    public String getUserName() {
        String userName = (String)this.baseMap.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String)this.homeMap.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        String mobileNumber = (String)this.baseMap.get("mobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = (String)this.officeMap.get("officeTelNumber");
        System.out.println(officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPosition() {
        String jobPosition = (String)this.officeMap.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String)this.homeMap.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
}

//场景类
public class AdapterPatternExtension {
    public static void main(String[] args){
        //外系统的人员信息
        IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
        IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
        IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
        //传递三个对象
        IUserInfo young = new OuterUserInfo1(baseInfo,homeInfo,officeInfo);
        //从数据库查到101个
        for (int i=0;i<101;i++){
            young.getMobileNumber();
        }
    }
}
