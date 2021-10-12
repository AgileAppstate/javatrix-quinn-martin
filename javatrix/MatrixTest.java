package javatrix;

import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * junit5 test class.
 * MatrixTest.java
 * @author Quinn Corcoran
 * @author Martin Hernandez-gamez
 * @version Fall 2021
*/

public class MatrixTest {


	@Test
	public void test2Dconst1()
	{
		double[][] vals = {{1.,2.,3.},{4.,5.,6.},{7.,8.,9.}};
		Matrix A = new Matrix(vals);
		assertEquals(3, A.getCols());
		assertEquals(3, A.getRows());
		assertEquals(2., A.getMatrixPos(0, 1));
		assertEquals(6., A.getMatrixPos(1, 2));
		assertEquals(7., A.getMatrixPos(2, 0));
		assertArrayEquals(vals, A.getMatrix());
	}

	@Test
	//Test for failure
	public void test2Dconst2()
	{
		Throwable exception = assertThrows(IllegalArgumentException.class, new Executable()
		{
			@Override
			public void execute() throws Throwable 
			{
				double[][] vals = {{1.,2.,3.,.4},{5.,6.},{7.}};
				Matrix A = new Matrix(vals);
			}
		});
		assertEquals("All rows must have the same length", exception.getMessage());
	}

	@Test
	public void testIntConst1()
	{
		double[][] vals = {{1.},{1.},{1.}};
		Matrix A = new Matrix(3, 1, 1.);
		assertEquals(A.getRows(), 3);
		assertEquals(A.getCols(), 1);
		assertEquals(1., A.getMatrixPos(0, 0));
		assertEquals(1., A.getMatrixPos(1, 0));
		assertEquals(1., A.getMatrixPos(2, 0));
		assertArrayEquals(vals, A.getMatrix());
	}

	@Test
	public void testSetters1()
	{
		double[][] vals = {{1.,2.,3.},{4.,5.,6.},{7.,8.,9.}};
		Matrix A = new Matrix(vals);
		A.setRows(6);
		A.setCols(20);
		assertEquals(6, A.getRows());
		assertEquals(20, A.getCols());
	}

	@Test
	public void testSetters2()
	{
		double[][] vals1 = {{1.,2.,3.},{4.,5.,6.},{7.,8.,9.}};
		double[][] vals2 = {{0.,2.,3.},{4.,5.,-17.},{7.,12.,9.}};
		Matrix A = new Matrix(vals1);
		A.setMatrixPos(1, 2, -17.);
		A.incrMatrixPos(2, 1, 4.);
		A.decrMatrixPos(0, 0, 1.);
		assertEquals(-17., A.getMatrixPos(1, 2));
		assertEquals(12., A.getMatrixPos(2, 1));
		assertEquals(0., A.getMatrixPos(0, 0));
		assertArrayEquals(vals2, A.getMatrix());
	}

	@Test
	//Test for failure
	public void testSetters3()
	{
		Throwable exception = assertThrows(IllegalArgumentException.class, new Executable()
		{
			@Override
			public void execute() throws Throwable
			{
				Matrix A = new Matrix(-3, 4, 7.);
			}
		});
		assertEquals("Rows Passed in Not Greater than Zero", exception.getMessage());
	}

	@Test
	//Test for failure
	public void testSetters4()
	{
		Throwable exception = assertThrows(IllegalArgumentException.class, new Executable()
		{
			@Override
			public void execute() throws Throwable
			{
				Matrix A = new Matrix(3,-4,.7);
			}
		});
		assertEquals("Columns Passed in Not Greater than Zero", exception.getMessage());
	}

	@Test
	public void testTimes1()
	{
		double[][] vals1 = {{3.,4.},{7.,2.},{5.,9.}};
		double[][] vals2 = {{3.,1.,5.},{6.,9.,7.}};
		Matrix A = new Matrix(vals1);
		Matrix B = new Matrix(vals2);
		Matrix C = A.times(B);
		double[][] vals3 = {{33.,39.,43.},{33.,25.,49.},{69.,86.,88.}};
		assertArrayEquals(vals3, C.getMatrix());
	}
	
	@Test
	public void testTimes2()
	{
		double[][] vals1 = {{1.,2.,3.},{4.,5.,6.},{7.,8.,9.}};
		double[][] vals2 = {{1.},{1.},{1.}};
		Matrix A = new Matrix(vals1);
		Matrix B = new Matrix(vals2);
		Matrix C = A.times(B);
		double[][] vals3 = {{6.},{15.},{24.}};
		assertArrayEquals(vals3, C.getMatrix());
	}

	@Test
	//Test for failure
	public void testTimes3()
	{
		Throwable exception = assertThrows(IllegalArgumentException.class, new Executable()
		{
			public void execute() throws Throwable
			{
				Matrix A = new Matrix(3,4,.7);
				Matrix B = new Matrix(3,4,.8);

				Matrix C = A.times(B);
			}
		});
		assertEquals("Multiplication Column Row Mismatch", exception.getMessage());
	}

	@Test
	public void testPrint1()
	{
		double[][] vals = {{1.,2.,3.},{4.,5.,6.},{7.,8.,9.}};
		Matrix A = new Matrix(vals);
		
		String formatStr = "%9.4f%9.4f%9.4f\n%9.4f%9.4f%9.4f"
				+ "\n%9.4f%9.4f%9.4f\n";

		String correctString = String.format(formatStr, 1., 2.,
						3., 4., 5., 6., 7., 8., 9.);

		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		System.out.flush();
		A.print(9, 4);
		String testOutput = baos.toString();

		assertEquals(correctString, testOutput);
		System.setOut(origOut);
	}

	@Test
	public void testPrint2()
	{
		double[][] vals = {{0.13,22.5,-3.888},{72.,-68.124,0.1987}};
		Matrix A = new Matrix(vals);
	
		String formatStr = "%5.2f%5.2f%5.2f\n%5.2f%5.2f%5.2f\n";

		String correctString = String.format(formatStr, 0.13, 22.5,
						-3.888, 72., -68.124, 0.1987);

		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		System.out.flush();
		A.print(5, 2);
		String testOutput = baos.toString();

		assertEquals(correctString, testOutput);
		System.setOut(origOut);
	}

	@Test
	public void testTesttrix()
	{
		double[][] vals = {{1.,2.,3},{4.,5.,6.},{7.,8.,9.}};

		Matrix A = new Matrix(vals);
		Matrix x = new Matrix(3, 1, 1.);
		Matrix b = A.times(x);

		String formatA = "%9.4f%9.4f%9.4f\n%9.4f%9.4f%9.4f"
				+ "\n%9.4f%9.4f%9.4f\n";
		formatA = String.format(formatA, 1., 2.,
					3., 4., 5., 6., 7., 8., 9.);

		String formatx = "%9.4f\n%9.4f\n%9.4f\n";
		formatx = String.format(formatx, 1., 1., 1.);

		String formatb = "%9.4f\n%9.4f\n%9.4f\n";
		formatb = String.format(formatb, 6., 15., 24.);


		String correctString = formatA + "x\n" + formatx
					+ "=\n" + formatb;

		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		System.out.flush();

		A.print(9,4);
		System.out.println("x");
		x.print(9,4);
		System.out.println("=");
		b.print(9,4);

		String testOutput = baos.toString();

		assertEquals(correctString, testOutput);
		System.setOut(origOut);
	}

	@Test
	public void testTranspose1()
	{
		double[][] vals1 = {{1.,2.,3},{4.,5.,6.},{7.,8.,9.}};
		double[][] vals2 = {{1.,4.,7.},{2.,5.,8.},{3.,6.,9.}};

		Matrix A = new Matrix(vals1);
		Matrix B = A.transpose();

		assertArrayEquals(vals2, B.getMatrix());
	}

	@Test
	public void testTranspose2()
	{
		double[][] vals1 = {{-12.,33.},{9.,0.},{3.,67.}};
		double[][] vals2 = {{-12.,9.,3.},{33.,0.,67.}};

		Matrix A = new Matrix(vals1);
		Matrix B = A.transpose();

		assertArrayEquals(vals2, B.getMatrix());
	}

	@Test
	public void testNormInf1()
	{
		double[][] vals = {{1.,4.,7.},{2.,5.,8.},{3.,6.,9.}};
		double correctValue = 18.;

		Matrix A = new Matrix(vals);

		assertEquals(correctValue, A.normInf());
	}

	@Test
	public void testNormInf2()
	{
		double[][] vals = {{-1.,4.,-7.},{2.,5.,8.},{3.,-6.,-9.}};
		double correctValue = 18.;

		Matrix A = new Matrix(vals);

		assertEquals(correctValue, A.normInf());
	}
	
    @Test
	public void testMinus1()
	{
		double[][] vals1 = {{1.,2.,3},{4.,-5.,6.},{7.,8.,9.}};
		double[][] vals2 = {{1.,4.,7.},{2.,-5.,8.},{3.,6.,9.}};
		double[][] vals3 = {{0.,-2.,-4.},{2.,0.,-2.},{4.,2.,0.}};

		Matrix A = new Matrix(vals1);
		Matrix B = new Matrix(vals2);
		Matrix C = A.minus(B);

		assertArrayEquals(vals3, C.getMatrix());
	}

	@Test
        //Test for failure
	public void testminus2()
	{
		Throwable exception = assertThrows(IllegalArgumentException.class, new Executable()
		{
			public void execute() throws Throwable
			{
				Matrix A = new Matrix(3,5,7.);
				Matrix B = new Matrix(3,4,8.);

				Matrix C = A.minus(B);
			}
		});

		assertEquals("Cannot Subtract Unequal Size Arrays", exception.getMessage());
    }

    @Test
	public void testNorm11()
	{
		double[][] vals = {{1.,4.,7.},{2.,5.,8.},{3.,6.,9.}};
		double correctValue = 24.;

		Matrix A = new Matrix(vals);
		
		assertEquals(correctValue, A.norm1());
	}

	@Test
	public void testNorm12()
	{
		double[][] vals = {{-1.,4.,-7.},{2.,5.,8.},{3.,6.,-9.}};
		double correctValue = 24.;

		Matrix A = new Matrix(vals);

		assertEquals(correctValue, A.norm1());
    }

    @Test
    public void testRandom1()
    {   
        int correctCols = 3;
        int correctRows = 3;
        
        Matrix A = Matrix.random(correctRows, correctCols);

        assertEquals(correctCols, A.getCols());
        assertEquals(correctRows, A.getRows());
    }

    @Test
    public void testRandom2()
    {
        int inclusiveLowerBound = 0;
        int exclusiveUpperBound = 1;
    
        for (int i = 0; i < 10; i++)
        {
            Matrix A = Matrix.random(3, 3);
            for (int rows = 0; rows < A.getRows(); rows++)
            {
                for (int cols = 0; cols < A.getCols(); cols++)
                {
                    assertTrue(A.getMatrixPos(rows, cols) < exclusiveUpperBound);
                    assertTrue(A.getMatrixPos(rows, cols) >= inclusiveLowerBound);
                }
            }
        }
    }
}

