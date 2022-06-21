package com.muhsanapps.coroutinesandroid

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val resultList = mutableListOf<String>()

    val job1 = async {
        return@async doNetworkRequest(2)

    }

    val job2 = async {
        return@async doNetworkRequest(2)
    }

    resultList.add(job1.await())
    resultList.add(job2.await())

    println("Result is : $resultList")

    /* val job = launch(start = CoroutineStart.LAZY) {
         val result = doNetworkRequest()
         println(result)
     }

     delay(300)
     job.start()*/

   /* val resultList = mutableListOf<String>()
    val job1 = launch {
        val result = doNetworkRequest(1)
        resultList.add(result)
    }

    val job2 = launch {
        val result = doNetworkRequest(2)
        resultList.add(result)
    }

    job1.join()
    job2.join()

    println("Result is :  $resultList")*/

    println("runBlocking complete")
//    println("main starts")

//    runBlocking {
//        launch() {
//            val result = doNetworkRequest()
//            println(result)
//        }
//    }

    // val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
//        println("some work started")
//        delay(500)
//        println("work complete")

//        val result = doNetworkRequest()
//        println(result)
//    }

//    job.start()
    // job.join()

//    Thread.sleep(1000)


}

private suspend fun doNetworkRequest(number: Int): String {
    println("some work started")
    delay(500)
    return "network request $number complete"
}