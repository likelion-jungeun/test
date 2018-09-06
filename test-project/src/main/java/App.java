import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 키보드 입력을 처리할 객체 준비

        Scanner in = new Scanner(System.in);
        // 사용자로부터 회원 정보 입력받기
        while (true) {

            System.out.println("이름? ");
            String name = in.nextLine();
            System.out.println("나이? ");
            int age = Integer.parseInt(in.nextLine());
            System.out.println("학번? ");
            String id = in.nextLine();
            System.out.println("학과? ");
            String dept = in.nextLine();

            System.out.printf("%s, %d, %s, %s\n", name, age, id, dept);

            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(in.nextLine()))
                break;
        }
    }
}
