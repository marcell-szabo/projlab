package game;

import java.util.*;

/**
 * Enumeration osztály, amely a meghívott függvények futása alatt bekövetkezõ eseményeket reprezentálja.
 * A legtöbb függvény visszatérési értéke ezen enumeráció értékei közül vesz fel egyet.
 */
public enum Result {
    OK, WIN, DIE, NOTHING, DISAPPEAR;
}