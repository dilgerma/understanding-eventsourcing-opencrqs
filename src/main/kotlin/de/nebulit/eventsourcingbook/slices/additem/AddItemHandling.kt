package de.nebulit.eventsourcingbook.slices.additem

import com.opencqrs.framework.command.CommandEventPublisher
import com.opencqrs.framework.command.CommandHandlerConfiguration
import com.opencqrs.framework.command.CommandHandling
import com.opencqrs.framework.command.StateRebuilding
import de.nebulit.eventsourcingbook.common.CommandException
import de.nebulit.eventsourcingbook.events.ItemAddedEvent
import java.util.List


@CommandHandlerConfiguration
class AddItemHandling {
    @CommandHandling
    fun addItem(cart: Cart?, command: AddItemCommand, publisher: CommandEventPublisher<AddItemCommand?>): String {
        if (cart != null && !cart.items.contains(command.itemId.toString())) {
            throw CommandException("Item already exists")
        }
        publisher.publish(
            ItemAddedEvent(
                command.aggregateId,
                command.description,
                command.image,
                command.price,
                command.itemId,
                command.productId
            )
        )

        return command.aggregateId.toString()
    }

    @StateRebuilding
    fun on(cart: Cart?, event: ItemAddedEvent): Cart {
        if (cart == null) {
            return Cart(List.of(event.itemId.toString()))
        }
        return cart.with(event.itemId.toString())
    }
}