/* 
 * junit5 test class
*/

import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
	public void testtimes1()
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

}

