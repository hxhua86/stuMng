package one;

import util.IOUtil;
import util.MnUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 主类
 *  * 1.1 添加学生
 *          添加/修改学生信息的格式:
 *              id自动生成，且不允许修改，没有设置的不做修改
 *              添加学生的时候默认密码 123
 *  * 1.2 删除学生
 *  * 1.3 学生列表
 *  *       1.3.1  修改学生信息
 *  *       1.3.2  根据条件查询学生
 *              根据条件查询需要支持的操作:
 *                  id=123
 *                  Id>5&gender=f&order=age类似的操作
 *                  只支持大于，小于，等于三种，逻辑只支持&
 *
 *  *  2.1 查看可选课程
 *  *  2.2 添加选课
 *  *  2.3 删除选课
 *  *  2.4 查询已选课程 *  *
 *  *
 *  *  3.1  添加成绩
 *  *  3.2 修改成绩
 *
 *  * 进入每一层之后，按0可以返回上一层
 *  * 首层目录中，进入课程管理时，需要输入学生的编号和密码
 * @author hxhua
 * @create：2018 06 07 22:14
 */

public class StuManageMent {
    private static File stuInfoFile;
    private static File subjectInfoFile;
    private static File stuListFile;
    private static File stuMapFile;
    private static File techerListFile;
    private static File mngListFile;
    private static File scoreListFile;

    {
        stuInfoFile=new File("stu.txt");
        subjectInfoFile=new File("subj.txt");
        stuListFile=new File("stuList.txt");
        stuMapFile=new File("stuAll");
        techerListFile=new File("tech.txt");
        mngListFile=new File("mng.txt");
        scoreListFile=new File("score.tx");
    }

    public static Scanner sc = new Scanner(System.in);

    public static void start(){
    MnUtil.firstIn();
    int in;
    
    while(true){
        in=Integer.parseInt(sc.nextLine());
        if(!(in==1||in==2
                ||in==3||in==0)){
            System.out.println("您的输入有误，请重试！");
        }else break;
    }
    
    System.out.println("您的输入是："+in);
    outer:
    switch(in){
        case 1://学生管理
            MnUtil.stuMng();
            in=Integer.parseInt(sc.nextLine());
            inner:
            switch (in){
                case 1://添加学生
                    System.out.println("添加学生");
                    
                    break;
                case 2://删除学生
                    
                    break;
                case 3://学生列表
                    MnUtil.showStu();
                    in=Integer.parseInt(sc.nextLine());
                    switch (in){
                        case 1://修改学生信息
                            
                            break;
                        /*
                         * 查询支持的操作:
                         *    id=123
                         *    Id>5&gender=f&order=age类似的操作
                         *    只支持大于，小于，等于三种，逻辑只支持&
                         */
                        case 2://根据条件查询学生
                            
                            break;
                        case 0://返回上一级
                            break inner;
                    }
                case 0://返回
                    break outer;
            }
        case 2://课程管理：需要输入学生的编号和密码
            System.out.println("请输入：学生编号|密码");
            //等建立起文件后判断
            MnUtil.sbjChois();
            in=Integer.parseInt(sc.nextLine());
            switch (in){
                case 1://查看可选课程
                    try {
                        IOUtil.readFromFile(subjectInfoFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2://添加选课
                    
                    break;
                case 3://删除选课
                    
                    break;
                case 4://查询已选课程
                    try {
                        IOUtil.readFromFile(subjectInfoFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0://返回上一级
                    break outer;
            }
        case 3://成绩管理
            MnUtil.scoreMng();
            in=Integer.parseInt(sc.nextLine());
            switch (in){
                case 1://添加成绩
                    break;
                case 2://修改成绩
                    break;
                case 0:
                    break outer;
            }
        case 0://保存并关闭
            return;
        
    }
}
    public static void main(String[] args)throws IOException {
        //start();


        //s.addStuTOList(stuList,s);
        Teacher.addTeacher("T张三","st3012");
        Teacher.addTeacher("T李四","gd3012");
        Teacher.addTeacher("T王五","zj3012");
        System.out.println("add success");
        try{
            IOUtil.writeToFile(Teacher.teacherList, techerListFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        


    }

}
