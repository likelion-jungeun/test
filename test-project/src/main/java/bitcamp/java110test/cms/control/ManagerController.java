package bitcamp.java110test.cms.control;

import java.util.Scanner;
import bitcamp.java110test.cms.domain.Member;

public class ManagerController {

    static Manager[] managers = new Manager[5];
    static int managerIndex = 0;
    public static Scanner key;

    static class Manager extends Member {
        String position;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

    }

    public static void inputManager() {

        while (true) {
            Manager m = new Manager();
            System.out.println("이름? ");
            m.setName(key.nextLine());
            System.out.println("나이? ");
            m.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            m.setMajor(key.nextLine());
            System.out.println("직위? ");
            m.setPosition(key.nextLine());

            if (managerIndex == managers.length)
                increaseStorage();

            managers[managerIndex++] = m;

            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;
        }
    }

    public static void printManager() {
        int count = 0;
        for (Manager m : managers) {
            if (count++ == managerIndex)
                break;
            System.out.printf("[%d] %s %d %s %s\n", count - 1, m.getName(), m.getAge(), m.getMajor(), m.getPosition());
        }

    }

    public static void deleteManager() {

        System.out.println("삭제할 번호를 입력하세요");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= managerIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        for (int i = no; i < managerIndex - 1; i++) {
            managers[i] = managers[i + 1];
        }
        managerIndex--;

    }

    public static void detailManager() {
        System.out.println("조회할 번호를 입력하세요");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= managerIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        System.out.printf("이름 : %s\n", managers[no].getName());
        System.out.printf("나이 : %d\n", managers[no].getAge());
        System.out.printf("전공 : %s\n", managers[no].getMajor());
        System.out.printf("직위 : %s\n", managers[no].getPosition());

    }

    // 배열 꽉 찼을 때 배열 늘리기
    public static void increaseStorage() {

        Manager[] newList = new Manager[managers.length + 3];

        for (int i = 0; i < managers.length; i++) {
            newList[i] = managers[i];
        }
        managers = newList;

    }

    public static void serviceManagerMenu() {
        while (true) {
            System.out.println("매니저 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printManager();
            } else if (command.equals("add")) {
                inputManager();
            } else if (command.equals("delete")) {
                deleteManager();
            } else if (command.equals("detail")) {
                detailManager();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }
    }
}
