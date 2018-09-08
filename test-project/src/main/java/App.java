import java.util.Scanner;

import bitcamp.java110test.cms.control.ManagerController;
import bitcamp.java110test.cms.control.StudentController;
import bitcamp.java110test.cms.control.TeacherController;

public class App {

    /* 배열 목록 처리 추가 -> 배열 크기보다 더 많이 추가하면 배열을 추가적으로 더.
     delete랑 detail 기능도 추가
     inputTeacher(), inputManager()에서 잘못된 코드 발견 및 수정*/

    static Scanner key = new Scanner(System.in);

    public static String promptMenu() {

        System.out.println("[메뉴]");
        System.out.println("1.학생관리");
        System.out.println("2.강사관리");
        System.out.println("3.매니저관리");
        System.out.println("0.종료");
        System.out.println("번호를 입력하세요");
        while (true) {
            String menu = key.nextLine();
            switch (menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("유효하지 않는 명령어입니다.");
            }
        }
    }

    public static void main(String[] args) {
        StudentController.key = key;
        TeacherController.key = key;
        ManagerController.key = key;

        while (true) {

            String menu = promptMenu();
            if (menu.equals("1")) {
                StudentController.serviceStudentMenu();
            } else if (menu.equals("2")) {
                TeacherController.serviceTeacherMenu();
            } else if (menu.equals("3")) {
                ManagerController.serviceManagerMenu();
            } else if (menu.equals("0")) {
                System.out.println("안녕히 가세요!");
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }
        key.close();
    }

}