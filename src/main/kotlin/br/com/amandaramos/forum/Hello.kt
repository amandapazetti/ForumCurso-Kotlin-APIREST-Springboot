package com.amandaramos.br.com.amandaramos.forum

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

class Hello {


    @RestController
    @RequestMapping("/hello")
    internal class HelloController {
        @GetMapping
        fun hello(): String {
            return "Hello Amanda"
        }
    }

}