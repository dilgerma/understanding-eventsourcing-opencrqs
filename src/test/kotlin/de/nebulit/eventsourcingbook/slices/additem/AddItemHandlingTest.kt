package de.nebulit.eventsourcingbook.slices.additem

import com.opencqrs.framework.command.CommandHandlingTest
import com.opencqrs.framework.command.CommandHandlingTestFixture
import de.nebulit.common.support.RandomData
import de.nebulit.eventsourcingbook.events.ItemAddedEvent
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


@CommandHandlingTest
class AddItemHandlingTest {
    @Test
    fun canAddItem(@Autowired fixture: CommandHandlingTestFixture<Cart, AddItemCommand, String>) {

        val command = RandomData.newInstance<AddItemCommand> {  }

        fixture.givenNothing()
            .`when`(command)
            .expectSuccessfulExecution()
            .expectSingleEvent<ItemAddedEvent>(RandomData.newInstance {
                aggregateId = command.aggregateId
                description = command.description
                image = command.image
                price = command.price
                itemId = command.itemId
                productId = command.productId
            })
    }
}