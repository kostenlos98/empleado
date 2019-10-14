package test;

import modelo.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

/**
 * Los métodos anotados @BeforeClass y @AfterClass
 * se ejecutarán exactamente una vez durante la
 * ejecución de la prueba, al principio y al final
 * de la prueba en conjunto, antes de ejecutar cualquier
 * otra cosa. De hecho, se ejecutan antes de que la
 * clase de prueba se construya, por lo que deben
 * declararse estáticas.Los métodos @Before y @After
 * se ejecutarán antes y después de cada caso de prueba,
 * por lo que probablemente se ejecutarán varias veces
 * durante una ejecución de prueba.
 */

public class EmpleadoTestNoVacio
{
    Empleado empleado;
    
    public EmpleadoTestNoVacio()
    {
        empleado = new Empleado("12345678");
    }

    public static void main(String[] args)
    {
        String[] args2 =
        {
            EmpleadoTestVacio.class.getName()
        };
        JUnitCore.main(args);
    }

    @Before
    public void setUp() throws Exception
    {
        Hijo h1 = new Hijo("00000000", 2012,1 ,21); //<18
        Hijo h2 = new Hijo("11111111", 2014, 4, 5); //<18
        Hijo h3 = new Hijo("22222222", 1999, 9, 10); //<21 >18
        Hijo h4 = new Hijo("33333333", 2000, 1, 1); //<21 >18
        Hijo h5 = new Hijo("44444444", 1997, 5, 4); //>21
        Hijo h6 = new Hijo("55555555", 1991, 10, 10); //>21
        empleado.agregarHijo(h1);
        empleado.agregarHijo(h2);
        empleado.agregarHijo(h3);
        empleado.agregarHijo(h4);
        empleado.agregarHijo(h5);
        empleado.agregarHijo(h6);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    /**
     * @see Empleado#getIncremento(double)
     */
    @Test
    public void testGetIncrementoClaseEquivalencia()
    {
        double resultadoReal = empleado.getIncremento(32000.00);
        double resultadoEsperado = 11200.00;
        Assert.assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }
    
    /*
    @Test
    public void testGetIncrementoValoresLimites()
    {
    	double resultadoReal = empleado.getIncremento(100.00);
        double resultadoEsperado = 15;
        Assert.assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }
    */
}