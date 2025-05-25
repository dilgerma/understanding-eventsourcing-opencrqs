package de.nebulit.eventsourcingbook.events

import de.nebulit.eventsourcingbook.common.Event
import java.util.UUID


/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764595631345609
*/
data class ItemRemovedEvent(
    var aggregateId:UUID,
	var itemId:UUID
) : Event
