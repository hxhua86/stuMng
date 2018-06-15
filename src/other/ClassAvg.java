package other;

import java.util.*;

/**
 * 计算班级的平均分
 *     用到分拣模式
 *
 * @author hxhua
 * @create：2018 06 11 15:34
 */

public class ClassAvg {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        exam(list);

        Map<String,ClassRoom> rooms=new HashMap<>();
        count(rooms,list);
        printScore(rooms);
    }
    public static void count(Map<String,ClassRoom> rooms, List<Student> list){
        for (Student stu:list){//遍历list,将其中的学生归入班级
            String no=stu.getClassId();
            int score=stu.getScore();
            ClassRoom room=rooms.get(no);
            if (null==room){//分拣模式
                room=new ClassRoom();
                rooms.put(no,room);
            }else {
                //存储
                room.setTotal(room.getTotal() + score);
                room.getStus().add(stu);
            }
        }
    }
    public static void printScore(Map<String,ClassRoom> rooms){
        Set<Map.Entry<String,ClassRoom>> entrySet = rooms.entrySet();
        Iterator<Map.Entry<String,ClassRoom>> it=entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<String,ClassRoom> entry=it.next();
            ClassRoom room = entry.getValue();
            double avg = room.getTotal()/room.getStus().size();
            System.out.println("班号为:"+room.getNo()+
                    "总分为:"+room.getTotal()+"平均分为:"+avg);
        }
    }
    public static void exam(List<Student> list) {//向list中加入元素:student
        list.add(new Student("S",80 ,"01" ));
        list.add(new Student("M",90 ,"01" ));
        list.add(new Student("N",20 ,"02" ));
        list.add(new Student("P",70 ,"02" ));
        list.add(new Student("W",65 ,"03" ));
        list.add(new Student("T",80 ,"03" ));
    }

}
class Student{
    private String name;
    private int score;
    private String classId;

    public Student(){}

    public Student(String name, int score, String classId) {
        super();
        this.name = name;
        this.score = score;
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", classId='" + classId + '\'' +
                '}';
    }
}
class ClassRoom{//BO类
    private String no;
    private List<Student> stus;
    private double total;
    ClassRoom(){
        stus=new ArrayList<Student>();//为每个班建立一个容器,避免空指针
    }
    public ClassRoom(String no) {
        this();
        this.no = no;
    }
    @Override
    public String toString() {
        return "ClassRoom{" +
                "no='" + no + '\'' +
                ", stus=" + stus +
                ", total=" + total +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
