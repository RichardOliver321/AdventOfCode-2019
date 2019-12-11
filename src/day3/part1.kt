package day3

enum class direction(val indicador: Char) {
    LEFT('L'),
    RIGHT('R'),
    UP('U'),
    DOWN('D')
}

class Line(val startPoint: Point, val endPoint: Point)

class Point(val x: Int, val y: Int)

fun constructPoints(input: Array<String>, startingPoint: Point): ArrayList<Line> {

    input.map { newPoint ->

        var newX = 0
        var newY = 0
        when (newPoint[0]) {
            direction.LEFT.indicador -> newX = startingPoint.x - newPoint.substring(1).toInt()
            direction.RIGHT.indicador -> newX = startingPoint.x + newPoint.substring(1).toInt()
            direction.DOWN.indicador -> newY = startingPoint.y - newPoint.substring(1).toInt()
            direction.UP.indicador -> newY = startingPoint.y + newPoint.substring(1).toInt()
        }
        val newArrayList = arrayListOf(Line(startingPoint, Point(newX, newY)))

        newArrayList.addAll(constructPoints(input, Point(newX, newY)))
        return newArrayList
    }

    return arrayListOf()
}


fun main() {
    constructPoints(arrayOf("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"), Point(0, 0)).forEach { bob ->
        print("Start Point: ")
        print(bob.startPoint.x)
        print(" ")
        print(bob.startPoint.y)
        print(" ")
        print(bob.endPoint.x)
        print(" ")
        print(bob.endPoint.y)
        println()
    }
}


fun calcDistance() {


}
