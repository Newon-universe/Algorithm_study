#include <stdio.h>
#include <stdbool.h>

int arr[10];
int isusedArr[10];
int N;
int M;

bool CheckAscending(){
    for (int i = 0; i < M - 2; i++){
        printf("working?");
        for (int j = i + 1; j < M - 1; j++){
            if(arr[i] > arr[j])
                return false;
        }
    }
    return true;
}

void Solve(int k){
    if (k == M && CheckAscending()){
        for (int i = 0; i < M; i++){
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    
    for (int i = 1; i <= N; i++){
        if(!isusedArr[i]){
            arr[k] = i;
            isusedArr[i] = true;
            Solve(k + 1);
            isusedArr[i] = false;
        }
    }
}

int main(){
    scanf("%d %d", &N, &M);
    Solve(0);
}
