#include <stdio.h>
#include <stdbool.h>

int N;
int M;
int arr[10] = {0, };

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
        if (k > 0 && arr[k - 1] > arr[k]){
            arr[k] = 0;
            continue;
        }
        Solve(k + 1);
    }
}

int main(){
    scanf("%d %d", &N, &M);
    Solve(0);
}
