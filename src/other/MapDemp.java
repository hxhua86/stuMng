package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统计单词出现的次数
 * 分拣模式
 *      1、第一次，为每一个对象创建容器
 *         容器中放入对象
 *         遍历容器，取出对象
 *      2、第一次，为对象创建容器，把对象放入容器
 *         遍历，把所有对象放入容器
 *         遍历容器，取出对象
 *
 * @author hxhua
 * @create：2018 06 11 14:27
 */

public class MapDemp {
    static String str1="this is a book, " +
            "and that is an apple, " +
            "here is your apple";
    static String str=str1.replaceAll(",", " ");
    static String[] strArray=str.split(" +");

    public static void main(String[] args) {
        //put01();
        //put02();
        System.out.println(str);
        put03();
    }
    public static void put01(){

        //使用自定义类型Lett
        Map<String, Lett> letts=new HashMap<>();
        Lett col;
        for(String temp:strArray){
            if (!letts.containsKey(temp)){//单纯建容器
                letts.put(temp,new Lett());
            }
            col=letts.get(temp);   //新建对象col，接收value值
            col.setCount(col.getCount()+1); //col.count：单词出现的次数
        }

        Set<String> keys=letts.keySet();
        for (String key:keys){//遍历key,获取value
            col=letts.get(key);    //接收每一个key对应的value
            System.out.println("单词："+key+"  次数："+col.getCount());
        }
    }
    public static void put02(){
        Lett col;
        Map<String, Lett> letts=new HashMap<>();
        for(String temp:strArray){

            if (!letts.containsKey(temp)){//建容器的同时加入元素
                col=new Lett();
                col.setCount(1);
                letts.put(temp,col);
            }else{
                col=letts.get(temp);   //新建对象col，接收value值
                col.setCount(col.getCount()+1); //col.count：单词出现的次数
            }
        }
        Set<String> keys=letts.keySet();
        for (String key:keys){
            col=letts.get(key);    //接收每一个key对应的value
            System.out.println("单词："+key+"  次数："+col.getCount());
        }
    }
    public static void put03(){
        Lett col;//
        Map<String, Lett> letts=new HashMap<>();
        for(String temp:strArray){
            if (null==(col=letts.get(temp))){
                col=new Lett();
                col.setCount(1);
                letts.put(temp,col);//建容器同时加入元素
            }else{
                col.setCount(col.getCount()+1); //col.count：单词出现的次数
            }
        }
        Set<String> keys=letts.keySet();
        for (String key:keys){
            col=letts.get(key);    //接收每一个key对应的value
            System.out.println("单词："+key+"  次数："+col.getCount());
        }
    }
}
class Lett {
    private int count;

    public Lett(int count){
        this.count=count;
    }
    public Lett() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
