package de.nebulit.eventsourcingbook.events

import de.nebulit.eventsourcingbook.common.Event
import java.util.UUID


/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764595641022551
*/
data class ItemArchivedEvent(
    var aggregateId:UUID,
	var itemId:UUID
) : Event
