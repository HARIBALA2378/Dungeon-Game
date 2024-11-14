import java.util.Scanner;

public class Module1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int adventurerow = sc.nextInt();
        int adventurecol = sc.nextInt();
        int goldrow = sc.nextInt();
        int goldcol = sc.nextInt();

        boolean[][] visited = new boolean[m + 1][n + 1];

        System.out.println(helper(m,n,adventurerow,adventurecol,goldrow,goldcol,visited));
    }

    public static int helper(int m,int n,int adventurerow,int adventurecol,int goldrow,int goldcol,boolean[][] visited) {
        if (adventurerow == goldrow && adventurecol == goldcol) {
            return 1;
        }
        if (adventurerow < 0 || adventurerow > m || adventurecol < 0 || adventurecol > n) {
            return 0;
        }
//        if(adventurerow == 'X' && adventurecol == 'X') {
//            return 0;
//        }
        if (visited[adventurerow][adventurecol]) {
            return 0;
        }
        visited[adventurerow][adventurecol] = true;

        int top = helper(m, n, adventurerow - 1 , adventurecol , goldrow, goldcol, visited);
        int left = helper(m, n, adventurerow , adventurecol - 1, goldrow, goldcol, visited);
        int right = helper(m, n, adventurerow , adventurecol + 1 , goldrow, goldcol, visited);
        int down = helper(m, n, adventurerow + 1, adventurecol , goldrow, goldcol, visited);

        visited[adventurerow][adventurecol] = false;

        return Math.min(Math.min(right,left),Math.min(top, down)) + 1;
    }
}
