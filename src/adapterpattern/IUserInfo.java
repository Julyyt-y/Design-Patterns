package adapterpattern;

/**
 * 员工信息接口
 */
public interface IUserInfo {
    //获得用户姓名
    public String getUserName();
    //获得家庭地址
    public String getHomeAddress();
    //获取手机号码
    public String getMobileNumber();
    //获取办公室电话
    public String getOfficeTelNumber();
    //获取职位
    public String getJobPosition();
    //获取家庭电话
    public String getHomeTelNumber();
}
