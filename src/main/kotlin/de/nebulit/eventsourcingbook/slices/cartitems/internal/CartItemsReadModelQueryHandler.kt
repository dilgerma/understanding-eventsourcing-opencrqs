package de.nebulit.eventsourcingbook.slices.cartitems.internal

import de.nebulit.eventsourcingbook.slices.cartitems.CartItemsReadModel
import de.nebulit.eventsourcingbook.slices.cartitems.CartItemsReadModelQuery
import org.springframework.stereotype.Component


/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764595831018749
*/
@Component
class CartItemsReadModelQueryHandler(private val repository: CartItemsReadModelRepository) {

    fun handleQuery(query: CartItemsReadModelQuery): CartItemsReadModel? {


        return CartItemsReadModel(
            repository.findByAggregateId(query.aggregateId)
        )
    }

}

