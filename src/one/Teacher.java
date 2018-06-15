package one;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 教师权限：
 *  3.1  添加成绩
 *  3.2  修改成绩
 *
 *  2.1 查看可选课程
 *  2.2 添加选课
 *  2.3 删除选课
 *  2.4 查询已选课程 *
 *
 * @author hxhua
 * @create：2018 06 08 8:21
 */

    public class Teacher {
        private String tName;//教师名称要求以T开头
        private String tPwd;
        private String logIn;
        static List<String> teacherList;
        private static List<String> scoreList;
        private String sbj1;
        private String sbj2;
        private String sbj3;
        
    {
        teacherList=new ArrayList<>();
        scoreList=new ArrayList<>();
        sbj1="数学";
        sbj2="物理";
        sbj3="体育";
    }
    
    
    private Set<String> subjects;

    public Teacher(String tName, String tPwd) {
        this.tName = tName;
        this.tPwd = tPwd;
        logIn=tName+"|"+tPwd;
    }

    public static void addTeacher(String tName,String tPwd) {
        Teacher t=new Teacher(tName,tPwd );
        teacherList.add(t.logIn);
    }

public static List<String> getTeacherList() {
    return teacherList;
}

public static void setTeacherList(List<String> teacherList) {
    Teacher.teacherList = teacherList;
}
}
