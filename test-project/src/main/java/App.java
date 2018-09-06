import java.util.Scanner;

public class App {

    // 배열을 이용하여 여러 회원의 정보 저장
    public static void main(String[] args) {

        String[] names = new String[10];
        int[] ages = new int[10];
        String[] ids = new String[10];
        String[] depts = new String[10];

        Scanner key = new Scanner(System.in);
        int index = 0;
        while (true) {
            System.out.println("이름? ");
            names[index] = key.nextLine();
            System.out.println("나이? ");
            ages[index] = Integer.parseInt(key.nextLine());
            System.out.println("학번? ");
            ids[index] = key.nextLine();
            System.out.println("학과? ");
            depts[index] = key.nextLine();

            index++;
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;

        }

        for (int i = 0; i < index; i++) {
            System.out.printf("%s %d %s %s\n", names[i], ages[i], ids[i], depts[i]);
        }

        key.close();

    }
}
