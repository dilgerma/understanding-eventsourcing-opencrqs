package de.nebulit.eventsourcingbook.slices.cartitems.internal


import com.opencqrs.framework.eventhandler.EventHandling
import de.nebulit.eventsourcingbook.events.ItemAddedEvent
import de.nebulit.eventsourcingbook.slices.cartitems.CartItemsReadModel
import de.nebulit.eventsourcingbook.slices.cartitems.CartItemsReadModelEntity
import de.nebulit.eventsourcingbook.slices.cartitems.CartItemsReadModelKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

interface CartItemsReadModelRepository : JpaRepository<CartItemsReadModelEntity, CartItemsReadModelKey> {
    fun findByAggregateId(aggregateId: String): List<CartItemsReadModelEntity>
}

/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764595831018749
*/
@Component
class CartItemsReadModelProjector(
    var repository: CartItemsReadModelRepository
) {


    @EventHandling("cartitems")
    fun on(event: ItemAddedEvent) {
        CartItemsReadModelEntity().apply {
            aggregateId = event.aggregateId.toString()
            description = event.description
            image = event.image
            price = event.price
            totalPrice = event.price
            productId = event.productId
            itemId = event.itemId
        }.also { this.repository.save(it) }
    }

}
