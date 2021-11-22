#include <stdio.h>
#include <stdbool.h>

int N;
int M;
int arr[9] = {0,};
int unusedArr[9] = {0,};

void UnusedAscending(int N){
    int temp;
    for (int i = 0; i < N - 1; i++){
        for (int j = i + 1; j < N; j++){
            if(unusedArr[i] > unusedArr[j]){
                temp = unusedArr[i];
                unusedArr[i] = unusedArr[j];
                unusedArr[j] = temp;
            }
        }
    }
}

void Solve(int k){
    if (k == M){
        for(int i = 0; i < M; i++){
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    
    for (int i = 0; i < N; i++){
        if(unusedArr[i] != 0){
            arr[k] = unusedArr[i];
            unusedArr[i] = 0;
            Solve(k + 1);
            unusedArr[i] = arr[k];            
        }
    }
}

int main(){
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++){
        scanf("%d", &unusedArr[i]);
    }
    UnusedAscending(N);
    Solve(0);
}
