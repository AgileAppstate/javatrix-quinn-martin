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
		double[][] vals = {{1.,2.,3},{4.,5.,6.},{7.,8.,9.}};
		Matrix A = new Matrix(vals);
		assertEquals(3, A.getRows());
		assertEquals(3, A.getRows());
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
		double[][] vals1 = {{1.,2.,3},{4.,5.,6.},{7.,8.,9.}};
		double[][] vals2 = {{1.},{1.},{1.}};
		Matrix A = new Matrix(vals1);
		Matrix B = new Matrix(vals2);
		Matrix C = A.times(B);
		double[][] vals3 = {{6.},{15.},{24.}};
		assertArrayEquals(vals3, C.getMatrix());
	}


}

