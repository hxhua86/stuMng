package one;
import java.util.*;

/**
 * ----访问权限
 * 2.1 查看可选课程
 * 2.2 添加选课
 * 2.3 删除选课
 * 2.4 查询已选课程
 */


public class Student {
    private String sName;
    private String gender;
    private int age;
    private int no;//学生临时编号,用于产生Id
    private int sId;
    private String pwd;

    static String key;//String:sId+pwd
    private static int Base;
    static List<Student> stuList;

    static Map<String,List> stuMap;
    private Set<String> keySet;

    {
        stuMap=new HashMap<>();
        keySet=stuMap.keySet();
        stuList=new ArrayList<Student>();
        Base=2018000;
    }

    public Student(String sName, String gender, int age) {
        this.sName = sName;
        this.gender = gender;
        this.age = age;
    }
    public Student(String sName, String gender,int age,int no) {
        this(sName,gender,age);
        this.sId=Base+no;
    }

    public int getSId(){
        return sId;
    }
    public static void addToKeySet(Student s){
        String str=s.getSId()+"|"+s.getPwd();
    }
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
	public void addStuTOList(List<Student> list,Student student){
       list.add(new Student(sName,gender,age));
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
}

