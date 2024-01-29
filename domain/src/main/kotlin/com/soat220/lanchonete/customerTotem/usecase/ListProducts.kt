package com.soat220.lanchonete.customerTotem.usecase

import com.soat220.lanchonete.common.exception.DomainException
import com.soat220.lanchonete.common.model.Product
import com.soat220.lanchonete.common.result.Result
import com.soat220.lanchonete.common.result.Success
import com.soat220.lanchonete.common.result.orThrow
import com.soat220.lanchonete.erp.port.FindProductsPort
import javax.inject.Named

@Named
open class ListProducts(
    private val findProductsPort: FindProductsPort
) {
    open fun execute(): Result<List<Product>, DomainException> {
        val products = findProductsPort.execute().orThrow()

        return Success(products.filter { !it.deleted })
    }
}