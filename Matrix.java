public class Matrix
{
	private double[][] matrix;
	private int rows;
	private int cols;

	public Matrix(double[][] A)
	{
		for(int i=1; i < A.length; i++)
		{
			if(A[i].length != A[i-1].length)
			{
				throw new IllegalArgumentException("All rows must have the same length");
			}
		}
		
		matrix = A;
		rows = A.length;
		cols = A[0].length;
	}

	public static void main(String[] args)
	{
		
	}

	public Matrix times(Matrix B)
	{
		if (this.cols != B.rows)
		{
			throw new IllegalArgumentException("Column Row Missmatch"); 
		}
		Matrix C = new Matrix(this.rows, B.cols, 0.);
		for(int i=0; i < this.rows; i++)
		{
			for(int j=0; j < B.cols; j++)
			{
				for(int k=0; k < B.rows; k++)
				{
					C.matrix[i][j] += this.matrix[i][k] * B.matrix[k][j];
				}
			}
		}
		return C;
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

