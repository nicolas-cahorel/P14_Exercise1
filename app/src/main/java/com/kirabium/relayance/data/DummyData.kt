package com.kirabium.relayance.data

import com.kirabium.relayance.domain.model.Customer

object DummyData {
    val customers = listOf(
        Customer(1, "Alice Wonderland", "alice@example.com"),
        Customer(2, "Bob Builder", "bob@example.com"),
    )
}