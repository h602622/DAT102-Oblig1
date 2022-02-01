package no.hvl.dat102.adt;

// import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class KoeADTTest {

    private KoeADT<Integer> koe;

    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;

    protected abstract KoeADT<Integer> reset();

    @BeforeEach
    public void setup() {
        koe = reset();
    }

    @Test
    public void nyKoeErTom() {
        assertTrue(koe.erTom());
    }

    @Test
    public void innUtErTom() {
        koe.innKoe(e0);
        koe.innKoe(e1);
        koe.innKoe(e2);
        koe.innKoe(e3);

        try {
            assertEquals(e0, koe.utKoe());
            assertEquals(e1, koe.utKoe());
            assertEquals(e2, koe.utKoe());
            assertEquals(e3, koe.utKoe());
        } catch (EmptyCollectionException e) {
            fail("utKoe feilet uventet " + e.getMessage());
        }

        assertTrue(koe.erTom());
    }

    @Test
    public void innUtErTomDuplikat() {
        koe.innKoe(e0);
        koe.innKoe(e1);
        koe.innKoe(e1);
        koe.innKoe(e3);

        try {
            assertEquals(e0, koe.utKoe());
            assertEquals(e1, koe.utKoe());
            assertEquals(e1, koe.utKoe());
            assertEquals(e3, koe.utKoe());
        } catch (EmptyCollectionException e) {
            fail("utKoe feilet uventet " + e.getMessage());
        }

        assertTrue(koe.erTom());
    }

    @Test
    public void innErIkkeTom() {
        koe.innKoe(e0);
        koe.innKoe(e1);
        koe.innKoe(e2);
        koe.innKoe(e3);

        assertFalse(koe.erTom());
    }

    @Test
    public void utFraTom() {
        assertTrue(koe.erTom());
        assertThrows(EmptyCollectionException.class, () -> koe.utKoe());
    }

    @Test
    public void innFoersteErIkkeTom() {
        koe.innKoe(e0);

        try {
            assertEquals(e0, koe.foerste());
        } catch (EmptyCollectionException e) {
            fail("foerste feilet uventet " + e.getMessage());
        }

        assertFalse(koe.erTom());
    }

    @Test
    public void innInnInnFoersteFoersteFoerste() {
        koe.innKoe(e0);
        koe.innKoe(e1);
        koe.innKoe(e2);

        try {
            assertEquals(e0, koe.foerste());
            assert(!e1.equals(koe.foerste()));
            assert(!e2.equals(koe.foerste()));
        } catch (EmptyCollectionException e) {
            fail("foerste feilet uventet " + e.getMessage());
        }
    }
    
    @Test
    public void innFoersteUtErTom() {
        koe.innKoe(e0);

        try {
            assertEquals(e0, koe.foerste());
            assertEquals(e0, koe.utKoe());
        } catch (EmptyCollectionException e) {
            fail("foerste eller ut feilet uventet " + e.getMessage());
        }

        assertTrue(koe.erTom());
    }

}
