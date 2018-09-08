package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.domain.Member;

public class TeacherController {

    public static Scanner key;

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

        while (true) {
            Teacher t = new Teacher();
            System.out.println("이름? ");
            t.setName(key.nextLine());
            System.out.println("나이? ");
            t.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            t.setMajor(key.nextLine());
            System.out.println("급여? ");
            t.setPay(Integer.parseInt(key.nextLine()));

            if (teacherIndex == teachers.length)
                increaseStorage();
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
            System.out.printf("[%d] %s %d %s %d\n", count - 1, t.getName(), t.getAge(), t.getMajor(), t.getPay());
        }
    }

    public static void deleteTeacher() {
        System.out.println("삭제할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= teacherIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        for (int i = no; i < teacherIndex - 1; i++) {
            teachers[i] = teachers[i + 1];
        }
        teacherIndex--;

    }

    public static void detailTeacher() {

        System.out.println("조회할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= teacherIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        System.out.printf("이름 : %s\n", teachers[no].getName());
        System.out.printf("나이 : %d\n", teachers[no].getAge());
        System.out.printf("전공 : %s\n", teachers[no].getMajor());
        System.out.printf("직위 : %d\n", teachers[no].getPay());

    }

    public static void increaseStorage() {

        Teacher[] newList = new Teacher[teachers.length + 3];
        for (int i = 0; i < teachers.length; i++) {

            newList[i] = teachers[i];
        }
        teachers = newList;

    }

    public static void serviceTeacherMenu() {
        while (true) {
            System.out.println("강사 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printTeacher();
            } else if (command.equals("add")) {
                inputTeacher();
            } else if (command.equals("delete")) {
                deleteTeacher();
            } else if (command.equals("detail")) {
                detailTeacher();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }

    }

}
