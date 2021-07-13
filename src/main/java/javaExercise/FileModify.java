package javaExercise;

import  java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class FileModify {
    private String filename;
    private String target;
    private String newContent;

    public FileModify(String filename, String target, String newContent) {
        this.filename = filename;
        this.newContent =newContent;
        this.target = target;
        /**
         * 替换文件中某个字符串并写入新内容
         */
        try {
            File file = new File(filename);
            InputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            File tmpfile = new File(file.getParentFile().getAbsolutePath()
                    + "/" + "taret.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
            String str = null;
            while (true){
                str = reader.readLine();
                if(str == null){
                    break;
                }
                if(str.contains(target)){
                    String str1 = str.replace(target,newContent);
                    writer.write(str1);
                }
                else{
                    writer.write(str+"\n");
                }
            }
            is.close();
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public FileModify(String filename,String newFuhao){
        /**
         * 字符串中的一个或多个空格替换成逗号
         */
        this.filename = filename;
        try {
            File file = new File(filename);
            InputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            File tmpfile = new File(file.getParentFile().getAbsolutePath()
                    + "/" + "taret.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
            String str = null;
            while (true){
                str = reader.readLine();
                if(str == null){
                    break;
                }
                if(str.contains(" ")){
                    String regEx = "[' ']+"; // 一个或多个空格

                    Pattern p = Pattern.compile(regEx);

                    Matcher m = p.matcher(str);
                    String str1 = m.replaceAll(newFuhao).trim();
                    writer.write(str1);
                }
                else{
                    writer.write(str+"\n");
                }
            }
            is.close();
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public FileModify(String filename){
        /**
         * 将换行改为逗号
         */
        this.filename = filename;

        try {
            File file = new File(filename);
            InputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            File tmpfile = new File(file.getParentFile().getAbsolutePath()
                    + "/" + "taret.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
            String str = null;
            while (true){
                str = reader.readLine();
                if(str == null){
                    break;
                }
                else{
                    writer.write(str+",");
                }
            }
            is.close();
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }




    public static void main(String[] args) {
        File directory = new File("");
        String path =directory.getAbsolutePath();//获取项目绝对路径
        String  filename= path+"/src/main/源目录/1.txt";
        String target = "\n";
        String newContent = ",";
        String newFuhao = ",";
        FileModify fm =new FileModify(filename);

    }

}
