class Robot {

    private Orientation orientation;
    private GridPosition gridPosition;

    Robot(GridPosition initialPosition, Orientation initialOrientation) {
        this.gridPosition = initialPosition;
        this.orientation = initialOrientation;
    }

    GridPosition getGridPosition() {
        return gridPosition;
    }

    Orientation getOrientation() {
        return orientation;
    }

    void advance() {
        this.gridPosition = switch (orientation) {
            case NORTH -> new GridPosition(this.gridPosition.x, this.gridPosition.y + 1);
            case SOUTH -> new GridPosition(this.gridPosition.x, this.gridPosition.y - 1);
            case EAST -> new GridPosition(this.gridPosition.x + 1, this.gridPosition.y);
            case WEST -> new GridPosition(this.gridPosition.x - 1, this.gridPosition.y);
        };
    }

    void turnLeft() {
        this.orientation = switch (orientation) {
            case NORTH -> Orientation.WEST;
            case SOUTH -> Orientation.EAST;
            case EAST -> Orientation.NORTH;
            case WEST -> Orientation.SOUTH;
        };
    }

    void turnRight() {
        this.orientation = switch (orientation) {
            case NORTH -> Orientation.EAST;
            case SOUTH -> Orientation.WEST;
            case EAST -> Orientation.SOUTH;
            case WEST -> Orientation.NORTH;
        };
    }

    void simulate(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'A') {
                this.advance();
            } else if (instruction == 'L') {
                this.turnLeft();
            } else if (instruction == 'R') {
                this.turnRight();
            }
        }
    }

}