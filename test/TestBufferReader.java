package cn.io.com;
import java.io.*;
public class TestBufferReader {
    public static void main(String[] args) {
        //字符缓冲输入流
        File file = new File("abc.txt");
        try(BufferedReader  reader =
                    new BufferedReader(new FileReader(file))) {
            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        //字符缓冲输出流
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.append("为了有更好的明天，我们现在需要一起努力！！");
            bw.newLine();
            bw.append("明天的你会为今天努力的你而感到骄傲自豪");
            bw.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
