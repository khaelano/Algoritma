public class Test {
    public static void main(String[] args) {
        int pool[] = {10, 15, 9, 7, 9, 0, 5, 4, 50};
        
        int leastPool = pool[0];
        for (int i: pool) {
            if (i <= leastPool) {
                leastPool = i;
            }
        }

        System.out.println(leastPool);

    }
}
