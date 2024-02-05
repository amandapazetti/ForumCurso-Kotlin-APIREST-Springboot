package com.amandaramos.br.com.amandaramos.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}