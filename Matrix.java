public class Matrix
{
	private double[][] matrix;
	private int rows;
	private int cols;

	public Matrix(double[][] M)
	{
		for(int i=1; i < M.length; i++)
		{
			if(M[i].length != M[i-1].length)
			{
				throw new IllegalArgumentException("All rows must have the same length");
			}
		}
		
		setMatrix(M);
		setRows(M.length);
		setCols(M[0].length);
	}
  
	public Matrix(int m, int n, double s)
	{
		double[][] M = new double[m][n];
		setMatrix(M);
		setRows(m);
		setCols(n);
		for(int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				setMatrixPos(i, j, s);
			}
		}
	}
  
	public static void main(String[] args)
	{

	}

	public Matrix times(Matrix B)
	{
		if (this.getCols() != B.getRows())
		{
			throw new IllegalArgumentException("Column Row Missmatch"); 
		}
		
		Matrix C = new Matrix(this.getRows(), B.getCols(), 0.);
		for(int i=0; i < this.getRows(); i++)
		{
			for(int j=0; j < B.getCols(); j++)
			{
				for(int k=0; k < B.getRows(); k++)
				{
					C.incrMatrixPos(i, j, (this.getMatrixPos(i, k) * B.getMatrixPos(k, j)));
				}
			}
		}
		return C;
	}

	//getters
	public double[][] getMatrix()
	{
		return matrix;
	}
	public double getMatrixPos(int m, int n)
	{
		return matrix[m][n];
	}
	public int getRows()
	{
		return rows;
	}
	public int getCols()
	{
		return cols;
	}
	
	//setters
	public void setMatrix(double[][] M)
	{
		matrix = M;
	}
	public void setMatrixPos(int m, int n, double s)
	{
		matrix[m][n] = s;
	}
	public void incrMatrixPos(int m, int n, double s)
	{
		matrix[m][n] += s;
	}
	public void decrMatrixPos(int m, int n, double s)
	{
		matrix[m][n] -= s;
	}
	public void setRows(int m)
	{
		if(m <= 0)
		{
			throw new IllegalArgumentException("Rows Passed in Not Greater than Zero");
		}
		rows = m;
	}
	public void setCols(int n)
	{
		if(n <= 0)
		{
			throw new IllegalArgumentException("Columns Passed in Not Greater than Zero");
		}
		cols = n;
	}

}

