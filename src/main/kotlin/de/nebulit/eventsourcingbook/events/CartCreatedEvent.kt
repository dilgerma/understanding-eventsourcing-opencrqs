package de.nebulit.eventsourcingbook.events

import de.nebulit.eventsourcingbook.common.Event
import java.util.UUID


/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764596402400430
*/
data class CartCreatedEvent(
    var aggregateId:UUID
) : Event
