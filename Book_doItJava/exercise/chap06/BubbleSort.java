package chap06;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.println("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.println("x[ "+ i +" ] : ");
            x[i] = stdIn.nextInt();
        }
        bubbleSort(x, nx); //배열 x를 버블 정렬 합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++){
            System.out.println("x[ " + i + " ]= " + x[i]);
        }
    }


    // a[idx1]와 a[idx2]의 값을 바꾼다
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    /**
     * 버블 정렬 프로그램
     * 변수의 i의 값을 0부터 n-2까지 1씩 증가하며 n-1회의 패스를 수행하는 프로그램
     **/
    static void bubbleSort(int[] a, int n){
        for(int i=0; i<n-1; i++){
            //a[i], a[i+1],...,a[n-1]에 대해
            //끝에서부터 앞쪽으로 스캔하면서 이웃하는 두 요소를 비교하고 교환한다.
            for(int j=n-1; j>i; j--)
                if(a[j-1] > a[j])
                    swap(a, j-1, j);
        }
    }





}
