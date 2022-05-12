package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KnightBlack;
import ru.job4j.chess.firuges.white.KnightWhite;
import ru.job4j.chess.firuges.white.RookWhite;

public class LogicTest {

    @Test
    public void whenRegularMoveC1ToH6()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveG1ToD4WithOccupiedE3()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G1));
        logic.add(new KnightBlack(Cell.E3));
        logic.move(Cell.G1, Cell.D4);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveD1ToE3WithImpossibleRules()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D1));
        logic.move(Cell.D1, Cell.E3);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenWithoutFigureMoveF8ToE7()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.D1, Cell.E3);
    }

    @Test
    public void whenWithoutOccupiedMoveA7ToD4()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new RookWhite(Cell.A1));
        logic.add(new KnightWhite(Cell.B1));
        logic.add(new BishopBlack(Cell.A7));
        logic.move(Cell.A7, Cell.D4);
    }
}