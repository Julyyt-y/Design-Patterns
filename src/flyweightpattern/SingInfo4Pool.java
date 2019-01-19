package flyweightpattern;

/**
 * 带对象池的报考信息
 */
public class SingInfo4Pool extends SingInfo {
    //定义一个对象池提取的KEY值
    private String key;
    //构造函数获得相同标志
    public SingInfo4Pool(String _key){
        this.key = _key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
