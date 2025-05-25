package de.nebulit.slices.additem;

import com.opencqrs.framework.command.Command;
import java.util.UUID;

public record AddItemCommand(
        UUID aggregateId,
        String description,
        String image,
        Double price,
        Double totalPrice,
        UUID itemId,
        UUID productId
) implements Command {

    @Override
    public String getSubject() {
        return "/"+aggregateId.toString();
    }
}
