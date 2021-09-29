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

    public Matrix(int m, int n, double s){
        double[][] mat = new double[m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = s;
            }
        }
        matrix = mat;
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

