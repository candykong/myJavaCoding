package fileOperation;

import java.io.*;
import java.util.Scanner;

public class FileCopy {

    static Scanner sc = new Scanner(System.in);

    //复制文件到另外一个目录：先判断源目录和目标目录是否是同一个文件夹下，再判断源文件是否存在，然后判断目标目录下是否存在同名文件，是的话是否需要覆盖
    public static  void fileCopyUsingFilstream(String sourcePath,String targetPath,String fileName) throws IOException{
        File sourceFile = new File(sourcePath+"/"+fileName);
        File targetFile = new File(targetPath+"/"+fileName);
        InputStream input = null;
        OutputStream output = null;
        if(!targetPath.equals(sourcePath)){
            if(sourceFile.exists()) {
                if (targetFile.exists()) {
                    System.out.println("文件已存在，是否需要覆盖，是：1，否：0");
                    int key = sc.nextInt();
                    if (key == 1) {
                        targetFile.delete();
                        try {
                            input = new FileInputStream(sourceFile);
                            output = new FileOutputStream(targetFile);
                            byte[] b = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = input.read(b)) != -1) {
                                output.write(b, 0, bytesRead);
                            }
                            System.out.println("文件移动成功");
                        } finally {
                            input.close();
                            output.close();


                        }

                    } else System.out.println("取消移动");
                } else {
                    try {
                        input = new FileInputStream(sourceFile);
                        output = new FileOutputStream(targetFile);
                        byte[] b = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = input.read(b)) != -1) {
                            output.write(b, 0, bytesRead);
                        }
                        System.out.println("文件移动成功");
                    } finally {
                        input.close();
                        output.close();

                    }

                }
            }
        }

    }

    public static void fileCopyUsingBufferFileStream(String sourcePath,String targetPath,String fileName) throws IOException{
        File sourceFile = new File(sourcePath+"/"+fileName);
        File targetFile = new File(targetPath+"/"+fileName);
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
        if(!targetPath.equals(sourcePath)){
            if(sourceFile.exists()) {
                if (targetFile.exists()) {
                    System.out.println("文件已存在，是否需要覆盖，是：1，否：0");
                    int key = sc.nextInt();
                    if (key == 1) {
                        targetFile.delete();
                        try {
                            input = new BufferedInputStream(new FileInputStream(sourceFile));;
                            output = new BufferedOutputStream(new FileOutputStream(targetFile));
                            byte[] b = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = input.read(b)) != -1) {
                                output.write(b, 0, bytesRead);
                            }
                            System.out.println("文件移动成功");
                        } finally {
                            input.close();
                            output.close();


                        }

                    } else System.out.println("取消移动");
                } else {
                    try {
                        input = new BufferedInputStream(new FileInputStream(sourceFile));;
                        output = new BufferedOutputStream(new FileOutputStream(targetFile));
                        byte[] b = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = input.read(b)) != -1) {
                            output.write(b, 0, bytesRead);
                        }
                        System.out.println("文件移动成功");
                    } finally {
                        input.close();
                        output.close();

                    }

                }
            }
        }
    }

    //移动文件到另外一个目录：先判断源目录和目标目录是否是同一个文件夹下，再判断源文件是否存在，然后判断目标目录下是否存在同名文件，是的话是否需要覆盖
    public static void fileRemove(String sourcePath,String targetPath,String fileName ) {
        File sourceFile = new File(sourcePath+"/"+fileName);
        File targetFile = new File(targetPath+"/"+fileName);
        if(!targetPath.equals(sourcePath)){
            if(sourceFile.exists()){
                if(targetFile.exists()){
                    System.out.println("文件已存在，是否需要覆盖，是：1，否：0");
                    int key = sc.nextInt();
                    if(key==1){
                        targetFile.delete();
                        sourceFile.renameTo(targetFile);
                        System.out.println("文件移动成功");
                    }
                    else {
                        System.out.println("取消移动");
                    }

                }
                else sourceFile.renameTo(targetFile);

            }
            else System.out.println("源文件不存在，无法移动");
        }
        else System.out.println("同一个目录，无需移动");


    }



    public static void main(String[] args) throws IOException{
        File directory = new File("");
        String path =directory.getAbsolutePath();//获取项目绝对路径
        String  targetPath= path+"/src/main/源目录";
        String fileName = "1.png";
        String sourcePath= path+"/src/main/目标目录";
        FileCopy.fileCopyUsingBufferFileStream(sourcePath,targetPath,fileName);
    }

}

