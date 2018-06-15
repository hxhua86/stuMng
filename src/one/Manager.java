package one;

/**
 * 教学管理人员——可操作全部
 *  1	学生管理
 *  2	课程管理
 *  3	成绩管理
 *  0	保存并关闭
 * @author hxhua
 * @create：2018 06 08 8:19
 */

public class Manager {
    private String mName;
    private String mPwd="123";
    private String logIn;

public Manager(String mName, String mPwd) {
    this.mName = mName;
    this.mPwd = mPwd;
    logIn=mName+"|"+mPwd;
}

public void log(){
    

    }
}
