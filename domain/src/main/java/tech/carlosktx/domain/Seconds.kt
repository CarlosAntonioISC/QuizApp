package tech.carlosktx.domain

@JvmInline
value class Seconds(val value: Int) {
    init {
        require(value <= 60)
    }
}

val Int.seconds
    get() = Seconds(this)