interface Retailer<out T : Pet> {
    fun sell(): T
}