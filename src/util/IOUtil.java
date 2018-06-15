package util;

import java.io.*;
import java.util.List;


public class IOUtil {
    /**
     * 把list写入文件
     *      新建字符输出流pw
     *      遍历list,逐行输出
     * @param list
     * @param file
     */
    public static void saveList(List list, File file) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (Object o : list) {
                pw.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static void readFromFile(File file) throws IOException {
        BufferedReader br=null;
        String in=null;
        try {
            br=new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)));
            while((in=br.readLine())!=null) {
                System.out.println(in);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if (br!= null) {
                br.close();
            }
        }
    }

    public static void writeToFile(List<String> list,
                   File file)throws IOException{
        PrintWriter pw=null;
        try{
            pw=new PrintWriter(file);
            for (String s:list){
                pw.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (pw!=null){
                pw.close();
            }
        }
    }
}
