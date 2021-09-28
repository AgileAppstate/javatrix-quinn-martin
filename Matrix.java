public class Matrix {
	private double[][] matrix;
	private int rows;
	private int cols;

	public Matrix(double[][] A) {
        	if(A.length != A[0].length)
		{
                	System.out.println("All rows must have the same length");
		}
		else
		{
			matrix = A;
			rows = A.length;
			cols = A[0].length;
		}
	}

	public static void main(String[] args) {
		
	}

	public double[][] getMatrix()
	{
		return matrix;
	}
	public int getRows()
	{
		return rows;
	}
	public int getCols()
	{
		return cols;
	}

}

