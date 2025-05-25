package de.nebulit.events;

import java.util.UUID;

public record ItemAddedEvent(
    UUID aggregateId,
    String description,
    String image,
    Double price,
    UUID itemId,
    UUID productId
) { }
