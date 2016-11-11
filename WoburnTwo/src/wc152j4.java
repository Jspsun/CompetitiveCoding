import java.util.Scanner;

public class wc152j4
{
	public static int noOfRows;
	public static int noOfColumns;
	public static char nature[][];

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		noOfRows = s.nextInt();
		noOfColumns = s.nextInt();
		nature = new char[noOfRows][noOfColumns];
		int totalHits = 0;
		int count = 0;
		for (int row = 0; row < noOfRows; row++)
		{
			for (int i = 0; i < noOfColumns; i++)
			{
				nature[row][i] = s.next().charAt(0);
			}
		}

		for (int row = 0; row < noOfRows; row++)
		{
			for (int column = 0; column < noOfColumns; column++)
			{
				if (nature[row][column] == '.')
				{
					for (int initialDirection = 1; initialDirection <= 4; initialDirection++)
					{
						if (willHit(row, column, initialDirection))
						{
							totalHits++;
							break;
						}
					}
				}
			}
		}
		System.out.print(totalHits);
	}

	private static boolean willHit(int startingRow, int startingColumn,
			int startingDirection)
	{
		int currentDirection = startingDirection;
		int currentRow = startingRow;
		int currentColumn = startingColumn;
		while (true)
		{
			if (currentDirection == 1)
			{
				if (currentRow > 0)
				{
					currentRow--;
				}
				else
				{
					break;
				}
			}
			else if (currentDirection == 2)
			{
				if (currentColumn < noOfColumns - 1)
				{
					currentColumn++;
				}
				else
				{
					break;
				}
			}
			else if (currentDirection == 3)
			{
				if (currentRow < noOfRows - 1)
				{
					currentRow++;
				}
				else
				{
					break;
				}
			}
			else if (currentDirection == 4)
			{
				if (currentColumn > 0)
				{
					currentColumn--;
				}
				else
				{
					break;
				}
			}
			if (currentColumn == startingColumn && currentRow == startingRow)
			{
				return true;
			}
			if (nature[currentRow][currentColumn] == 'X')
			{
				if (currentDirection == 1)
				{
					currentDirection = 3;
				}
				else if (currentDirection == 2)
				{
					currentDirection = 4;
				}
				else if (currentDirection == 3)
				{
					currentDirection = 1;
				}
				else if (currentDirection == 4)
				{
					currentDirection = 2;
				}
			}
			else if (nature[currentRow][currentColumn] == '/')
			{
				if (currentDirection == 1)
				{
					currentDirection = 2;
				}
				else if (currentDirection == 2)
				{
					currentDirection = 1;
				}
				else if (currentDirection == 3)
				{
					currentDirection = 4;
				}
				else if (currentDirection == 4)
				{
					currentDirection = 3;
				}
			}
			else if (nature[currentRow][currentColumn] == '\\')
			{
				if (currentDirection == 1)
				{
					currentDirection = 4;
				}
				else if (currentDirection == 2)
				{
					currentDirection = 3;
				}
				else if (currentDirection == 3)
				{
					currentDirection = 2;
				}
				else if (currentDirection == 4)
				{
					currentDirection = 1;
				}
			}
			else if (nature[currentRow][currentColumn] == '#')
			{
				break;
			}
		}
		return false;
	}
}
