data class Contestant<T : Pet>(val pet: T, val score: Int)

fun <T : Pet> contestFactory(contestants: List<Contestant<out T>>, vet: Vet<in T>): Contest<T> {
    val map = contestants.map { it.pet to it.score }.toMap()
    return Contest(map, vet)
}

data class Contest<T : Pet>(val scores: Map<T, Int> = mapOf(), val vet: Vet<in T>) {
    fun getWinners(): Set<T> {
        val maxScore = scores.values.max()
        return scores.filter { (_, score) -> score == maxScore }.keys
    }
}
