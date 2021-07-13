package fileOperation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

public class  FileRandomAccess {


    public static void invertReadFile(String filename) throws IOException {
        File f = new File(filename);
        RandomAccessFile raf = new RandomAccessFile(f,"r");
        StringBuilder sb = new StringBuilder();
        try{
            int length = (int) raf.length();
//            System.out.println(length);
            while(length>2){
                length--;
                raf.seek(length);
                int c = raf.readByte();
                if(c>=0&c<128){
                    sb.append((char)c+"");
                }else{
                    length--;
                    raf.seek(--length);
                    byte[] cc = new byte[3]; //中文站3个字节
                    raf.readFully(cc);
                    sb.append(new String(cc));
                }
            }
            System.out.println(sb.toString());

        }finally {
            raf.close();

        }

    }

    public static void main(String[] args) throws IOException {
        File directory = new File("");//设定为当前文件夹
        String path =directory.getAbsolutePath();//获取绝对路径
        String filename=path+"/src/main/源目录/1.txt";
        FileRandomAccess.invertReadFile(filename);
    }



}

