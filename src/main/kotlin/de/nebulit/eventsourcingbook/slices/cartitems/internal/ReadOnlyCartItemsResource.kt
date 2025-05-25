package de.nebulit.eventsourcingbook.slices.cartitems.internal

import de.nebulit.eventsourcingbook.slices.cartitems.CartItemsReadModel
import de.nebulit.eventsourcingbook.slices.cartitems.CartItemsReadModelQuery
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import mu.KotlinLogging
import java.util.concurrent.CompletableFuture
import org.springframework.web.bind.annotation.PathVariable


/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764595831018749
*/
@RestController
class CartitemsResource(
    private val queryHandler: CartItemsReadModelQueryHandler
) {

    var logger = KotlinLogging.logger {}

    @CrossOrigin
    @GetMapping("/cartitems/{aggregateId}")
    fun findReadModel(@PathVariable("aggregateId") aggregateId:String): CartItemsReadModel? {
        return queryHandler.handleQuery(CartItemsReadModelQuery(aggregateId))
    }

}
