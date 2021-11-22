#include <stdio.h>
#include <stdbool.h>

int N;
int M;
int arr[10] = {0,};
int isusedArr[10] = {false,};

void Solve(int k){
    if (k == M){
        for (int i = 0; i < M; i++){
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    
    for (int i = 1; i <= N; i++){
        arr[k] = i;
        Solve(k + 1);
    }
}

int main(){
    scanf("%d %d", &N, &M);
    Solve(0);
}
