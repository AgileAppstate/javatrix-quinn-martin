/* 
 * junit5 test class
*/

import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MatrixTest {

	@Test
	public void testMatrix1(){
		double[][] vals = {{1.,2.,3},{4.,5.,6.},{7.,8.,9.}};
		Matrix A = new Matrix(vals);
		assertEquals(A.getRows(), 3);
		assertEquals(A.getRows(), 3);
	}
}

