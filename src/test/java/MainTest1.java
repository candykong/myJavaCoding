/**
 * @author kongzhibing
 * @create 2021-07-05-9:43
 */
public class MainTest1 {
    public static void main(String[] args) {
        Subject sb1 = new Subject("Chinese");
        Subject sb2 = new Subject("Math");
        Subject sb3 = new Subject("English");


        double avg1 = sb1.getAverageGrade(87.0, 98.0, 76.0);
        double avg2 = sb1.getAverageGrade(65.0, 42.0, 33.0);
        double avg3 = sb1.getAverageGrade(95.0, 95.0, 92.0);
        double avg4 = sb1.getAverageGrade(75.0, 76.0, 74.0);
        double avg5 = sb1.getAverageGrade(87.0, 82.0, 83.0);
        double avg6 = sb1.getAverageGrade(63.0, 77.0, 44.0);

        sb1.getGradeLevel(avg1);
        sb1.getGradeLevel(avg2);
        sb1.getGradeLevel(avg3);
        sb1.getGradeLevel(avg4);
        sb1.getGradeLevel(avg5);
        sb1.getGradeLevel(avg6);
    }
}
