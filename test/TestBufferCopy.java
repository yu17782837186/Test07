package cn.io.com;
import java.io.*;
public class TestBufferCopy {
    public static void main(String[] args) {
        copy("abc.txt","abcCopy.txt");
    }
    public static void copy(String srcPath,String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            writer = new BufferedWriter(new FileWriter(dest));
            String line = null;
            while((line =  reader.readLine()) != null) {
                writer.append(line);
                writer.newLine();
            }
            writer.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
