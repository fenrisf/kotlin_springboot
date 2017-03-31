package com.fenrisf.controller

import com.fenrisf.model.Greeting
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

/**
 * Created by albertomartinez on 30/03/17.
 */
@RestController
class GreetingController {

    val counter = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }

    @RequestMapping("/greeting/{name}")
    fun greetingWithName(@PathVariable(value = "name") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}