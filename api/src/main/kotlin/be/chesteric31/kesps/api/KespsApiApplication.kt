package be.chesteric31.kesps.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KespsApiApplication

fun main(args: Array<String>) {
    runApplication<KespsApiApplication>(*args)
}