package adapterpattern;

import java.util.HashMap;
import java.util.Map;

public class OuterUser implements IOuterUser{
    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("userName","这个员工叫AAA");
        baseInfoMap.put("mobileNumber","这个员工AAA的电话是12345678910");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap officeInfo = new HashMap();
        officeInfo.put("jobPosition","这个人的职位是：...");
        officeInfo.put("officeTelNumber","这个人的办公室电话是：...");
        return officeInfo;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap homeInfo = new HashMap();
        homeInfo.put("homeTelNumber","员工的家庭电话是：11111111");
        homeInfo.put("homeAddress","员工的家庭住址是...");
        return homeInfo;
    }
}
