package com.soat220.lanchonete.erp.usecase

import com.soat220.lanchonete.common.exception.DomainException
import com.soat220.lanchonete.common.model.Product
import com.soat220.lanchonete.common.result.Result
import com.soat220.lanchonete.erp.port.FindProductsPort
import javax.inject.Named

@Named
open class FindProducts(
    private val findProductsPort: FindProductsPort
) {
    open fun execute(): Result<List<Product>, DomainException> {
        return findProductsPort.execute()
    }
}