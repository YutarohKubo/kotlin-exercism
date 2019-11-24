class Robot {

    var gridPosition: GridPosition
    var orientation: Orientation

    constructor(): this(GridPosition(0, 0), Orientation.NORTH)

    constructor(position: GridPosition, orientation: Orientation) {
        this.gridPosition = position
        this.orientation = orientation
    }

    fun advance() = when (orientation) {
        Orientation.NORTH -> {
            gridPosition.y += 1
        }
        Orientation.SOUTH -> {
            gridPosition.y -= 1
        }
        Orientation.WEST -> {
            gridPosition.x -= 1
        }
        Orientation.EAST -> {
            gridPosition.x += 1
        }
    }

    fun turnLeft()  = when (orientation) {
        Orientation.NORTH -> {
            orientation = Orientation.WEST
        }
        Orientation.SOUTH -> {
            orientation = Orientation.EAST
        }
        Orientation.WEST -> {
            orientation = Orientation.SOUTH
        }
        Orientation.EAST -> {
            orientation = Orientation.NORTH
        }
    }

    fun turnRight() = when (orientation) {
        Orientation.NORTH -> {
            orientation = Orientation.EAST
        }
        Orientation.SOUTH -> {
            orientation = Orientation.WEST
        }
        Orientation.WEST -> {
            orientation = Orientation.NORTH
        }
        Orientation.EAST -> {
            orientation = Orientation.SOUTH
        }
    }

    fun simulate(instructions: String) {
        for (ch in instructions) {
            when (ch) {
                'A' -> advance()
                'L' -> turnLeft()
                'R' -> turnRight()
                else -> IllegalArgumentException()
            }
        }
    }
}
