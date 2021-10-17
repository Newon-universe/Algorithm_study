#include <stdio.h>
#include <stdbool.h>
#include <math.h>

int N;
int ability[21][21] = {0, };
bool check[22];
int result = 100;

void Init(){
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            scanf("%d", &ability[i][j]);
        }
    }
}

void DFS(int k, int pos){
    if(k == N/2){
        int start = 0;
        int link = 0;
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(check[i] == true && check[j] == true)
                    start += ability[i][j];
                if(check[i] == false && check[j] == false)
                    link += ability[i][j];
            }
        }
        int temp = abs(start - link);
        if(temp < result)
            result = temp;
        
        return;
    }
    
    for(int i = pos; i < N; i++){
        check[i] = true;
        DFS(k + 1, i + 1);
        check[i] = false;
    }
}
    
int main(){
    scanf("%d", &N);
    Init();
    DFS(0, 1);
    printf("%d", result);
}
