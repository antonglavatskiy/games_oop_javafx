package ru.job4j.chess.firuges.black;
import static java.lang.Math.abs;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > position.getX() ? 1 : -1;
        int deltaY = dest.getY() > position.getY() ? 1 : -1;
        int x = position.getX() + deltaX;
        int y = position.getY() + deltaY;
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(x + deltaX * i, y + deltaY * i);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return abs(source.getX() - dest.getX()) == abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
