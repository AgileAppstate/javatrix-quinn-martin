package javatrix;

/**
 * Matrix Class.
 * Matrix.java
 * @author Quinn Corcoran
 * @author Martin Hernandez-gamez
 * @version Fall 2021
*/

public class Matrix
{
	/*
 	 * Matrix class fields.
 	*/ 
	private double[][] matrix;
	private int rows;
	private int cols;

	/*
	 * Matrix class constructors.
	*/
	/**
 	 * Matrix class Constructor.
 	 * @param matM double[][]
 	*/
	public Matrix(double[][] matM)
	{
		for (int i = 1; i < matM.length; i++)
		{
			if (matM[i].length != matM[i - 1].length)
			{
				throw new IllegalArgumentException("All rows must "
								+ "have the same length");
			}
		}
		
		setMatrix(matM);
		setRows(matM.length);
		setCols(matM[0].length);
	}
  
	/**
 	 * Matrix class constructor.
	 * @param m int
	 * @param n int
	 * @param s double
 	*/ 
	public Matrix(int m, int n, double s)
	{
		setRows(m);
		setCols(n);
		double[][] matM = new double[m][n];
		setMatrix(matM);
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				setMatrixPos(i, j, s);
			}
		}
	}

	/*
	 * Matrix class methods.
	*/
	/**
 	 * main method.
 	 * @param args String[]
 	*/
 
	public static void main(String[] args)
	{

	}

	/**
 	 * method to multiply two matrices.
 	 * @param matB Matrix
 	 * @return matC Matrix
 	*/ 
	public Matrix times(Matrix matB)
	{
		if (this.getCols() != matB.getRows())
		{
			throw new IllegalArgumentException("Multiplication "
							+ "Column Row Mismatch"); 
		}
		
		Matrix matC = new Matrix(this.getRows(), matB.getCols(), 0.);
		for (int i = 0; i < this.getRows(); i++)
		{
			for (int j = 0; j < matB.getCols(); j++)
			{
				for (int k = 0; k < matB.getRows(); k++)
				{
					matC.incrMatrixPos(i, j, (this.getMatrixPos(i, k)
								* matB.getMatrixPos(k, j)));
				}
			}
		}
		return matC;
	}

	/**
 	 * method to print a matrix.
 	 * @param w int
 	 * @param d int
 	*/
	public void print(int w, int d)
	{
		String format = "%" + w + "." + d + "f";
		for (int m = 0; m < getRows(); m++)
		{
			for (int n = 0; n < getCols(); n++)
			{
				System.out.printf(format, getMatrixPos(m, n));
			}
			System.out.println("");
		}
	}

	/**
	 * method to transpose a matrix.
	 * @return trans Matrix
	*/
	public Matrix transpose()
	{
		Matrix trans = new Matrix(this.getCols(), this.getRows(), 0.);
		for (int i = 0; i < this.getRows(); i++)
		{
			for (int j = 0; j < this.getCols(); j++)
			{
				trans.setMatrixPos(j, i, this.getMatrixPos(i, j));
			}
		}
		return trans;
	}

	/**
	 * method to compute maximum row sum.
	 * @return norm double
	*/
	public double normInf()
	{
		double norm = 0.;
		double temp = 0.;
		for (int i = 0; i < getRows(); i++)
		{
			for (int j = 0; j < getCols(); j++)
			{
				temp += Math.abs(getMatrixPos(i, j));
			}
			if (norm < temp)
			{
				norm = temp;
			}
			temp = 0;
		}
		return norm;
	}

    	/**
	 * method to subtract two matrices.
	 * @param matB Matrix
	 * @return matC Matrix
	*/
	public Matrix minus(Matrix matB)
	{
		if (this.getRows() != matB.getRows()
			 || this.getCols() != matB.getCols())
		{
			throw new IllegalArgumentException("Cannot Subtract "
							+ "Unequal Size Arrays");
		}
		Matrix matC = new Matrix(matB.getRows(), matB.getCols(), 0.);
		for (int i = 0; i < matB.getRows(); i++)
		{
			for (int j = 0; j < matB.getCols(); j++)
			{
				matC.setMatrixPos(i, j, (this.getMatrixPos(i, j) 
							- matB.getMatrixPos(i, j)));
			}
		}
		return matC;
	}


    	/**
 	 * method to find the max colum sum.
 	 * @return norm double
	*/
	public double norm1()
	{
		double norm = 0.;
		double temp = 0.;
		for (int i = 0; i < getCols(); i++)
		{
			for (int j = 0; j < getRows(); j++)
			{
				temp += Math.abs(getMatrixPos(j, i));
			}
			if (temp > norm)
			{
				norm = temp;
			}
			temp = 0;
		}
		return norm;
	}

	/**
	 * Method to return and identity matrix.
	 * @param m int
	 * @param n int
	 * @return mat Identity matrix
	*/
	public static Matrix identity(int m, int n)
	{
		Matrix mat = new Matrix(m, n, 0.0);
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i == j)
				{
					mat.setMatrixPos(i, j, 1.0);
				}
			}
		}
		return mat;
	}
        /**
        * Method to create an Matrix of random elements.
        * @param m int
        * @param n int
     	* @return mat Matrix of random elements
    	*/
	public static Matrix random(int m, int n)
	{
		Matrix mat = new Matrix(m, n, 0.0);
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				mat.setMatrixPos(i, j, Math.random());
			}
		}
		return mat;
	}


	/**
	 * method to return the sum of the diagonals.
	 * @return traceSum double
	*/
	public double trace()
	{
		if (getRows() != getCols())
		{
			throw new IllegalArgumentException("Trace Must be Called " 
							+ "on a Square Matrix");
		}
		int traceSum = 0;
		for (int i = 0; i < getRows(); i++)
		{
			traceSum += getMatrixPos(i, i);
		}
		return traceSum;
    }

        /**
         * Method to create a deep copy of a matrix.
         * @return copy The copied matrix
         */
	public Matrix copy()
	{
		Matrix copy = new Matrix(this.getRows(), this.getCols(), 0);

		for (int i = 0; i < this.getRows(); i++)
		{
			for (int j = 0; j < this.getCols(); j++)
			{
				copy.setMatrixPos(i, j, this.getMatrixPos(i, j));
			}
		}
		return copy;
	}

    /**
     * Method to return the sum of two arrays.
     * @return sum Array of sums
    */
    public Matrix plus(Matrix B)
    {
        Matrix sum = new Matrix(this.getRows(), this.getCols(), 0.0);
        for (int i = 0; i < this.getRows(); i++)
        {
           for (int j = 0; j < this.getCols(); j++)
           {
               sum.setMatrixPos(i, j, this.getMatrixPos(i, j) + B.getMatrixPos(i, j));
           }
        }
        return sum;
    }


	/* getters */
	/**
	 * Method to create a copy of the array.
	 * @return arr The copied array
	*/
	public double[][] getArrayCopy()
	{
		double[][] arr = new double[this.getRows()][this.getCols()];

		for (int i = 0; i < this.getRows(); i++)
		{
			for (int j = 0; j < this.getCols(); j++)
			{
				arr[i][j] = this.getMatrixPos(i, j);
			}
		}
		return arr;
	}
	/**
 	 * getter for matrix field.
 	 * @return matrix double[][]
 	*/
	public double[][] getMatrix()
	{
		return matrix;
	}
	/**
	 * getter for position[m][n] in matrix field.
	 * @param m int
	 * @param n int
	 * @return matrix[m][n] double
	*/
	public double getMatrixPos(int m, int n)
	{
		if (m >= getRows() || n >= getCols() 
			|| m < 0 || n < 0)
		{
			throw new IllegalArgumentException("Index Out of Bounds");
		}
		return matrix[m][n];
	}
	/**
 	 * getter for rows field.
	 * @return rows int
	*/
	public int getRows()
	{
		return rows;
	}
	/**
	 * getter for cols field.
	 * @return cols int
	*/
	public int getCols()
	{
		return cols;
	}
	
	/* setters */
	/**
 	 * setter for matrix field.
	 * @param matM double[][]
	*/
	public void setMatrix(double[][] matM)
	{
		matrix = matM;
	}
	/**
	 * setter for position[m][n] in matrix field.
	 * @param m int
	 * @param n int
	 * @param s double
	*/
	public void setMatrixPos(int m, int n, double s)
	{
		if (m >= getRows() || n >= getCols()
			|| m < 0 || n < 0)
		{
			throw new IllegalArgumentException("Index Out of Bounds");
		}

		matrix[m][n] = s;
	}
	/**
	 * increments position[m][n] in matrix field by 1.
	 * @param m int
	 * @param n int
	 * @param s double
	*/
	public void incrMatrixPos(int m, int n, double s)
	{
		if (m >= getRows() || n >= getCols()
			|| m < 0 || n < 0)
		{
			throw new IllegalArgumentException("Index Out of Bounds");
		}

		matrix[m][n] += s;
	}
	/**
	 * decrements position[m][n] in matrix field by 1.
 	 * @param m int
 	 * @param n int
 	 * @param s double
 	*/
	public void decrMatrixPos(int m, int n, double s)
	{
		if (m >= getRows() || n >= getCols()
			|| m < 0 || n < 0)
		{
			throw new IllegalArgumentException("Index Out of Bounds");
		}

		matrix[m][n] -= s;
	}
	/**
	 * setter for rows field.
	 * @param m int
	*/
	public void setRows(int m)
	{
		if (m <= 0)
		{
			throw new IllegalArgumentException("Rows Passed in Not "
							+ "Greater than Zero");
		}
		rows = m;
	}
	/**
	 * setter for cols field.
	 * @param n int
	*/
	public void setCols(int n)
	{
		if (n <= 0)
		{
			throw new IllegalArgumentException("Columns Passed in Not "
							+ "Greater than Zero");
		}
		cols = n;
	}

}

