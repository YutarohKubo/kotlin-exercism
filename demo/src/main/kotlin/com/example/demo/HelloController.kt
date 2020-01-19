package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class HelloController {

    @RequestMapping(value = ["/hello"], method = [RequestMethod.GET])
    @ResponseBody
    fun hello_world(): String {
        return "hello, world"
    }

    @RequestMapping(value = ["/hello/{name}"], method = [RequestMethod.GET])
    fun hello_name(@PathVariable name: String, model: Model): String {
        model.addAttribute("name", name)
        return "hello_name" // Thymeleaf テンプレートファイル名
    }

}