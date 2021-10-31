import sys

N = int(input())
tree = {} #트리를 간단하게 사전으로 표현 , { A : [B,C]}

for i in range(N):
    root,left,right = sys.stdin.readline().strip().split()
    tree[root] = [left,right]


def preorder(root):
    if root != '.':
        print(root,end='')
        preorder(tree[root][0]) #left
        preorder(tree[root][1]) #right


def inorder(root):
    if root != '.':
        inorder(tree[root][0]) #left
        print(root,end='') #root, 데이터가 있으면 뽑음
        inorder(tree[root][1]) #right


def postorder(root):
    if root != '.':
        postorder(tree[root][0]) #left
        postorder(tree[root][1]) #right
        print(root,end='')


preorder('A')
print()
inorder('A')
print()
postorder('A')
