#include <stdio.h>
#include <stdbool.h>

int arr[1001][1001] = {0, };
int DFSvisit[1001] = {0, };
int BFSvisit[1001] = {0, };
int Queue[1001] = {0, };
int N;

void Init(int M){
    int X, Y;
    for (int i = 0; i < M; i++){
        scanf("%d %d", &X, &Y);
        arr[X][Y] = 1;
        arr[Y][X] = 1;
    }
}

void DFS(int depth){
    DFSvisit[depth] = 1;
    printf("%d ", depth);
    
    for (int i = 1; i <= N; i++){
        if(arr[depth][i] == 1 && DFSvisit[i] == 0){
            DFS(i);
        }
    }
    return;
}

void BFS(int position){
    int front = 0;
    int rear = 0;
    int enqueue;
    
    Queue[0] = position;
    rear++;
    BFSvisit[position] = 1;
    
    while(front < rear){
        printf("%d ", Queue[front]);
        enqueue = Queue[front];
        front++;
        
        for (int i = 1; i <= N; i++){
            if(arr[enqueue][i] == 1 && BFSvisit[i] == 0){
                Queue[rear] = i;
                rear++;
                BFSvisit[i] = 1;
            }
        }
    }
    
    return;
}

int main(){
    int M;
    int V;
    scanf("%d %d %d", &N, &M, &V);
    Init(M);
    DFS(V);
    printf("\n");
    BFS(V);
}
