package studentsOperation;

/**
 * @ClassName Students
 * @Author:kzb
 * @Description:
 * @Date: 2021/6/11 4:08 下午
 * @Veraion:1.0
 **/

import java.util.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;


class Students implements Comparable<Students> {
    public String name;
    public double yuwen_score, shuxue_score, yingyu_score;

    public Students() {

    }

    public Students(String name, double yuwen_score, double shuxue_score, double yingyu_score) {
        this.name = name;
        this.yuwen_score = yuwen_score;
        this.shuxue_score = shuxue_score;
        this.yuwen_score = yingyu_score;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setYuwen_score(double yuwen_score) {
        this.yuwen_score = yuwen_score;

    }

    public double getYuwen_score() {
        return this.yuwen_score;
    }

    public void setShuxue_score(double shuxue_score) {
        this.shuxue_score = shuxue_score;

    }

    public double getShuxue_score() {
        return this.shuxue_score;
    }

    public void setYingyu_score(double yingyu_score) {
        this.yingyu_score = yingyu_score;
    }

    public double getYingyu_score() {
        return this.shuxue_score;
    }

    //求成绩平均值
    public double getAvgScore() {
        double avg_score = Math.round((this.yuwen_score + this.shuxue_score + this.yingyu_score) / 3);
        return avg_score;
    }

    public String getLevel() {

        String level = "";
        double avg_score = getAvgScore();
        if (avg_score >= 90) {
            level = "优秀";
        } else if (avg_score >= 80 && avg_score < 90) {
            level = "良好";
        } else if (avg_score >= 60 && avg_score < 80) {
            level = "及格";
        } else if (avg_score < 70) {
            level = "不及格";
        }
        return level;
    }

    @Override
    public int compareTo(Students stu) {
        return stu.getAvgScore() - this.getAvgScore() > 0 ? 1 : ((this.getAvgScore() == stu.getAvgScore()) ? 0 : -1);   //降序：返回值为1 或-1 升序改变变量位置即可
    }


    public static void main(String[] args) {
        //定义学生集合
        List<Students> students = new ArrayList<Students>();

        //输入6位学生成绩
        for (int x = 1; x <= 6; ++x) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第" + x + "个学生的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入第" + x + "个学生的语文成绩：");
            double yuwen_score = sc.nextDouble();
            System.out.println("请输入第" + x + "个学生的数学成绩：");
            double shuxue_score = sc.nextDouble();
            System.out.println("请输入第" + x + "个学生的英语成绩：");
            double yingyu_score = sc.nextDouble();
            Students s = new Students();
            s.setName(name);
            s.setYuwen_score(yuwen_score);
            s.setShuxue_score(shuxue_score);
            s.setYingyu_score(yingyu_score);
            students.add(s);

        }
        Collections.sort(students);

        //将录入成绩保存到文档中


        //打印成绩
        System.out.println("============================" + "学生成绩表============================");
        int len = students.size();
        if (len == 0) {
            System.out.println("没有学生成绩");
        } else {
            System.out.println("姓名\t\t等级\t\t语文分数\t\t数学分数\t\t英语分数\t\t平均分数");
            for (int i = 0; i < len; i++) {
                System.out.println(students.get(i).name + "\t\t" + students.get(i).getLevel() + "\t\t" + students.get(i).yuwen_score + "\t\t" + students.get(i).shuxue_score

                        + "\t\t" + students.get(i).yingyu_score + "\t\t" + students.get(i).getAvgScore());

            }
        }
    }
}

