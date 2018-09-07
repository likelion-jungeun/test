import java.util.Scanner;

public class TeacherController {

    static Scanner key;

    static class Teacher extends Member {
        int pay;

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }
    }

    static Teacher[] teachers = new Teacher[10];
    static int teacherIndex = 0;

    public static void inputTeacher() {
        Teacher t = new Teacher();
        while (true) {
            System.out.println("이름? ");
            t.setName(key.nextLine());
            System.out.println("나이? ");
            t.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            t.setMajor(key.nextLine());
            System.out.println("급여? ");
            t.setPay(Integer.parseInt(key.nextLine()));

            teachers[teacherIndex++] = t;
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;
        }
    }

    public static void printTeacher() {

        int count = 0;

        for (Teacher t : teachers) {
            if (count++ == teacherIndex)
                break;
            System.out.printf("%s %d %s %d\n", t.getName(), t.getAge(), t.getMajor(), t.getPay());
        }
    }

    public static void serviceTeacherMenu() {
        while (true) {
            System.out.println("강사 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printTeacher();
            } else if (command.equals("add")) {
                inputTeacher();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }

    }

}
