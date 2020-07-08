data class Vet<T : Pet>(val name: String = "Vet") {
    fun treat(pet: T) {
        println("Treat pet ${pet.name}")
    }
}