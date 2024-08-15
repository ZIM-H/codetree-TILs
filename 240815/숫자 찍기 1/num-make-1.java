import java.util.*;
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        if(m == 1) methodOne();
        else if(m == 2) methodTwo();
        else methodThree();
    }

    public static void methodOne(){
        int[][] map = new int[n][n];

        int num = 1;
        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                for(int j=0; j<i; j++){
                    map[i-1][j] = num++;
                }
            }
            else {
                for(int j=n-(n-i)-1; j>=0; j--){
                    map[i-1][j] = num++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0) continue;
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void methodTwo(){
        int col = 2*n-1;
        int[][] map = new int[n][col];
        for(int i=0; i<n; i++){
            Arrays.fill(map[i], -1);
            for(int j=i; j<col-i; j++){
                map[i][j] = i;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] == -1) System.out.print("  ");
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void methodThree(){
        int col = n/2+1;
        int[][] map = new int[n][col];
        for(int i=0; i<col; i++){
            for(int j=i; j<n-i; j++){
                map[j][i] = i+1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] == 0) System.out.print("  ");
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}