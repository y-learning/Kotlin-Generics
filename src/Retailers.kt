data class CatRetailer(val catNum: Int = 50) : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell a cat")
        return Cat()
    }
}

data class DogRetailer(val catNum: Int = 30) : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell a dog")
        return Dog()
    }
}

data class FishRetailer(val catNum: Int = 60) : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell a fish")
        return Fish()
    }
}