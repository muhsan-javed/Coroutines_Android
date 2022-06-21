package com.muhsanapps.coroutinesandroid

import kotlinx.coroutines.*

private val scope = CoroutineScope(Dispatchers.Default + CoroutineName("S100"))

fun main() {

    scope.launch(Dispatchers.IO) {
        println("c1 --- ")

        launch(CoroutineName("Inner 100")){
            println("c2 --- ${coroutineContext.get(CoroutineName.Key)}")

            launch(CoroutineName("Inner 1000")){
                println("c3 --- ${coroutineContext.get(CoroutineName.Key)}")

                launch {
                    println("c4 --- ${coroutineContext.get(CoroutineName.Key)}")
                }
            }
        }
    }


    Thread.sleep(1000)
    onDestroy()

}

private fun onDestroy() {
    println("cancelling scope")
    scope.cancel()
}









/*
fun main() {

    scope.launch(Dispatchers.IO) {
        println("c1 -- $this")
    }

    scope.launch(Dispatchers.IO) {
        println("c2 -- $this")
    }

    Thread.sleep(1000)
    onDestroy()

}

private fun onDestroy() {
    println("cancelling scope")
    scope.cancel()
}
*/


/*
fun main() {

    val job1 = scope.launch(Dispatchers.IO) {
        println("c1 started")
        delay(300)
        println("c1 complete")
    }

   */
/* val job2 = scope.launch(Dispatchers.IO) {
        println("c2 started")
        delay(200)
        println("c2 complete")
    }
   *//*

    job1.invokeOnCompletion {
        if (it is CancellationException)
            println("c1 is cancelled")
        else
            println("c1 is Complete")
    }
    Thread.sleep(200)
    onDestroy()

}
private fun onDestroy(){
    println("cancelling scope")
    scope.cancel()
}
*/


/*
fun main() {

    scope.launch(Dispatchers.IO) {
        println("c1 started")
        delay(300)
        println("c1 complete")

    }
    Thread.sleep(100)
    onDestroy()
}
private fun onDestroy(){
    println("cancelling scope")
    scope.cancel()
}
*/

//    println("$this")
//    println("$coroutineContext")


/*
fun main() {

    scope.launch(Dispatchers.IO + CoroutineName("C1000")) {
        println("$this")
        println("${coroutineContext[CoroutineName.Key]}")

    }
    Thread.sleep(1000)
}

//    println("$this")
//    println("$coroutineContext")*/
