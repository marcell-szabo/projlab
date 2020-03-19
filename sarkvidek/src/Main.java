


import data.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

    /**
     * tests for the data.Event class
     */
    public class EventTest {
        /**
         * tested event
         */
        private Event event;

        /**
         * creates test event
         */
        @Before
        public void setUp() {
            event = new Event("Teszt", LocalDate.of(1999, 3, 9), LocalTime.of(0,0),LocalTime.of(23,59), "asdf");
        }

        /**
         * tests the getters
         */
        @Test
        public void getTest(){
            Assert.assertEquals("Teszt", event.getName());
            Assert.assertEquals(LocalDate.of(1999,3,9), event.getDate());
            Assert.assertEquals(LocalTime.of(0,0), event.getBegin());
            Assert.assertEquals(LocalTime.of(23,59), event.getEnd());
            Assert.assertEquals("asdf", event.getNote());
        }

        /**
         * tests the setters
         */
        @Test
        public void setTest(){
            Assert.assertEquals("Teszt", event.getName());
            event.setName("Uj nev");

            Assert.assertEquals(LocalDate.of(1999,3,9), event.getDate());
            event.setDate(2019,12,1);
            Assert.assertEquals(LocalDate.of(2019,12,1), event.getDate());

            Assert.assertEquals(LocalTime.of(0,0), event.getBegin());
            event.setBegin(12,30);
            Assert.assertEquals(LocalTime.of(12,30), event.getBegin());

         



        }
    }


