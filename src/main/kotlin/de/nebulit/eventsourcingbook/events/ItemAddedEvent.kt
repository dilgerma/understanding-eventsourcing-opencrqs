package de.nebulit.eventsourcingbook.events

import de.nebulit.eventsourcingbook.common.Event
import java.util.UUID


/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764595631345476
*/
data class ItemAddedEvent(
    var aggregateId:UUID,
	var description:String,
	var image:String,
	var price:Double,
	var itemId:UUID,
	var productId:UUID
) : Event
