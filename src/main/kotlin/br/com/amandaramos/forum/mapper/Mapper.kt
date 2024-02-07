package com.amandaramos.br.com.amandaramos.forum.mapper
//13 parte

/*Este trecho de código define uma interface chamada Mapper,
 que é parametrizada com dois tipos genéricos T e U. Esses tipos genéricos
 são usados para representar o tipo de entrada (T) e o tipo de saída (U) do
 método de mapeamento definido na interface.
 */
interface Mapper<T, U> {

    fun map(t: T): U

}

/*Resumidamente, essa interface Mapper é usada para definir um contrato para
classes que desejam mapear um tipo T para um tipo U, permitindo uma abstração
na implementação do mapeamento entre diferentes tipos de objetos. Isso pode ser
útil em cenários onde você precisa converter objetos de um tipo para outro,
como na serialização/deserialização de dados, mapeamento de entidades de banco
de dados para modelos de domínio, entre outros.*/