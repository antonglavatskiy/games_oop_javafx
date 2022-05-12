package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void whenPositionD8ThenD8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        Cell expected = Cell.D8;
        Cell result = bishopBlack.position();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenCopyH4ThenH4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        Figure copyBishopBlack = bishopBlack.copy(Cell.H4);
        Cell expected = Cell.H4;
        Cell result = copyBishopBlack.position();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenWayC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] result = bishopBlack.way(Cell.G5);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenWayB8ToF4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        Cell[] expected = {Cell.C7, Cell.D6, Cell.E5, Cell.F4};
        Cell[] result = bishopBlack.way(Cell.F4);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonalWayE6ToB2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E6);
        bishopBlack.way(Cell.B2);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonalWayH4ToC3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H4);
        bishopBlack.way(Cell.C3);
    }
}