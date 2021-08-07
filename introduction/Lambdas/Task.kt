fun containsEven(collection: Collection<Int>): Boolean =
        collection.any { e -> e % 2 == 0 }
