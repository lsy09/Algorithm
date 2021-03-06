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

##[chapter12. TreeMap 클래스](#index)
> 이진 탐색 트리<sup>binary search tree, BST</sup>
> 요소가 정렬된 Map 인터페이스를 구현할때 유용하게 쓰인다.

### [12.1 해싱의 문제점](#index)
> 핵심 메서드의 성능 덕분에 HashMap 클래스는 널리 사용되지만, HashMap 클래스가 Map 인테페이스의 유일한 구현체는 아니다.   
* 다른 구현이 필요한 몇가지 이유가 있다.
    * HashMap 클래스의 연산이 상수 시간이라고 하더라도 해싱이 느릴 수 있습니다. 즉, 상수가 꽤 커질 수 있다.
    * 해시 함수가 하위 맵에 키를 고루 분배하면 해상은 잘 동작한다. 하지만 좋은 해시 함수를 설계하는 것은 쉬운 일이 아니다.        
    그리고 너무나 많은 키가 특정 하위 맵에 집중되면 HashMap의 성능이 나빠 질수 있다.
    * 해시 테이블에 있는 키는 어떤 순서대로 저장되지 않는다. 사실, 순서는 테이블이 커지고 키가 재해시될때 변하기도 한다.        
    어떤 응용 프로그램에서는 키를 순서대로 유지하는 것이 필요하거나 적어도 유용하다.
* 위의 모든 문제를 동시에 해결하긴 어렵지만, 자바는 거의 들어맞는 TreeMap 클래스를 제공한다.
    * TreeMap 클래스는 해시 함수를 사용하지 않는다. 따라서 해싱 비용과 해시 함수를 고르는 어려움을 피할수 있다.
    * TreeMap 클래스의 내부에서 키는 이진 탐색 트리에 저장되는데, 선형 시간으로 키를 순서대로 순회할 수 있다.
    * 핵심 메서드의 실행시간은 log n에 비례하며 상수 시간만큼 우수하지는 않지만, 여전히 꽤 쓸만하다.

### [12.2 이진 탐색 트리](#index)
> 이진 탐색 트리<sup>BST</sup>는 각 노드가 키를 포함한다.
* 노드의 속성
    1. 노드 왼쪽에 자식이 있다면 왼쪽 하위 트리의 모든 키는 노드에 있는 키보다 작다.
    2. 노드 오른쪽에 자식이 있다면 오른쪽 하위 트리의 모든 키는 노드에 키보다 크다.
    
[이진 탐색 트리 ](https://en.wikipedia.org/wiki/Binary_search_tree)
        
![이진 탐색 트리](/Binary_search_tree.png)
* 트리 전체를 검색 할 필요가 없어서 이진 탐색 트리에 있는 키의 검색 속도는 빠르다. 루트에서 시작하여 다음과 같은 알고리즘을 사용할 수 있다.
    1. 찾는 키인 target을 현재 노드위 키와 비교한다. 같으면 검색 종료
    2. target이 현재 키보다 작으면 왼쪽 트리를 검색한다. 왼쪽 트리에 없다면 target은 트리에 없다.
    3. target이 현재 키보다 크면 오른쪽 트리를 검색한다. 오른쪽 트리에 없다면 target은 트리에 없다.

* 트리의 각 수준에서 한 개씩의 자식 노드만 찾으면 된다.
    *  target


 
