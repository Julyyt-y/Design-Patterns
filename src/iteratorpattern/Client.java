package iteratorpattern;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args){
        //定义一个List。存放所有的项目对象
        IProject project = new Project();
        //增加项目
        project.add("星球大战项目",10,10000);
        project.add("扭转时空项目",18,36784);
        project.add("超人改造项目",20,7812949);

        for (int i=4;i<104;i++){
            project.add("第" + i + "个项目",i*5,i*1000);
        }

        //遍历ArrayList把所有数据输出
        IProjectIterator projectIterator = project.iterator();
        while (projectIterator.hasNext()){
            IProject p = (IProject)projectIterator.next();
            System.out.println(p.getProjectInfo());
        }
    }
}
