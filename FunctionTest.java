import org.junit.Test;
import static org.junit.Assert.*;

public class FunctionTest {

    @Test
    public void testVariable() {
        Variable x = new Variable();
        assertEquals(2.0, x.value(2.0), 0.0);
        assertEquals(new Number(1), x.derivative());
        assertEquals("x", x.toString());
        assertTrue(x.equals(new Variable()));
    }

    @Test
    public void testNumber() {
        Number n = new Number(3.0);
        assertEquals(3.0, n.value(2.0), 0.0);
        assertEquals(new Number(0), n.derivative());
        assertEquals("3.0", n.toString());
        assertTrue(n.equals(new Number(3.0)));
        assertFalse(n.equals(new Number(4.0)));
    }

    @Test
    public void testBinaryOp() {
        Function f1 = new BinaryOp(Operator.ADD, new Variable(), new Number(2.0));
        assertEquals(4.0, f1.value(2.0), 0.0);
        assertEquals(new Number(1), f1.derivative());
        assertEquals("x + 2.0", f1.toString());
        assertTrue(f1.equals(new BinaryOp(Operator.ADD, new Variable(), new Number(2.0))));
        assertFalse(f1.equals(new BinaryOp(Operator.ADD, new Variable(), new Number(3.0))));

        Function f2 = new BinaryOp(Operator.MULTIPLY, new Variable(), new Number(3.0));
        assertEquals(6.0, f2.value(2.0), 0.0);
        assertEquals(new Number(3.0), f2.derivative());
        assertEquals("x * 3.0", f2.toString());
        assertTrue(f2.equals(new BinaryOp(Operator.MULTIPLY, new Variable(), new Number(3.0))));
        assertFalse(f2.equals(new BinaryOp(Operator.MULTIPLY, new Variable(), new Number(4.0))));
    }

    @Test
    public void testPolynomial() {
        Function f = new Polynomial(new Variable(), 2.0);
        assertEquals(4.0, f.value(2.0), 0.0);
        assertEquals(new BinaryOp(Operator.MULTIPLY, new Number(2.0), new Variable()), f.derivative());
        assertEquals("x ^2.0", f.toString());
        assertTrue(f.equals(new Polynomial(new Variable(), 2.0)));
        assertFalse(f.equals(new Polynomial(new Variable(), 3.0)));
    }

    @Test
    public void testLog() {
        Function f = new Log(new Variable());
        assertEquals(Math.log(2.0), f.value(2.0), 0.0);
        assertEquals(new BinaryOp(Operator.DIVIDE, new Number(1), new Variable()), f.derivative());
        assertEquals("Exp[x]", f.toString());
        assertTrue(f.equals(new Log(new Variable())));
        assertFalse(f.equals(new Log(new Number(2.0))));
    }
}