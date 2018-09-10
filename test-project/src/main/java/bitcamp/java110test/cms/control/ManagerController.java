package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.domain.Manager;
import bitcamp.java110test.cms.util.ArrayList;

public class ManagerController {

    public static Scanner key;
    private ArrayList managers = new ArrayList();

    // 반드시 입력이 필요하기 때문에, 생성자를 써서 한 번 더 강조 해줌
    public ManagerController(Scanner key) {
        this.key = key;
    }

    public void inputManager() {

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

            managers.add(m);

            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;
        }
    }

    public void printManager() {
        for (int i = 0; i < managers.size(); i++) {
            Manager m = (Manager) managers.get(i);
            System.out.printf("[%d] %s %d %s %s\n", i, m.getName(), m.getAge(), m.getMajor(), m.getPosition());

        }

    }

    public void deleteManager() {

        System.out.println("삭제할 번호를 입력하세요");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        managers.remove(no);
        System.out.println("삭제하였습니다.");

    }

    public void detailManager() {
        System.out.println("조회할 번호를 입력하세요");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        Manager m = (Manager) managers.get(no);
        System.out.printf("이름 : %s\n", m.getName());
        System.out.printf("나이 : %d\n", m.getAge());
        System.out.printf("전공 : %s\n", m.getMajor());
        System.out.printf("직위 : %s\n", m.getPosition());

    }

    public void serviceManagerMenu() {
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
