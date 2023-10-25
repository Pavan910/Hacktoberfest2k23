import java.util.Scanner;

public class mergesort {
    void merge1(int a[], int start, int mid, int end) {
        int l = mid - start + 1;
        int r = end - mid;
        int left_subarray[] = new int[l];
        int right_subarray[] = new int[r];
        for (int i = 0; i < l; i++)
            left_subarray[i] = a[start + i];
        for (int j = 0; j < r; j++)
            right_subarray[j] = a[mid + 1];
        int i = 0, j = 0;
        int k = start;
        while (i < l && j < r) {
            if (left_subarray[i] <= right_subarray[j]) {
                a[k] = left_subarray[i];
                i++;
            } else {
                a[k] = right_subarray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            a[k] = left_subarray[i];
            i++;
            k++;
        }
        while (j < r) {
            a[k] = right_subarray[j];
            j++;
            k++;
        }
    }

    void merge2(int a[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge2(a, start, mid);
            merge2(a, mid + 1, end);
            merge1(a, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int n, i, a[];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the elements:");
        n = sc.nextInt();
        a = new int[n];
        System.out.println("elements are:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        mergesort obj = new mergesort();
        obj.merge2(a, 0, n - 1);
        for (i = 0; i < n; i++)
            System.out.println(a[i]);
    }
}
