package skeleton;

import java.util.*;

/**
 * Enumeration osztály, amely a meghívott függvények futása alatt bekövetkező eseményeket reprezentálja.
 * A legtöbb függvény visszatérési értéke ezen enumeráció értékei közül vesz fel egyet.
 */
enum Result {
    OK, WIN, DIE, NOTHING;
}