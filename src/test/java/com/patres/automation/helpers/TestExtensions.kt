package com.patres.automation.helpers

import io.kotest.matchers.beInstanceOf
import io.kotest.matchers.nulls.beNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot

fun <T> T.shouldNotBeNullAndCheck(block: T.() -> Unit) {
    this shouldNot beNull()
    block()
}

inline fun <reified T : Any> Any?.shouldBeInstanceOfAndCheck(block: T.() -> Unit): T {
    val matcher = beInstanceOf<T>()
    this shouldBe matcher
    block(this as T)
    return this
}