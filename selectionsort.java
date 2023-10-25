import java.util.Scanner;

public class selectionsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, loc, temp;
        System.out.println("how many elements?");
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("elements are:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (i = 0; i < n - 1; i++) {
            loc = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[loc]) {
                    loc = j;
                }
            }
            temp = a[i];
            a[i] = a[loc];
            a[loc] = temp;
        }
        for (i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
