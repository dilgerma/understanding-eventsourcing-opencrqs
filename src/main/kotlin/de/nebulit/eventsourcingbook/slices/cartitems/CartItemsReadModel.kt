package de.nebulit.eventsourcingbook.slices.cartitems

import jakarta.persistence.ElementCollection
import jakarta.persistence.CollectionTable
import jakarta.persistence.JoinColumn
import jakarta.persistence.Entity
import jakarta.persistence.Column
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import jakarta.persistence.IdClass
import jakarta.persistence.Embeddable


import org.hibernate.annotations.JdbcTypeCode
import java.sql.Types
import java.util.UUID;


data class CartItemsReadModelQuery(
    var aggregateId: String,
)

@Embeddable
data class CartItemsReadModelKey(
    var aggregateId: String,
    var itemId: UUID
)

@IdClass(CartItemsReadModelKey::class)
@Entity
class CartItemsReadModelEntity {
    @Id
    @Column(name = "aggregateId")
    var aggregateId: String? = null;
    @Column(name = "description")
    var description: String? = null;
    @Column(name = "image")
    var image: String? = null;
    @Column(name = "price")
    var price: Double? = null;
    @Column(name = "totalPrice")
    var totalPrice: Double? = null;
    @Column(name = "productId")
    var productId: UUID? = null;
    @Id
    @Column(name = "itemId")
    var itemId: UUID? = null;
}

/*
Boardlink: https://miro.com/app/board/uXjVKvTN_NQ=/?moveToWidget=3458764595831018749
*/
data class CartItemsReadModel(val data: List<CartItemsReadModelEntity>)