package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.domain.Member;

public class StudentController {

    static Student[] students = new Student[10];
    static int studentIndex = 0;
    public static Scanner key;

    static class Student extends Member {

        String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

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
            students[studentIndex++] = m;
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;

        }

    }

    public static void printStudent() {

        int count = 0;
        for (Student s : students) {
            if (count++ == studentIndex)
                break;
            System.out.printf("[%d] %s %d %s %s\n", count - 1, s.getName(), s.getAge(), s.getMajor(), s.getId());
        }
    }

    public static void deleteStudent() {
        System.out.println("삭제할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        for (int i = no; i < studentIndex - 1; i++) {
            students[i] = students[i + 1];
        }
        studentIndex--;

    }

    public static void detailStudent() {
        System.out.println("조회할 번호를 입력하세요.");
        int no = Integer.parseInt(key.nextLine());
        if (no < 0 || no >= studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        System.out.printf("이름 : %s\n", students[no].getName());
        System.out.printf("나이 : %d\n", students[no].getAge());
        System.out.printf("전공 : %s\n", students[no].getMajor());
        System.out.printf("학번 : %s\n", students[no].getId());

    }

    public static void increaseStorage() {

        Student[] newList = new Student[students.length + 3];
        for (int i = 0; i < students.length; i++) {

            newList[i] = students[i];
        }
        students = newList;

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
