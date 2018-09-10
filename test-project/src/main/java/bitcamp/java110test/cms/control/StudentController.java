package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.domain.Student;
import bitcamp.java110test.cms.util.ArrayList;

public class StudentController {

    public static Scanner key;
    private ArrayList students = new ArrayList();

    public StudentController(Scanner key) {
        this.key = key;
    }

    public void inputStudent() {

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

            students.add(m);
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;

        }

    }

    public void printStudent() {

        for (int i = 0; i < students.size(); i++) {
            Student s = (Student) students.get(i);
            System.out.printf("[%d] %s %d %s %s\n", i, s.getName(), s.getAge(), s.getMajor(), s.getId());

        }
    }

    public void deleteStudent() {
        System.out.println("삭제할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        students.remove(no);
        System.out.println("삭제하였습니다.");
    }

    public void detailStudent() {
        System.out.println("조회할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());
        if (no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Student s = (Student) students.get(no);
        System.out.printf("이름 : %s\n", s.getName());
        System.out.printf("나이 : %d\n", s.getAge());
        System.out.printf("전공 : %s\n", s.getMajor());
        System.out.printf("학번 : %s\n", s.getId());

    }

    public void serviceStudentMenu() {

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
