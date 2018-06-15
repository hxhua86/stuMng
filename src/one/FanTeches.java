package one;


/**
 * 演示自定义异常
 *  -----描述: 范老师用电脑上课
 *     1 teacher类
 *     2 computer类
 * @author hxhua
 * @create：2018 06 13 9:55
 */
class Master{
    private String name;
    private Computer comp;
    Master(){
    }
    Master(String name){
        this.name=name;
        comp=new Computer();
    }
    public void teach()throws teachRuinException{
        try {
            comp.run();
        } catch (BlueExecption b) {
            comp.reset();

        } catch (BurnException e) {
            throw new teachRuinException("教学受影响") ;
        }
        System.out.println("fan teaching");
    }
    public void test(){
        System.out.println("做练习");
    }
}
class Computer{
    String brand;
    static private int state =3;//1:正常;2:蓝屏;3:冒烟
    static void run()throws BlueExecption,BurnException{
        if (state==2)
            throw new BlueExecption("蓝屏");
        if (state==3)
            throw new BurnException("冒烟");
        System.out.println("computer running");
    }
    static void reset(){
        state=1;
        System.out.println("重启");
    }
}
class BlueExecption extends Exception{
    BlueExecption(){}
    BlueExecption(String msg){
        super(msg);
    }
}
class BurnException extends Exception{
    BurnException(){}
    BurnException(String msg){
        super(msg);
    }
}
class teachRuinException extends Exception{
    teachRuinException(String msg){
        super(msg);
    }
}

public class FanTeches {
    public static void main(String[] args)  {
        Master m=new Master("毕老师");
        try {
            m.teach();
        } catch (teachRuinException e) {
            System.out.println("换老师,或者换电脑: "+e.getMessage());
            m.test();

        }
    }
}
