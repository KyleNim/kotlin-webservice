package com.kyle.webservice

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.gson
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.main() {
    install(DefaultHeaders)
    install(Compression)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {
        get("/hello") {

            //            call.respondText("HelloWorld", ContentType.Text.Html)
            val model = Model("root", listOf(Item("A", "Apache"), Item("B", "Bing")))
            call.respond(model)
        }
    }

}

data class Item(val key: String, val value: String)
data class Model(val name: String, val items: List<Item>)