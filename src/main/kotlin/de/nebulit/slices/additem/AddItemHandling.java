package de.nebulit.slices.additem;

import com.opencqrs.framework.command.CommandEventPublisher;
import com.opencqrs.framework.command.CommandHandlerConfiguration;
import com.opencqrs.framework.command.CommandHandling;
import de.nebulit.events.ItemAddedEvent;

@CommandHandlerConfiguration
public class AddItemHandling {

    @CommandHandling
    public String addItem(AddItemCommand command, CommandEventPublisher<AddItemCommand> publisher) {
        publisher.publish(
                new ItemAddedEvent(
                        command.aggregateId(),
                        command.description(),
                        command.image(),
                        command.price(),
                        command.itemId(),
                        command.productId()
                ));

        return command.aggregateId().toString();
    }

    @StateRebuilding
    public Book on(BookPurchasedEvent event) {
        return new Book(event.isbn(), event.numPages());
    }
}