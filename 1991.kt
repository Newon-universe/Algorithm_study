import java.io.*
import java.util.*

var N = 0
var a = Array<Pair<Int,Int>>(26){Pair(0,0)}

fun preorder(n:Int){
    if (n==-1) {
        return
    }
    print('A'+n)
    preorder(a[n].first)
    preorder(a[n].second)
}

fun inorder(n:Int){
    if (n==-1) {
        return
    }
    else {
        inorder(a[n].first)
        print('A'+n)
        inorder(a[n].second)
    }
}

fun postorder(n:Int){
    if (n==-1) {
        return
    }
    else {
        postorder(a[n].first)
        postorder(a[n].second)
        print('A'+n)
    }
}
fun main() {
    val br = System.`in`.bufferedReader()
    
    N = br.readLine().toInt()
    
    repeat(N){
        val carr = br.readLine().split(' ').map{it[0]}
        
        var left = 
        if (carr[1]=='.') {
            -1
        } else {
            carr[1]-'A'
        }
        
        var right = 
        if (carr[2]=='.') {
            -1
        } else {
            carr[2]-'A'
        }
        
        a[carr[0]-'A'] = Pair(left,right)
    }
    
    preorder(0)
    println()
    inorder(0)
    println()
    postorder(0)
}
