package de.nebulit.eventsourcingbook.slices.additem

import com.opencqrs.framework.command.CommandHandlingTest
import com.opencqrs.framework.command.CommandHandlingTestFixture
import de.nebulit.common.support.RandomData
import de.nebulit.eventsourcingbook.events.ItemAddedEvent
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.UUID


@CommandHandlingTest
class AddItemHandlingTest {
    @Test
    fun canAddItem(@Autowired fixture: CommandHandlingTestFixture<Cart, AddItemCommand, String>) {

        // see: https://github.com/j-easy/easy-random/issues/397
        // val command = RandomData.newInstance<AddItemCommand> {  }
        val command = AddItemCommand(
            UUID.randomUUID(),
            "A description",
            "image.jpg",
            2.3,
            4.6,
            UUID.randomUUID(),
            UUID.randomUUID(),
        )

        fixture.givenNothing()
            .`when`(command)
            .expectSuccessfulExecution()
            .expectSingleEvent<ItemAddedEvent>(ItemAddedEvent(
                command.aggregateId(),
                command.description(),
                command.image(),
                command.price(),
                command.itemId(),
                command.productId()
            ))
    }
}