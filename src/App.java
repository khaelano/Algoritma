import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner S = new Scanner(System.in);

        Cache Pool = new Cache(8);

        boolean loop = true;
        while(loop == true) {
            System.out.println("Input entry (key value):");
            int key = S.nextInt();
            int value = S.nextInt();

            Pool.put(key, value);
        }
    }
}
