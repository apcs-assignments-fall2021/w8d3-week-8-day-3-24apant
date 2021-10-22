import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {
    @Test
    public void testIsSimplified() {
        assertEquals(true, new Rational(1,2).isSimplified(), "The output of checking if the Rational 1/2 is simplified should be: true");
        assertEquals(true, new Rational(2,3).isSimplified(), "The output of checking if the Rational 2/3 is simplified should be: true");
        assertEquals(false, new Rational(2,4).isSimplified(), "The output of checking if the Rational 2/4 is simplified should be: false");
        assertEquals(false, new Rational(4,2).isSimplified(), "The output of checking if the Rational 4/2 is simplified should be: false");
    }

    @Test
    public void testCalculateDoubleValue() {
        assertEquals(1.5, new Rational(3,2).calculateDecimalValue(), 0.01, "The output of calculating the double value of the Rational 3/2 is simplified should be: 1.5");
        assertEquals(0.25, new Rational(1,4).calculateDecimalValue(), 0.01, "The output of calculating the double value of the Rational 1/4 is simplified should be: 0.25");
    }

    @Test
    public void testPow() {
        assertEquals("1/4", new Rational(1,2).pow(2).toString(), "The output of raising the Rational 1/2 to the power of 2 should be: 1/4");
        assertEquals("1/16", new Rational(1,4).pow(2).toString(), "The output of raising the Rational 1/4 to the power of 2 should be: 1/16");
        assertEquals("125/216", new Rational(5,6).pow(3).toString(), "The output of raising the Rational 5/6 to the power of 3 should be: 125/216");
    }

    @Test
    public void testContains() {
        assertEquals(true, new Rational(1,2).contains(2), "The output of checking if the Rational 1/2 contains the number 2 should be: true");
        assertEquals(true, new Rational(2,1).contains(2), "The output of checking if the Rational 2/1 contains the number 2 should be: true");
        assertEquals(false, new Rational(2,1).contains(3), "The output of checking if the Rational 2/1 contains the number 3 should be: false");
        assertEquals(false, new Rational(2,1).contains(3), "The output of checking if the Rational 2/1 contains the number 3 should be: false");
    }

    @Test
    public void testIncrement() {
        Rational r = new Rational(3,8);
        r.increment();
        assertEquals("11/8", r.toString(), "Incrementing 3/8 should give the result: 11/8");
        Rational s = new Rational(3,2);
        s.increment();
        assertEquals("5/2", s.toString(), "Incrementing 3/2 should give the result: 5/2");
    }

    @Test
    public void testDecrement() {
        Rational r = new Rational(11,8);
        r.decrement();
        assertEquals("3/8", r.toString(), "Incrementing 11/8 should give the result: 3/8");
        Rational s = new Rational(5,2);
        s.decrement();
        assertEquals("3/2", s.toString(), "Incrementing 5/2 should give the result: 3/2");
    }

    @Test
    public void testChangeToEquivalentFraction() {
        Rational r = new Rational(3,8);
        r.changeToEquivalentFraction(64);
        assertEquals("24/64", r.toString(), "The equivalent fraction of 3/8 with the base 64 is: 24/64");
        Rational s = new Rational(1,2);
        s.changeToEquivalentFraction(100);
        assertEquals("50/100", s.toString(), "The equivalent fraction of 1/2 with the base 100 is: 50/100");
        Rational t = new Rational(16,8);
        t.changeToEquivalentFraction(4);
        assertEquals("8/4", t.toString(), "The equivalent fraction of 16/8 with the base 4 is: 16/4");
    }

    // Homework Methods

    @Test
    public void testIsNegative() {
        assertEquals(false, new Rational(1,2).isNegative(), "The output of checking if the Rational 1/2 is negative should be: false");
        assertEquals(true, new Rational(-1,2).isNegative(), "The output of checking if the Rational -1/2 is negative should be: true");
        assertEquals(true, new Rational(1,-2).isNegative(), "The output of checking if the Rational 1/-2 is negative should be: true");
        assertEquals(false, new Rational(-1,-2).isNegative(), "The output of checking if the Rational -1/-2 is negative should be: false");
    }

    @Test
    public void testReciprocal() {
        assertEquals("1/2", new Rational(2,1).reciprocal().toString(), "The reciprocal of the Rational 2/1 is: 1/2");
        assertEquals("3/2", new Rational(2,3).reciprocal().toString(), "The reciprocal of the Rational 2/3 is: 3/2");
    }

    @Test
    public void testEquals() {
        assertEquals(false, new Rational(1,2).equals(new Rational(1, 3)), "The output of checking if the Rational 1/2 equals the Rational 1/3 should be: false");
        assertEquals(false, new Rational(2,3).equals(new Rational(1, 3)), "The output of checking if the Rational 2/3 equals the Rational 1/3 should be: false");
        assertEquals(true, new Rational(2,3).equals(new Rational(2, 3)), "The output of checking if the Rational 2/3 equals the Rational 2/3 should be: true");
    }

    @Test
    public void testRound() {
        Rational r = new Rational(19,8);
        r.round();
        assertEquals("2/1", r.toString(), "Rounding 19/8 should give the result: 2/1");
        Rational s = new Rational(4,10);
        s.round();
        assertEquals("0/1", s.toString(), "Rounding 4/10 should give the result: 0/1");
        Rational t = new Rational(5,10);
        t.round();
        assertEquals("1/1", t.toString(), "Rounding 5/10 should give the result: 1/1");
    }
}
