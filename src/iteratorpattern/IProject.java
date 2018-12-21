package iteratorpattern;

/**
 * 项目信息接口
 */
public interface IProject {
    //增加项目
    public void add(String name,int num,int cost);
    //获取项目信息
    public String getProjectInfo();
    //获得一个可以遍历的对象
    public IProjectIterator iterator();
}
