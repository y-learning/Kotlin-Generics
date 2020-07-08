abstract class Pet(val name: String)

class Cat(name: String = "") : Pet(name)

class Dog(name: String = "") : Pet(name)

class Fish(name: String = "") : Pet(name)

fun main() {
    val catFuzz = Cat("Fuzz Lightyear")
    val catKatsu = Cat("Katsu")
    val fishFinny = Fish("Finny McGraw")

    val conFuzz = Contestant(catFuzz, 50)
    val conKatsu = Contestant(catKatsu, 45)
    val conFinny = Contestant(fishFinny, 56)

    val catVet = Vet<Cat>()
    val fishVet = Vet<Fish>()
    val petVet = Vet<Pet>()

    catVet.treat(catFuzz)
    petVet.treat(catKatsu)
    petVet.treat(fishFinny)

    val catContest = contestFactory(listOf(conFuzz, conKatsu), catVet)
    val topCat = catContest.getWinners().first()
    println("Cat contest winner is ${topCat.name}")

    val petContest = contestFactory(listOf(conFinny, conFuzz), petVet)
    val topPet = petContest.getWinners().first()
    println("Pet contest winner is ${topPet.name}")

    val fishContest = contestFactory(listOf(conFinny), petVet)


    val catRetailer: Retailer<Pet> = CatRetailer()
    val dogRetailer: Retailer<Pet> = DogRetailer()
    val petRetailer: Retailer<Pet> = FishRetailer()

    catRetailer.sell()
    dogRetailer.sell()
    petRetailer.sell()
}
