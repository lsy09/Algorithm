---
layout: post
title:  
date:   
desc: 
keywords: 
categories: 
tags: 
icon: 
---

### 정렬이란?
> 정렬(sorting)은 이름, 학번, 키 등 핵심 항목(key)의 대소 관계에 따라 데이터 집합을 일정한 순서로 줄지어 늘어서도록 바꾸는 작업을 말한다.

* 내부정렬과 외부정렬
    1. 내부정렬 : 정렬할 모든 데이터를 하나의 배열에 저장할 수 있는 경우에 사용하는 알고리즘
    2. 외부정렬 : 정렬할 데이터가 너무 많아서 하나의 배열에 저장할 수 없는 경우에 사용하는 알고리즘

* 정렬 알고리즘의 핵심 요소
    * 교환, 선택, 삽입이며 대부분의 정렬 알고리즘은 이 세 가지 요소를 응용한 것이다.

-----------------------

### 버블 정렬
> 이웃한 두 요소의 대소 관계를 비교하여 교환을 반복 한다.

* 수행하는 패스의 횟수가 n회가 아니라 n-1회 인것은 n-1개의 요소의 정렬이 끝나면 마지막 요소는 이미 끝에 놓이기 때문이다.
* ‘버블정렬’이라는 말은 액체안의 공기 방울(액체보다 가벼운 공기 방울)이 보글보글 위로 올라오는 모습에서 착안한 것이다.

-----------------------

### 단순 선택 정렬
> 가장 작은 요소부터 선택해 알맞은 위치로 옮겨서 순서대로 정렬 하는 알고리즘이다.

* 가장 작은 값의 요소인 1을 선택해 정렬을 시작
    | (6) | 4 | 8 | 3 | (1) | 9 | 7 |
    |-----|---|---|---|-----|---|---|

* 1을 6과 교환, 교환한 다음의 배열 상태
    | (1) | 4 | 8 | 3 | (6) | 9 | 7 |
    |-----|---|---|---|-----|---|---|

* 가장 작은 요소인 1이 맨앞으로 옴, 두번째로 작은 요소인 3을 선택해 정렬
3을 4와 교환 하면 두번째 요소의 정렬이 끝남
    | 1 | (3) | 8 | (4) | 6 | 9 | 7 |
    |---|-----|---|-----|---|---|---|

* 아직 정렬하지 않은 부분에서 값이 가장 작은 요소를 선택하고 아직 정렬하지 않은 부분의 첫 번째 요소와 교환 한다.

* 단순 선택 정렬의 교환 과정
    1. 아직 정렬하지 않은 부분에서 가장 작은 키의 값(a[min])을 선택
    2. a[min]과 아직 정렬하지 않은 부분의 첫 번째 요소를 교환

```java
for(int i=0; i<n-1; i++){
    // min = a[i], ..., a[n-1]에서 가장 작은 값을 가지는 요소의 인덱스
    // a[i]와 a[min]의 값을 교환
}
```

-----------------------

### 단순 삽입 정렬
> 선택한 요소를 그보다 더 앞쪽의 알맞은 위치에 '삽입하는' 작업을 반복하여 정렬하는 알고리즘이다.
> 단순 선택 정렬과 비슷해 보일 수 있지만 단순 선택 정렬은 값이 가장 작은 요소를 선택해 알맞은 위치로 옮긴다는 점이 다르다.

* 트럼프 카드를 한 줄로 늘어놓을 때 사용하는 방법과 비슷한 방법의 알고리즘이다.
    | 6 | (4) | 1 | 7 | 3 | 9 | 8 |
    |---|-----|---|---|---|---|---|

* 단순 삽입 정렬은 2번째 요소부터 선택하여 진행, 이때 4는 6보다 앞쪽에 위치해야 하므로 앞쪽에 삽입한다.
    | (4) | 6 | 1 | 7 | 3 | 9 | 8 |
    |-----|---|---|---|---|---|---|

* 3번째 요소 1을 선택해 앞쪽으로 삽입, 계속 해서 같은 작업을 수행한다.
    ```text
     아직 정렬되지 않은 부분의 첫 번재 요소를 정렬된 부분의 알맞은 위치에 삽입한다.
     ```

```java
for(int i=1; i<n; i++){
    // tmp <- a[i]
    // a[0], ..., a[i-1]의 알맞은 곳에 tmp를 삽입
}
```

* tmp에 a[i]를 대입하고 반복 제어용 변수 j에 i-1을 대입한 다음 아래의 두 조건 중 하나를 만족할 때까지 j를 1씩 감소하면서 대입하는 작업을 반복한다.
        1. 정렬된 열의 왼쪽 끝에 도달
        2. tmp보다 작거나 같은 key를 갖는 항목 a[j]를 발견

* 드모르간 법칙을 적용하면 아래의 두 조건이 모두 성립할 때까지 반복 한다고 할수 있다.
    1. j가 0보다 크다
    2. a[j-1] 값이 tmp보다 크다

* 위 과정을 마치고 난 다음에 요소 a[j]에 tmp를 대입하면 한 요소에 대한 단순 삽입 정렬을 마치게 된다.

```text
단순 삽입 정렬은 셔틀 정렬(shuttle sort)이라고도 한다.
```

#### 단순 정렬의 시간 복잡도
> 세 가지 단순 정렬(버블, 선택, 삽입)의 시간 복잡도는 모두 O(n<sup>2</sup>)이다.(효율이 좋지 않다.)

-----------------------

### 셸 정렬
> 단순 삽입 정렬의 장점은 살리고 단점은 보완하여 좀더 빠르게 정렬하는 알고리즘 이며, 도널드 셀(D.L.Shell)이 고안 했다.

* 먼저 정렬할 배열의 요소를 그룹으로 나눠 각 그룹별로 단순 삽입 정렬을 수행하고, 그 그룹을 합치면서 정렬을 반복하여 요소의 이동 횟수를 줄이는 방법이다.
```text
퀵 정렬이 고안되기 전까지는 가장 빠른 알고리즘으로 알려져 있다.
```

* 단순 삽입 정렬의 특징
    1. 정렬을 마쳤거나 정렬을 마친 상태에 가까우면 정렬 속도가 매우 빨라진다.(장점)
    2. 삽입할 위치가 멀리 떨어져 있으면 이동(대입)해야 하는 횟수가 많아진다.(단점)

```java
for(int h = n/2; h > 0; h /= 2)
    for(int i = h; i < n; i++){
        int j;
        int tmp = a[i];
        for(j = i-h; j >= 0 && a[j] > tmp; j -= h)
            a[j + h] = a[j];
        a[j + h] = tmp;
    }
```

-----------------------

### 퀵 정렬
> 퀵정렬은 가장 빠른 정렬 알고리즘 중 하나로 널리 사용 중이다.

#### 퀵 정렬 살펴 보기

* 퀵 정렬(quick sort)은 일반적으로 사용되고 있는 아주 빠른 정렬 알고리즘 이다.
* 이 알고리즘의 정렬 속도가 매우 빠른 데서 착안해 찰스 앤터니 리처드 호어(C.A.R.Hoare)가 직접 붙인 이름이다.
    * 학생수가 8명인 그룹을 키순서대로 정렬하기 위해 한 학생 A를 기준으로 학생 A의 키보다 작은 사람의 그룹과 큰 사람의 그룹으로 나눈다
    이때 학생 A를(그룹을 나누는 기준) 피벗(pivot)이라고 한다.
    * 피벗은 마음대로 선택살수 있다, 또한 이 피벗을 어느 하나의 그룹에 포함 시키고자 할 경우 왼쪽 그룹과 오른 쪽 그룹 어디에 들어가도 상관 없다.   

#### 배열을 두 그룹으로 나누기

* 그룹을 나누려면 피벗 이하의 요소를 배열 왼쪽으로, 이상의 요소를 배열 오른쪽으로 옮겨야 한다.    
* 피벗을 x, 왼쪽 끝 요소의 인덱스 pl을 왼쪽 커서, 오른쪽 끝 요소의 인덱스 pr을 오른쪽 커서라고 정하고 아래의 작업을 먼저 수행 한다.

```markdown
1. a[pl] >= x가 성립하는 요소를 찾을 때까지 pl을 오른쪽으로 스캔
2. a[pr] <= x가 성립하는 요소를 찾을때 까지 pr을 왼쪽으로 스캔
```

#### 퀵 정렬

* 배열을 피벗 기준으로 나누는것을 좀 더 발전 시키면 퀵 정렬 알고리즘이 된다.
    * 요소가 9개인 배열을 나누면 두개의 그룹으로 나누어지고 그 두개의 그룹을 또다시 두 그룹으로 나눈다.
    요소의 개수가 1개인 그웁은 더 이상 나울 필요가 없으므로 요소의 개수가 2개 이상인 그룹만 나눈다.
    
    ```markdown
    1. pr이 a[0]보다 오른쪽에 있으면 (left < pr) 왼쪽 그룹을 나눔
    2. pl이 a[8]보다 왼쪽에 있으면(pl < right) 오른쪽 그룹을 나눔
    ** 가운데 그룹(a[pr+1] ~ a[pl-1]은 나눌 필요가 없음(분할 대상에서 제외)
    left<pr, pl<right는 모두 그룹의 개수가 1개인 경우에서는 성립하지 않는 조건, 요소의 개수가 2개 이상인 그룹만이 나누기 위해 필요한 조건임 
    ``` 
    
-----------------------

## 힙 정렬
> 선택 정렬을 응용한 알고리즘, 힙의 특성을 이용하여 정렬을 수행한다.

### 힙이란?
힙 정렬(heap sort)은 힙(heap)을 사용하여 정렬하는 알고리즘이다. 
힙은 '부모의 값이 자식의 값보다 항상 크다'는 조건을 만족하는 완전이진트리 이다. 
이때 부모이 값이 자식보다 항상 작아도 힙이라고 한다(부모와 자식 요소간의 관계만 일정하면 된다).

```markdown
* 트리
트리의 가장 윗부분을 루트(root)라고 한다. 그리고 요소의 상하 관계를 '부모(parent)'와 '자식(child)'라고 한다.
그리고 자식 간의 관계는 '형제(sibling)'라고 한다.

* 완전이진트리
사람도 유전적인 특징에 의해 분류하는 것처럼 트리의 종류도 여러가지 이다.
완전이진트리 특징은 '완전이진' 상태라는 것이다. 여기서 '완전'이라는 말은 부모는 자식을 왼쪽부터 추가하는 모양을 유지한다는 뜻이다.
그리고 '이진'이라는 말은 '부모가 가질 수 있는 자식의 개수는 최대 2개다'라는 의미이다.
```
![6-33](/Users/lsy/suyoun/Algorithms/book/exercise/img/6-33.png)

힙에서 부모와 자식 관계는 일정하지만 형제 사이의 대소 관계는 일정하지 않다.
> 힙은 형제의 대소 관계가 정해져 있지 않은 특성이 있기 때문에 부분순서트리(partial ordered tree)라고도 한다.

![6-34](/Users/lsy/suyoun/Algorithms/book/exercise/img/6-34.png)

위의 과정을 거쳐 힙의 요소를 배열에 저장하면 부모와 자식의 인덱스 사이에 다음과 같은 관계가 성립힌다.
```markdown
1. 부모는 a[(i-1) / 2]
2. 왼쪽 자식은 a[i * 2 + 1]
3. 오른쪽 자식은 a[i * 2 +2]
```

### 힙 정렬
'가장 큰 값이 루트에 위치'하는 특징을 이용하는 정렬 알고리즘이다. 입에서 가장 큰 값인 루트를 꺼내는 작업을 반복하고,
그 값을 늘어놓으면 배열은 정렬을 마치게 된다. 즉, 힙 정렬은 선택 정렬을 응용한 알고리즘이며 힙에서 가장 큰 값인 루트를 꺼내고 
남은 요소에서 다시 가장 큰 값을구해야 한다.
> 선택 정렬은 가장 작은(혹은 큰) 값을 선택해 정렬하는 알고리즘

```markdown
1. 루트를 꺼냄
2. 마지막 요소를 루트로 이동
3. 자기보다 큰 값을 가지는 자식 요소와 자리를 바꾸며 아래쪽으로 내려가는 작업을 반복, 
이때 자식의 값이 작거나 앞에 다다르면 작업이 종료 
```

#### 힙 정렬 알고리즘 

```markdown
1. 변수 i의 값을 n-1로 초기화
2. a[0]과 a[i]를 바꿈
3. a[0],a[1],...,a[i-1]을 힙으로 만듬
4. i의 값을 1씩 줄여 0되면 끝남, 그렇지 않으면 '2'로 돌아감
```
위의 순서대로 힙 정렬 수행, 초기 상태의 배열이 힙 상태가 아닐 수도 있으므로, 배열을 힙상태로 만듬


### 배열로 힙 만들기
![6-36](/Users/lsy/suyoun/Algorithms/book/exercise/img/6-36.png)

루트를 없앤 다음 마지막 요소를 루트로 옮기고 루트로 옮긴 요소를 알맞은 위치로 옮기면서 힙을 만들었다.
아랫부분의 작은 부분트리부터 시작해 올라가는 방식(bottom-up)으로 전체 배열을 힙으로 만들수 있으며,
가장 아랫부분의 단계가 끝나면 하나 위쪽으로 진행하면서 힙으로 만든다. 
가장 아랫부분의 단계가 끝나면 하나 위쪽을 부분트리 범위를 확장하고 다시 왼쪽으로 진행하면서 부분트리를 힙으로 만든다.

#### 힙 정렬의 시간 복잡도
힙 정렬은 선택 정렬을 응용한 알고리즘이다.
힙 정렬 에서는 첫 요소를 꺼내는 것만으로 가장 큰 값이 구해지므로 첫요소를 꺼낸다음 나머지 요소를 다시 힙으로 만들어야 그 다음에 꺼낼 첫 요소도 가장 큰 값을 유지한다.
단순 선택 정렬에서 가장 큰 요소를 선택할 때의 시간 복잡도O(n)의 값을 한번에 선택 할수 있어 O(1)로 줄일수 있다.
힙 정렬에서 다시 힙으로 만드는 작업의 시간복잡도 O(log n)이다.
따라서 단순 선택 정렬은 전체 정렬에 걸리는 시간 복잡도의 값이 O(n^2)이지만 힙 정렬은 힙으로 만드는 작업을 요소이 개수만큼 반복 하므로
시간 복잡도의 값이 O(n log n)으로 크게 줄어든다. 

-----------------------

## 도수정렬
> 도수 정렬은 요소의 대소 관계를 판단하지 않고 빠르게 정렬할 수 있는 알고리즘 이다.

지금까지의 정렬 알고리즘은 두 요소의 키 값을 비교해야 했다. 하지만 도수 정렬은 요소를 비교할 필요가 없다는 특징이 있다. 

### 도수 정렬의 4단계
1. 도수분포표 작성
2. 누적도수분포표 작성
3. 목적 배열 만들기
4. 배열 복사복사

> 정렬하는 배열은 a, 요소의 개수는 n, 점수의 최댓값은 max 이다.

#### 1단계 도수분포표 만들기
* 배열 a를 바탕으로 도수분포표를 나타내기 위해 배열 f를 사용한다. 먼저 배열 f의 모든 요소의 값을 0으로 초기화 하고 배열 a를 처음부터 스캔하면서 도수분포표를 만든다.
    ```java
    for(int i=0; i<n; i++)
        f[a[i]]++;
    ```

#### 2단계 누적도수분포표 만들기
* f의 두 번째 요소부터 바로 앞으 요솟값을 더하는 과정을 진행 한다.
    ```java
    for(int i=1; i<=max; i++)
        f[i] += f[i-1];
    ```

#### 3단계 목적 배열 만들기
* 이시점에서 정렬은 거의 마쳤다고 할수 있다. 남은 작업은 배열의 각 요솟값과 누적도수분포표 f를 대조하여 정렬을 마친 배열을 만드는 작업이다.
* 배열 a와 같은 요소의 개수를 갖는 작업용 배열b가 필요하다. 
* 배열 a의 요소를 마지막 위치부터 처음 위치까지 스캔하면서 배열 f와 대조하는 작업을 수행한다.
    ```java
    for(int i=n-1; i>=0; i--)
        b[--f[a[i]]] = a[i];
    ```
* a의 모든 요소를 배열 b에 알맞은 위치에 저장할 수 있다.

#### 4단계 배열 복사하기
* 정렬은 끝났지만 정렬 결과를 저장한 곳은 작업 배열 b이다. 배열 a는 정렬하기 전 상태 이므로 배열 b값을 배열 a로 복사 한다.
    ```java
    for(int i=0; i<n; i++)
        a[i] = b[i];
    ```
* 도수 정렬은 if문 대신 for문만을 사용해 정렬할 수 있는 알고리즘 이다. 
* 데이터의 비교, 교환 작업이 필요 없어 매우 빠르며, 단일 for문만을 사용하며 재귀호출, 이중 for문이 없어 아주 효율적인 알고리즘 이다.
* 단, 도수분포표가 필요하기 때문에 데이터의 최솟값과 최댓값을 미리 알고 있는 경우에만 사용할 수 있다.
> 도수 정렬 알고리즘을 구현한 fSort메서드는 배열 a에 저장하는 값이 0이상 max이하라는 전제하에 수행