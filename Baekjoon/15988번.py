d = [0]*1000001
d[0]=1;
d[1]=1;
d[2]=2;
for i in range(3,1000001):
    if d[i]==0:
        d[i] = d[i-1] + d[i-2] +d[i-3]
        d[i] %= 1000000009

for _ in range(int(input())):
    n=int(input())
    print(d[n])
