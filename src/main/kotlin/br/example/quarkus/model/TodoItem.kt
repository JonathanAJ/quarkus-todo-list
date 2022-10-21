package br.example.quarkus.model

data class TodoItem(
    var id: String = "",
    var title: String = "",
    var description: String = ""
);