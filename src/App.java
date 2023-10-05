import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner S = new Scanner(System.in);
        Cache cache = new Cache(8);

        while (true) {
            System.out.println(cache.cache);
            System.out.println("Enter the value");
            int value = S.nextInt();
            cache.put(value);
        }
    }
}
