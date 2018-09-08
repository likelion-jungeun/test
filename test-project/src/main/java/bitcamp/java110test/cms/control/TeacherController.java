package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.dao.TeacherList;
import bitcamp.java110test.cms.domain.Teacher;

public class TeacherController {

    public static Scanner key;

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

            TeacherList.add(t);
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;
        }
    }

    public static void printTeacher() {

        for (int i = 0; i < TeacherList.size(); i++) {
            Teacher t = TeacherList.get(i);
            System.out.printf("[%d] %s %d %s %d\n", i, t.getName(), t.getAge(), t.getMajor(), t.getPay());

        }
    }

    public static void deleteTeacher() {
        System.out.println("삭제할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= TeacherList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        TeacherList.remove(no);
        System.out.println("삭제하였습니다.");

    }

    public static void detailTeacher() {

        System.out.println("조회할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= TeacherList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        Teacher teacher = TeacherList.get(no);
        System.out.printf("이름 : %s\n", teacher.getName());
        System.out.printf("나이 : %d\n", teacher.getAge());
        System.out.printf("전공 : %s\n", teacher.getMajor());
        System.out.printf("직위 : %d\n", teacher.getPay());

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
