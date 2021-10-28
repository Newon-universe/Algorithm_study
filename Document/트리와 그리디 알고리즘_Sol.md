## 트리

### 개념
![img](https://media.vlpt.us/images/keum0821/post/c4a3a6fe-adcf-4e48-9261-dcfd98f8201c/image.png)

위 그림처럼 노드끼리 부모-자식 관계를 갖는 자료구조를 트리라고 한다. 
하나의 노드가 2개 이상의 노드와 연결될 수 있지만 부모 노드만이 가능하다. 
같은 선상에 있는 형제노드끼리는 이어질 수 없다는 뜻이다.
위의 그림을 예로 들면, 6은 부모 노드로써 5와 11 노드와 연결되어 2개의 노드와 연결될 수 있지만, 2와는 연결될 수 없다.

### 트리 관련 용어

- 노드 : 하나 혹은 다수의 값을 가진 한 개의 저장공간이다. 정점이라고 하기도 한다.
- 간선 : 노드끼리 이어진 선을 뜻한다.
- 루트 노드 : 최상위 노드를 뜻한다. 최상위 노드기 때문에 당연히 부모 노드를 갖지 않는다.
- 잎 노드 : 자식이 없는 노드를 뜻한다. 최하위 노드들은 자식을 갖지 않기 때문에 루트 노드와 반대되는 개념이라고 착각할 수 있지만, 최하위가 아니더라도 자식을 갖지 않으면 잎 노드라고 한다.
- 내부 노드 : 자식을 하나 이상 갖는 노드들을 뜻한다. 루트 노드도 여기에 속한다.
- 조상 : 노드의 부모 노드들의 총 집합이다.
- 자손 : 노드의 서브트리에 있는 모든 노드들의 총 집합이다. 자신의 위로 부모 노드가 2개가 있는 노드들만 자손 노드가 된다.
- 레벨 : 루트 노드들로부터의 깊이를 뜻한다. (루트 노드의 레벨 = 1)
- 높이 : 깊이 라고도 한다. 트리에 속한 노드의 최대 레벨을 뜻한다. 위 그림의 트리의 높이는 4다.
- 차수 : 어떤 노드가 가지고 있는 자식 노드의 개수이다. 위 그림에서 6 노드의 차수는 2고, 9 노드의 차수는 1이다.

             
### 트리와 그래프의 차이
그래프는 형제 노드끼리도 이어질 수 있고, 하나의 자식노드가 두 개의 부모 노드를 가질 수도 있기 때문에 루프가 형성될 수 있는 구조다.
하지만 트리는 조건상 그럴 수 없다.

## 이진트리

### 개념
![img](https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/1920px-Binary_search_tree.svg.png)
자식을 최대 2개까지만 갖는 트리 구조를 뜻한다. 최대 2개기 때문에 하나를 가진 노드가 있을 수 있고, 하나도 갖지 않는 노드가 있을 수 있다.
              
              
### 이진트리 분류

- 이진 탐색 트리(Binary Search Tree) : 이진 트리에서 아래와 같은 조건을 갖는다.
1. 부모 자식 관계에서는 왼쪽 자식 노드가 부모 노드보다 작은 값이여야 하고, 오른쪽 자식 노드가 부모 노드보다 큰 값이여야 한다.
2. 꼭 부모 자식 관계에서 뿐만 아니라 위 그림을 보면 알 수 있듯 왼쪽에 위치한 값은 상대적으로 오른쪽에 있는 값보다 작다. 오른쪽에 위치한 값들은 그 반대다. 

그래서 오름차순까지는 아니지만 이런 조건들 안에서 마치 노드들이 정렬된 것 같은 구조를 갖고 있다.
그림 속 노드안에 쓰여진 숫자들은 탐색 순번 같은 개념이다. 탐색해야 할 자식 노드가 둘이라면, 상대적으로 작은 숫자부터 탐색하게 되므로 무조건 왼쪽에서 오른쪽으로 탐색하는 특징을 갖게 된다.
이게 위에서 복잡한 조건을 가지고 노드를 정렬하게 된 이유이다. 탐색에 일관성을 갖기 위한 목적정도로 이해하면 된다.

- 완전 이진 트리(Complete binary tree) : 마지막 레벨을 제외한 모든 서브트리의 레벨이 같아야 하고, 마지막 레벨은 왼쪽부터 채워져 있어야 한다. 
만약 자식을 하나만 갖는데 오른쪽에 위치하면 안된다는 뜻.

- 정 이진 트리(Full binary tree) : 자식 노드가 아예 없거나, 최대 둘뿐인 트리. 자식을 하나만 가진 노드가 없어야 한다.

- 포화 이진 트리(Perfect binary tree) : 완벽한 피라미드 형태. 빈공간 없이 루트 노드부터 내부 노드까지 모든 노드가 2개의 자식을 갖고있는 트리다.

### 트리 표현법

- 연결 리스트를 이용한 표현
트리는 그래프의 일종이기 때문에, 그래프의 표현 방법과 같이 연결 리스트로 저장할 수 있다.
이때, 트리의 경로는 방향이 있는 것이 아니기 때문에 양방향 그래프를 저장하는 방법을 사용하면 된다.
또한, 어떤 노드의 부모 노드를 아는 것은 전체 그래프에 대하여 다음과 같이 BFS나 DFS 탐색을 한 번 돌리면서 부모를 모두 저장하게 하면 그 다음부터는 바로바로 부모 노드에 접근할 수 있다.

- 이차원 배열을 이용한 표현
i번째 노드의 왼쪽 자식은 arr[i][0]에, 오른쪽 자식은 arr[i][1]에 저장하는 방법을 이용할 수 있다.



## 순회

### 개념
트리의 모든 노드들을 방문하는 과정이 순회다.

### 종류

- 전위 순회(preorder traverse) : 뿌리(root)를 먼저 방문

```Kotlin
class Node(val data: Char, val left: Node? = null, val right: Node? = null)

class Tree(val root: Node){
    //전위 순회 구현
    fun preorder(){
        fun preorderInternal(node:Node){
            print("${node.data} ")
            if(node.left!=null) preorderInternal(node.left)
            if(node.right!=null) preorderInternal(node.right)
        }
        preorderInternal(root)
        println()
    }
}

fun main() {
    val tree = Tree(Node('A',Node('B',Node('D'),Node('E')),Node('C',Node('F'),Node('G'))))
    print("preorder result : ")
    tree.preorder()
}
```

- 중위 순회(inorder traverse) : 왼쪽 하위 트리를 방문 후 뿌리(root)를 방문

```Kotlin
class Node(val data: Char, val left: Node? = null, val right: Node? = null)

class Tree(val root: Node){
    // 중위 순회 구현
    fun inorder(){
        fun inorderInternal(node:Node){
            if(node.left!=null) inorderInternal(node.left)
            print("${node.data} ")
            if(node.right!=null) inorderInternal(node.right)
        }
        inorderInternal(root)
        println()
    }
}

fun main() {
    val tree = Tree(Node('A',Node('B',Node('D'),Node('E')),Node('C',Node('F'),Node('G'))))
    print("inorder result : ")
    tree.inorder()
}
```

- 후위 순회(postorder traverse) : 하위 트리 모두 방문 후 뿌리(root)를 방문

```Kotlin
class Node(val data: Char, val left: Node? = null, val right: Node? = null)

class Tree(val root: Node){
    // 후위 순회 구현
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

    print("postorder result : ")
    tree.postorder()
}
```


## 그리디 알고리즘

### 개념
미래를 생각하지 않고 각 단계에서 가장 최선의 선택을 하는 알고리즘 기법이다.
마시멜로 실험이 가장 대표적인 예시인데, 마시멜로 1개를 먹지 않고 5분만 기다리면 1개를 더 얹어 2개를 먹을 수 있는 상황임에도
일단 먹고 뒤는 보지 않는 것을 택하는 알고리즘이다.
여기서 핵심은 기다렸어야지 가 아니라, 각 단계에서 최선의 선택을 하는 것이 궁극적으로 최적의 결과를 가져오지는 못한다는 점이다.
마라톤으로 간단한 예를 하나 더 들지면, 당장 전력질주 하는 것이 짧은 시간 동안은 선두를 유지할 수 있으니까 최선의 선택일지 몰라도, 장기적으로 봤을 때 그건 좋은 선택이 아니라는걸 누구나 안다.
선두가 되기 위해서 당장은 전력질주를 하는게 맞지만(현재에서 최선의 선택), 가능한 최고 성적(최적의 해)은 낼 수 없는 이치와 같다.


### 사용조건
위의 조건때문에 그리디 알고리즘을 적절하게 사용하기 위해서는 아래 2가지 조건의 문제상황에서만 최적의 해를 얻어낼 수 있다.

- 탐욕적 선택조건 : 앞의 선택이 이후의 선택에 영향을 주지 않는 경우. 그러려면 문제 상황 속 모든 객체들이 독립적으로 서로 변수를 창출하지 않아야 한다.

- 최적 부분 조건 : 문제에 대한 최적해가 부분문제에 대해서도 역시 최적해인 경우. 최적해만 모인다면 당연히 결과도 최적해일 수 밖에 없다.

### 코드 예시
```Kotlin
// 1원, 50원, 100원, 500원 동전이 주어질 때, 가장 적게 지불하는 동전의 수를 구하기

private fun Int.coinProblem(list: List<Int>) : Int {

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

- https://velog.io/@keum0821/%ED%8A%B8%EB%A6%AC%EC%9D%98-%EA%B0%9C%EB%85%90%EA%B3%BC-%EC%9D%B4%EC%A7%84-%ED%8A%B8%EB%A6%AC
- https://medium.com/depayse/kotlin-data-structure-tree-b8518d233f9d
- https://minoflower.tistory.com/4
