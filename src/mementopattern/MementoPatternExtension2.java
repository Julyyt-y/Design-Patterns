package mementopattern;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 备忘录模式的扩展（2）——多状态的备忘录模式
 * 多个对象的备忘录
 */

//发起人角色
class Originator2 {
    private Originator1 backup;
    //内部状态
    private String state1 = "";
    private String state2 = "";
    private String state3 = "";

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public void setState3(String state3) {
        this.state3 = state3;
    }

    public String getState3() {
        return state3;
    }

    //创建一个备忘录
    public Memento2 createMemento() {
        return new Memento2(BeanUtils.backupProp(this));
    }
    //恢复一个备忘录
    public void restoreMemento (Memento2 _memento2) {
        BeanUtils.restoreProp(this,_memento2.getStateMap());
    }
    //增加一个toString方法，目的是方便打印
    @Override
    public String toString(){
        return "state1 = " +state1 + "\nstate2 = " + state2 + "\nstate3 = " + state3;
    }

}

//BeanUtils工具类
class BeanUtils {
    //把bean所有的属性及数值放入HashMap中
    public static HashMap<String,Object> backupProp(Object bean){
        HashMap<String,Object> result = new HashMap<>();
        try {
            //获得Bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获得属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            //遍历所有属性
            for (PropertyDescriptor des : descriptors){
                //属性名称
                String fieldName = des.getName();
                //读取属性方法
                Method getter = des.getReadMethod();
                //读取属性值
                Object fieldValue = getter.invoke(bean,new Object[]{});
                if (!fieldName.equalsIgnoreCase("class")){
                    result.put(fieldName,fieldValue);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //把HashMap的值返回到bean中
    public static void restoreProp(Object bean,HashMap<String,Object> propMap){
        try {
            //获得Bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获得属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            //遍历所有属性
            for (PropertyDescriptor des : descriptors){
                //属性名称
                String fieldName = des.getName();
                //如果有这个属性
                if (propMap.containsKey(fieldName)){
                    //写属性的方法
                    Method setter = des.getWriteMethod();
                    setter.invoke(bean,new Object[]{propMap.get(fieldName)});
                }
            }
        }catch (Exception e){
            System.out.println("。。。");
            e.printStackTrace();
        }
    }
}

//备忘录角色
class Memento2{
    //接受HashMap作为状态
    private HashMap<String,Object> stateMap;
    //接受一个对象，建立一个备份
    public Memento2(HashMap<String,Object> map){
        this.stateMap = map;
    }

    public HashMap<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(HashMap<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}

//备忘录管理者
class Caretaker2 {
    //备忘录对象
    private Memento2 memento;

    public Memento2 getMemento() {
        return memento;
    }

    public void setMemento(Memento2 memento) {
        this.memento = memento;
    }
}

//场景类
public class MementoPatternExtension2 {
    public static void main(String[] args){
        //定义出发起人
        Originator2 ori = new Originator2();
        //定义出备忘录管理员类
        Caretaker2 caretaker = new Caretaker2();
        //初始化
        ori.setState1("中国");
        ori.setState2("强盛");
        ori.setState3("繁荣");
        System.out.println("=====初始化状态=====\n" + ori);
        //创建一个备忘录
        caretaker.setMemento(ori.createMemento());
        //修改状态值
        ori.setState1("111");
        ori.setState2("222");
        ori.setState3("333");
        System.out.println("\n=====修改后状态=====\n" + ori);
        //恢复一个备忘录
        ori.restoreMemento(caretaker.getMemento());
        System.out.println("\n=====恢复后状态=====\n" + ori);
    }
}
