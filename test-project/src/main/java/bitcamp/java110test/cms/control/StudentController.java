package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.dao.StudentList;
import bitcamp.java110test.cms.domain.Student;

public class StudentController {

    public static Scanner key;

    public static void inputStudent() {

        while (true) {
            Student m = new Student();
            System.out.println("이름? ");
            m.setName(key.nextLine());
            System.out.println("나이? ");
            m.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            m.setMajor(key.nextLine());
            System.out.println("학번? ");
            m.setId(key.nextLine());

            StudentList.add(m);
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;

        }

    }

    public static void printStudent() {

        for (int i = 0; i < StudentList.size(); i++) {
            Student s = StudentList.get(i);
            System.out.printf("[%d] %s %d %s %s\n", i, s.getName(), s.getAge(), s.getMajor(), s.getId());

        }
    }

    public static void deleteStudent() {
        System.out.println("삭제할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= StudentList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        StudentList.remove(no);
        System.out.println("삭제하였습니다.");
    }

    public static void detailStudent() {
        System.out.println("조회할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());
        if (no < 0 || no >= StudentList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Student student = StudentList.get(no);
        System.out.printf("이름 : %s\n", student.getName());
        System.out.printf("나이 : %d\n", student.getAge());
        System.out.printf("전공 : %s\n", student.getMajor());
        System.out.printf("학번 : %s\n", student.getId());

    }

    public static void serviceStudentMenu() {

        while (true) {
            System.out.println("학생 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printStudent();
            } else if (command.equals("add")) {
                inputStudent();
            } else if (command.equals("delete")) {
                deleteStudent();
            } else if (command.equals("detail")) {
                detailStudent();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }

    }

}
