package de.nebulit.eventsourcingbook.slices.additem;

import java.util.ArrayList;
import java.util.List;

public record Cart(List<String> items) {

    public Cart with(String item) {
        List<String> newItems = new ArrayList<>(this.items());
        newItems.add(item);
        return new Cart(List.copyOf(newItems));    }
}