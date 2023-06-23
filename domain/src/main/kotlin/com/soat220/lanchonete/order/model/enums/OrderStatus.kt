package com.soat220.lanchonete.order.model.enums

enum class OrderStatus(val code: Int) {
    RECEIVED(0),
    IN_PREPARATION(1),
    READY(2),
    COMPLETED(3)
}