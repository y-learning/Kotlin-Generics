data class Contestant<T : Pet>(val pet: T, val score: Int)

fun <T : Pet> addContestant(contest: Contest<T>, contestant: Contestant<out T>): Contest<T> {
    return contest.copy(scores = contest.scores.plus(contestant.pet to contestant.score))
}

private tailrec fun <T : Pet> makeContestIter(
    contestants: List<Contestant<out T>>,
    contest: Contest<T>
): Contest<T> {
    if (contestants.isEmpty()) return contest

    return makeContestIter(rest(contestants), addContestant(contest, contestants.first()))
}

fun <T : Pet> contestFactory(contestants: List<Contestant<out T>>, vet: Vet<in T>): Contest<T> =
    makeContestIter(rest(contestants), Contest(vet = vet))

data class Contest<T : Pet>(val scores: Map<T, Int> = mapOf(), val vet: Vet<in T>) {
    fun getWinners(): Set<T> {
        val maxScore = scores.values.max()
        return scores.filter { (_, score) -> score == maxScore }.keys
    }
}
