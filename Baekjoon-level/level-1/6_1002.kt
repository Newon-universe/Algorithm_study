import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList

fun main (args:Array<String>){
   
   val br = BufferedReader(InputStreamReader(System.`in`))
   
   val (a,b) = br.readLine().split(' ').map { it.toInt() }
   
   println(a - b)
   
}
