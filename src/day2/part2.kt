enum class COMMANDS(val commandId: Int) {
    FINISH(99),
    ADD(1),
    MULTIPLY(2)
}

enum class ASSISTS(val assistId: Int) {
    COMMAND_INDEX_JUMP(4),
    FIRST_POS(1),
    SECOND_POS(2),
    THIRD_POS(3)
}

fun printArray(input: Array<Int>) {
    print(input.contentToString())
}

fun runCommands(input: Array<Int>): Array<Int> {
    var index = 0
    while (index * ASSISTS.COMMAND_INDEX_JUMP.assistId < input.size) {
        val offSet = ASSISTS.COMMAND_INDEX_JUMP.assistId * index

        when (input[offSet]) {
            COMMANDS.ADD.commandId -> add(input, offSet)
            COMMANDS.MULTIPLY.commandId -> multiply(input, offSet)
            COMMANDS.FINISH.commandId -> {
                return input
            }
            else -> return input
        }
        index++
    }
    return arrayOf()
}

fun multiply(input: Array<Int>, offSet: Int) {
    input[input[offSet + ASSISTS.THIRD_POS.assistId]] =
        input[input[offSet + ASSISTS.FIRST_POS.assistId]] * input[input[offSet + ASSISTS.SECOND_POS.assistId]]
}

fun add(input: Array<Int>, offSet: Int) {
    input[input[offSet + ASSISTS.THIRD_POS.assistId]] =
        input[input[offSet + ASSISTS.FIRST_POS.assistId]] + input[input[offSet + ASSISTS.SECOND_POS.assistId]]
}

fun main() {

    for (noun in 0..99)
        for (verb in 0..99)
            if (runCommands(
                    arrayOf(
                        1,
                        noun,
                        verb,
                        3,
                        1,
                        1,
                        2,
                        3,
                        1,
                        3,
                        4,
                        3,
                        1,
                        5,
                        0,
                        3,
                        2,
                        13,
                        1,
                        19,
                        1,
                        9,
                        19,
                        23,
                        2,
                        23,
                        13,
                        27,
                        1,
                        27,
                        9,
                        31,
                        2,
                        31,
                        6,
                        35,
                        1,
                        5,
                        35,
                        39,
                        1,
                        10,
                        39,
                        43,
                        2,
                        43,
                        6,
                        47,
                        1,
                        10,
                        47,
                        51,
                        2,
                        6,
                        51,
                        55,
                        1,
                        5,
                        55,
                        59,
                        1,
                        59,
                        9,
                        63,
                        1,
                        13,
                        63,
                        67,
                        2,
                        6,
                        67,
                        71,
                        1,
                        5,
                        71,
                        75,
                        2,
                        6,
                        75,
                        79,
                        2,
                        79,
                        6,
                        83,
                        1,
                        13,
                        83,
                        87,
                        1,
                        9,
                        87,
                        91,
                        1,
                        9,
                        91,
                        95,
                        1,
                        5,
                        95,
                        99,
                        1,
                        5,
                        99,
                        103,
                        2,
                        13,
                        103,
                        107,
                        1,
                        6,
                        107,
                        111,
                        1,
                        9,
                        111,
                        115,
                        2,
                        6,
                        115,
                        119,
                        1,
                        13,
                        119,
                        123,
                        1,
                        123,
                        6,
                        127,
                        1,
                        127,
                        5,
                        131,
                        2,
                        10,
                        131,
                        135,
                        2,
                        135,
                        10,
                        139,
                        1,
                        13,
                        139,
                        143,
                        1,
                        10,
                        143,
                        147,
                        1,
                        2,
                        147,
                        151,
                        1,
                        6,
                        151,
                        0,
                        99,
                        2,
                        14,
                        0,
                        0
                    )
                )[0] == 19690720
            ) {
                print(noun*100+verb)
            }

}
