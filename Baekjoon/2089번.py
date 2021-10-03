import sys

n = int(sys.stdin.readline())

if n == 0:
    print(0)
else:
    res = []
    while n != 0:
        if n % (-2) == 0:
            res.append('0')
            n = n // (-2)
        else:
            res.append('1')
            n = n // (-2) + 1

    print(''.join(reversed(res)))
