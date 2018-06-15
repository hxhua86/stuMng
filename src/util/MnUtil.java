package util;

import one.Student;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 读写工具类——读取各种类型的数据
 *    为了重用
 *
 * @author hxhua
 * @create：2018 06 08 18:38
 */

public class MnUtil {
    static Scanner sc=new Scanner(System.in);
//    public static void fstMenu(int in){
//        while(true){
//            in=Integer.parseInt(sc.nextLine());
//            if(!(in==1||in==2
//                    ||in==3||in==0)){
//                System.out.println("您的输入有误，请重试！");
//            }else break;
//        }
//    }

    public static void firstIn(){
        Scanner sc=new Scanner(System.in);
        System.out.println("欢迎进入StuManagementSys，请输入你要进行的操作：");
        System.out.println("操作代码如下：");
        System.out.println("1：学生管理；2：课程管理；3：成绩管理；0：退出");
    }
    public static void stuMng(){
        System.out.println(
                "1：添加学生；" + "2：删除学生；"
                 + "3：显示学生列表；" + "0：返回上一级");
    }
    public static void showStu(){
        System.out.println(
                 "1：修改学生信息；" +
                 "2：根据条件查询学生；" +
                 "0：返回上一级");
    }
    public static void sbjChois(){
        //System.out.println("请输入：学生编号、密码");

        System.out.println(
                "1：查看可选课程；" +
                "2：添加选课；" +
                "3：删除选课；" +
                "0：返回上一级");
    }

    public static void scoreMng() {
        System.out.println(
                "1：添加成绩；" +
                "2：修改成绩；" +
                "0：返回上一级");
    }
    public static boolean StuInfoJudg(String name,String key,Set<String> keySet){
        Scanner sc=new Scanner(System.in);
        while(true){
            String str=sc.nextLine();
            for (String s:keySet){
                if (str.equals(s)){
                    System.out.println("输入正确");
                    return true;
                }else{
                    System.out.println("没有这个学生,请重试");
                }
            }
        }
    }

}
