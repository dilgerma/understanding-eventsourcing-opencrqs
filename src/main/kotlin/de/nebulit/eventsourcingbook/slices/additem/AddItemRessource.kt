package de.nebulit.eventsourcingbook.slices.additem

import com.opencqrs.framework.command.CommandRouter
import mu.KotlinLogging
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

data class AddItemPayload(
    var aggregateId: UUID,
    var description: String,
    var image: String,
    var price: Double,
    var totalPrice: Double,
    var itemId: UUID,
    var productId: UUID,
)

@RestController
class AddItemRessource(private var commandRouter: CommandRouter) {

    var logger = KotlinLogging.logger {}

    @CrossOrigin
    @PostMapping("/debug/additem")
    fun processDebugCommand(
        @RequestParam aggregateId: UUID,
        @RequestParam description: String,
        @RequestParam image: String,
        @RequestParam price: Double,
        @RequestParam totalPrice: Double,
        @RequestParam itemId: UUID,
        @RequestParam productId: UUID,
    ): Any {
        return commandRouter.send(
            AddItemCommand(aggregateId, description, image, price, totalPrice, itemId, productId),
        )
    }

    @CrossOrigin
    @PostMapping("/additem/{aggregateId}")
    fun processCommand(
        @PathVariable("aggregateId") aggregateId: UUID,
        @RequestBody payload: AddItemPayload,
    ): Any {
        return commandRouter.send(
            AddItemCommand(
                payload.aggregateId,
                payload.description,
                payload.image,
                payload.price,
                payload.totalPrice,
                payload.itemId,
                payload.productId,
            ),
        )
    }
}
