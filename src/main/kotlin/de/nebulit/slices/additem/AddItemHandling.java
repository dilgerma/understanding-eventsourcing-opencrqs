package de.nebulit.slices.additem;

import com.opencqrs.framework.command.CommandEventPublisher;
import com.opencqrs.framework.command.CommandHandlerConfiguration;
import com.opencqrs.framework.command.CommandHandling;
import com.opencqrs.framework.command.StateRebuilding;
import de.nebulit.common.CommandException;
import de.nebulit.events.ItemAddedEvent;

import java.util.List;

@CommandHandlerConfiguration
public class AddItemHandling {

    @CommandHandling
    public String addItem(Cart cart, AddItemCommand command, CommandEventPublisher<AddItemCommand> publisher) {
        if (cart != null && !cart.items().contains(command.itemId().toString())) {
         throw new CommandException("Item already exists");
        }
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
    public Cart on(Cart cart, ItemAddedEvent event) {
        if (cart == null) {
            return new Cart(List.of(event.itemId().toString()));
        }
        return cart.with(event.itemId().toString());
    }
}