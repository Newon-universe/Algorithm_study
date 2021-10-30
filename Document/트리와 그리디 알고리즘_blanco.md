## 트리

### 개념
* 트리(Tree)란, 배열, 링크드리스트, 스택, 큐와 같이 일직선 개념의 자료구조가 아니라 부모-자식 개념을 가지는 자료구조이다. 
 
* 스택과 큐는 자료구조에서 선형 구조. 선형 구조는 데이터가 순차적으로 나열되어진 형태를 말하는데, 트리는 비선형구조. 비선형구조는 데이터가 계층적(혹은 망)으로 구성 선형구조와 비선형구조의 차이점은 구성형태뿐만 아니라 용도에서도 차이점이 드러나는데, 선형구조는 자료를 저장하고 꺼내는 것에 초점이 맞춰져 있고, 비선형구조는 표현에 초점이 맞춰져 있다. 

* 보통 컴퓨터의 폴더 구조가 대표적인 트리의 형태를 가지고 있다.

### 트리 관련 용어

* 루트 노드(root node) : 트리에서 최상위 즉, 맨 위에 있는 노드를 

* 서브트리(Sub Tree) : 나머지 노드들

* 잎 노드(leaf node) : 더 이상 자식이 없는 노드를 

* 내부 노드(internal node) : 자식을 하나 이상 가지는 노드를 

* 레벨(level) : 루트 노드들로부터의 깊이를 뜻한다. (루트 노드의 레벨 = 1)

* 트리의 깊이(depth of tree) : 트리에 속한 노드의 최대 레벨을 뜻한다.

* 노드의 차수(degree) : 어떤 노드가 가지고 있는 자식 노드의 개수이다.

* 트리의 차수 : 트리가 가지고 있는 노드의 차수 중에서 가장 큰 값이다.

* Sibilings : 형제. 같은 부모를 가진 Child들을 뜻한다.

* Skew tree : 경사 트리. 모든 노드가 오직 한 개의 자식만을 가질 때를 뜻한다.

### 트리와 그래프의 차이
*  트리
1) 트리는 그래프의 특별한 케이스이며 "최소 연결 트리"라고도 불린다. 두 개의 정점 사이에 반드시 1개의 경로만을 가진다.

2) loop나 circuit이 없다. 당연히 self-loop도 없다.

3) 한 개의 루트 노드만이 존재하며 모든 자식노드는 한 개의 부모노드만을 가진다.

4) 부모-자식 관계이므로 흐름은 top-bottom 아니면 bottom-top으로 이루어진다.

5) 트리의 순회는 Pre-order, In-order 아니면 Post-order로 이루어진다. 이 3가지 모두 DFS/BFS안에 있다.

6) 트리는 DAG(Directed Acyclic Graphs)의 한 종류이다. DAG는 사이클이 없는 방향 그래프를 말한다.

7) 트리는 이진트리, 이진탐색트리, AVL 트리, 힙이 있다.

8) 간선은 항상 정점의개수-1 만큼을 가진다.

9) 트리는 계층 모델이다.

* 그래프

1) 2개 이상의 경로가 가능하다. 노드들 사이에 무방향/방향에서 양방향 경로를 가질 수 있다.

2) self-loop 뿐 아니라 loop/circuit 모두 가능하다.

3) 루트 노드라는 개념이 없다.

4) 부모-자식 관계라는 개념이 없다.

5) 그래프의 순회는 DFS나 BFS로 이루어진다.

6) 그래프는 Cyclic 혹은 Acyclic이다.

7) 그래프는 크게 방향 그래프와 무방향 그래프가 있다.

8) 간선의 유무는 그래프에 따라 다르다.

9) 그래프는 네트워크 모델이다.

## 이진트리

### 개념

이진 트리는 자식을 최대 2개까지만 가질 수 있는 트리이다.

### 이진트리 분류

* 완전 이진트리

  완전 이진트리는 높이가 k일때 레벨1부터 레벨 k-1까지는 노드가 모두 채워져 있고 레벨K부터는 왼쪽부터 오른쪽으로 순서대로 노드가 채워져있다. 마지막 레벨에 노드가 꽉 차 있지 않아도 되지만 중간에 빈 곳이 있어서는 안된다.

* 포화 이진트리

  포화 이진트리는 각 레벨에 노드가 꽉 차있는 노드를 의미한다. 포화 이진트리는 완전 이진트리에 속하지만 그 역은 성립되지 않는다.

* 정 이진 트리(full binary tree)
 
  정 이진 트리는 모든 노드가 0개 혹은 2개의 자식노드를 가지는 트리를 말한다. 포화 이진 트리의 하위종류이다.
 
* 편향 이진 트리(skewed binary tree)
 
  편향 이진 트리는 말 그대로 노드들이 전부 한 방향으로 편향된 트리이다.
 
* 이진 탐색 트리(binary search tree)
 
  이진 탐색 트리는 이진트리의 종류이긴 하지만 굉장히 중요하기 때문에 따로 빼서 정리하기로 한다.
이진트리이지만 왼쪽 자식노드가 루트노드보다 작고, 오른쪽 자식노드가 루트노드보다 큰 트리를 이진 탐색 트리라고 한다.

### 트리 표현법
* 배열표현법 :

  배열의 index를 이용하기
  이진 탐색 트리는 자식 노드가 최대 2개인 트리이다. 따라서, 어떤 노드가 x일때 자식 노드는 다음과 같이 x를 이용한 수식으로 나타낼 수 있다. 
  왼쪽 자식노드 : 2x, 오른쪽 자식노드: 2x+1
  
  ※ 이 방법을 이용하게 되면 배열의 index를 이용하기 때문에, 노드들이 오른쪽 자식 노드만 가지고 있는 skewed tree인 경우에는 쓸데없이 필요한 배열의 크기가 늘어날 수 있으므로 비효율적이다.
     이 방법은 이진 트리 중, node가 왼쪽부터 차곡차곡 채워지는 complete binary tree에 적용해야 공간의 낭비 없이 효율적으로 저장할 수 있다.
     
  이차원 배열 이용하기
  i번째 노드의 왼쪽 자식은 arr[i][0]에, 오른쪽 자식은 arr[i][1]에 저장하는 방법을 이용할 수 있다.
  
* 링크표현법

```kotlin
data class TreeNode<T>(
	var data: T,
    	var leftNode: TreeNode<T>?,
    	var rightNode: TreeNode<T>?
)
``` 

## 순회

### 개념

* 트리 순회(Tree traversal)는 트리 구조에서 각각의 노드를 정확히 한 번만, 체계적인 방법으로 방문하는 과정을 말한다. 이는 노드를 방문하는 순서에 따라 분류된다. 

### 종류
* 전위 순회(preorder) : 뿌리(root)를 먼저 방문한다. (왼쪽 자식 -> 오른쪽 자식)

* 중위 순회(inorder) : 왼쪽 하위 트리를 방문 후 뿌리(root)를 방문한다. 

* 후위 순회(postorder) : 하위 트리(왼쪽 자식 -> 오른쪽 자식) 모두 방문 후 뿌리(root)를 방문

```kotlin
class Node(val data: Char, val left: Node? = null, val right: Node? = null)
class Tree(val root: Node){
    //preorder 구현
    fun preorder(){
        fun preorderInternal(node:Node){
            print("${node.data} ")
            if(node.left!=null) preorderInternal(node.left)
            if(node.right!=null) preorderInternal(node.right)
        }
        preorderInternal(root)
        println()
    }
    //inorder 구현
    fun inorder(){
        fun inorderInternal(node:Node){
            if(node.left!=null) inorderInternal(node.left)
            print("${node.data} ")
            if(node.right!=null) inorderInternal(node.right)
        }
        inorderInternal(root)
        println()
    }
    //postorder구현
    fun postorder(){
        fun postorderInternal(node:Node){
            if(node.left!=null) postorderInternal(node.left)
            if(node.right!=null) postorderInternal(node.right)
            print("${node.data} ")
        }
        postorderInternal(root)
        println()
    }
}

fun main() {
    val tree = Tree(Node('A',Node('B',Node('D'),Node('E')),Node('C',Node('F'),Node('G'))))
    print("preorder result : ")
    tree.preorder()
    print("inorder result : ")
    tree.inorder()
    print("postorder result : ")
    tree.postorder()
}
/*결과:
preorder result : A B D E C F G 
inorder result : D B E A F C G 
postorder result : D E B F G C A
*/
```
## 그리디 알고리즘

### 개념
그리디 알고리즘(욕심쟁이 알고리즘, Greedy Algorithm)이란 "매 선택에서 지금 이 순간 당장 최적인 답을 선택하여 적합한 결과를 도출하자" 라는 모토를 가지는 알고리즘 설계 기법이다. 그리디 알고리즘은 탐욕적 선택조건(greedy choice property),최적 부분조건(optimal substructure) 특성을 가지는 문제들을 해결하는데 강점이 있다. 즉, 한번의 선택이 다음 선택에는 전혀 무관한 값이여야 하며 매 순간의 최적해가 문제에 대한 최적해여야 한다는 의미이다.

### 사용조건
<탐욕스러운 선택 조건 (Greedy choice property)>
앞의 선택이 이후의 선택에 영향을 주지 않는 조건.

<최적 부분 구조 조건(Optimal Substructure)>
문제에 대한 최종 해결 방법이 부분 문제에 대해서도 또한 최적 문제 해결 방법이다는 조건.

### 코드 예시

```kotlin
/* 문제1) 동전 문제
 * 1원, 50원, 100원, 500원 동전이 주어질 때, 가장 적게 지불하는 동전의 수를 구하기
 */
private fun Int.coinProblem(list: List<Int>) : Int {
	//외부로부터 숫자를 전달받을 때 항상 고정값이므로 Int.함수명을 이용

	//항상 최적을 따라야 하기 때문에 가장 큰 숫자부터 내림차순으로 정렬
	val coinList = list.sortedDescending()


    var coinCount = 0	// 전체 코인 수
    var money = this	// this는 Int.coinProblem을 뜻함
    var coinNum: Int	// 각각의 코인마다 소모된 수
    
    
    for(coin in coinList) {
        coinNum = money / coin
        coinCount += coinNum	

        money -= coinNum * coin	// 코인의 양 * 코인 
    }

    return coinCount
}
 

fun main() {
    val coinList = listOf(1,100,50,500)
    
    println(4720.coinProblem(coinList))
}
```
## 참고

(https://minoflower.tistory.com/4)
(https://velog.io/@kjh107704/%ED%8A%B8%EB%A6%AC-%ED%8A%B8%EB%A6%AC%EC%9D%98-%ED%91%9C%ED%98%84)
(https://genius-dev.tistory.com/entry/Kotlin%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Tree%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC-1)
