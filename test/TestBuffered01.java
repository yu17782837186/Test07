package cn.io.com;
import java.io.*;
public class TestBuffered01 {
    public static void main(String[] args) {
        //字节缓冲输入流
        File file = new File("abc.txt");
        try(InputStream is =
                    new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = new byte[1024];
            int tmp;
            while((tmp = is.read(bytes)) != -1) {
                String str = new String(bytes,0,tmp);
                System.out.println(str);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        //字节缓冲输出流
        try(OutputStream os =
                    new BufferedOutputStream(new FileOutputStream(file))) {
            byte[] flush = new byte[1024];
            String str = "i love you very much";
            byte[] flag = str.getBytes();
            os.write(flag,0,flag.length);
            os.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
