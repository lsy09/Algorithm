package chap06;

import java.util.Scanner;

public class HeapSort {
    //배열의 요소 a[idx1]과 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    /**
     * 배열 a가운데 a[left] ~ a[right]의 요소를 힙으로 만드는 메서드
     * a[left] 이외에는 모두 힙 상태라고 가정, a[left]를 아랫부분의 알맞은 위치로 옮겨 힙 상태를 만든다
     * >> '루트를 없애고 힙 상태 유지하기' 에 대한 내용
     */
    //a[left]~a[right]를 힙으로 만든다
    static void downHeap(int[] a, int left, int right){
        int temp = a[left]; // 루트
        int child;          // 큰 값을 가진 노드
        int parent;         // 부모

        for(parent = left; parent < (right + 1) / 2; parent = child){
            int cl = parent * 2 + 1;    // 왼쪽 자식
            int cr = cl + 2;            // 오른쪽 자식
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;   // 큰 값을 가진 노드를 자식에 대입
            if(temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    /**
     * 요소의 개수가 n개인 배열 a를 힙 정렬하는 메서드
     * 2개의 단계로 구성된다.
     * 1) downHeap 메서드를 사용하여 배열 a를 힙으로 만든다.
     * 2) 루트(a[0])에 있는 가장 큰 값을 빼내어 배열 마지막 요소와 바꾸고 배열의 나머지 부분을 다시 힙으로 만드는 과정을 반복하여 정렬을 수행 한다.
     * >> 1)은 '배열을 힙으로 만들기' 2)는 '힙 정렬 알고리즘 살펴보기' 에 대한 내용
     */
    //힙 정렬
    static void heapSort(int[] a, int n){
        for(int i = (n-1) /2; i >= 0; i--)  // a[i]~a[n-1]를 힙으로 만들기
            downHeap(a, i, n-1);

        for(int i = n-1; i>0; i--){
            swap(a, 0, i);  // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            downHeap(a,0, i-1); // a[0]~a[i-1]을 힙으로 만든다
        }
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.println("요솟수 : ");
        int nx = stdin.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.println("x[" + i + "] : ");
            x[i] = stdin.nextInt();
        }

        heapSort(x, nx);    // 배열 x를 힙 정렬 한다.

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
