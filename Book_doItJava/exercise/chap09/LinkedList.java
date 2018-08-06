package chap09;
//연결 리스트 클래스

import java.util.Comparator;

public class LinkedList<E> {

    //노드
    class Node<E>{
        private E data;             //데이터를 가리킨다.
        private Node<E> next;       //다음노드를 가리키는 포인터 이다.

        //생성자
        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;       //머리 노드를 가리킨다.
    private Node<E> crnt;       //현재 선택한 노드를 가리킨다. '검색'한 노드를 선택하고 '샂게'하는 등의 용도로 사용한다.

    public LinkedList(){

        /**
         * LinkedList<E>의 생성자는 머리 노드를 가리키는 변수 head 에 null을 대입한다.
         * 그 결과 노드가 하나도 없는 비어있는 연결 리스트가 생성
         * Node<E>형의 변수 head가 머리 노드에 대한 참조이지 머리 노드 그 자체가 아님에 주의
         * 비어있는 연결 리스트는 노드도 없고 head가 가리키는 곳도 없으므로 그 값을 null로 한다.
         */
        head = crnt = null;
    }


    public E search(E obj, Comparator<? super E> c){
        /**
         * 1. 스캔하고 있는 노드를 가리키는 변수 ptr을 head로 초기화
         */
        Node<E> ptr = head;

        /**
         * 2. 조건1을 먼저 판단, ptr값이 null이 아니면 루프 본문 실행
         */
        while (ptr != null){
            /**
             * 3. 조건2를 판단하기 위해 데이터 obj와 스캔하고 있는 노드의 데이터 ptr.data를 comparator c로 비교
             * compare 메서드가 반환하는 값이 0이면 종료 조건 성립 하여 crnt에 ptr을 대입하고 찾은 노드 데이터인 ptr.data를 반환
             */
            if(c.compare(obj, ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }
            /**
             * 4. ptr에 ptr.next를 대입, 이렇게 하면 ptr이 다음 노드를 가리키기 때문에 계속해서 스캔 가능
             */
            ptr  = ptr.next;
        }
        return null;
    }

    //머리 노드 삽입
    public void addFirst(E obj){
        /**
         * 삽입 전의 머리 노드A 에 대한 포인터를 ptr에 대입
         */
        Node<E> ptr = head;

        /**
         * 삽입할 노드G를 new Node<E>(obj, ptr)에 의해 생성, 노드의 데이터는 obj가 되고 뒤쪽 포인터가 가리키는 곳은
         * prt(삽입 전의 머리 노드A)이 된다. 그리고 생성한 노드를 참조 하도록 head를 업데이트 한다.
         */
        head = crnt = new Node<E>(obj, ptr);
    }

    //꼬리 노드 삽입
    public void addLast(E obj){
        if(head == null)
            addFirst(obj);
        else {
            /**
             * 꼬리 노드를 찾는다. 머리 노드를 가리키도록 초기화 한 ptr임 가리키는 노드를 계속해서 다음 노드를 가리키도록 업데이트 하는 과정 반복
             * ptr.next가  가리키는 노드가 널이 되면 while문을 종료 한다.
             */
            Node<E> ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;

            /**
             * 삽입할 노드G을 new Node<E>(obj, null)에 의해 생성, 생성한 노드G의 데이터는 obj가 되고 뒤쪽 포인터가 참조하는 곳은 널이 된다.
             * 노드 F의 뒤쪽 포인터 ptr.next가 참조하는 곳이 새로 삽입한 노드G가 되도록 업데이트 한다.
             */
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    //머리 노드를 삭제
    public void removeFirst(){
        if(head != null)
            head = crnt = head.next;
    }

}
