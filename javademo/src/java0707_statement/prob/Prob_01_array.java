package java0707_statement.prob;
/*
 * 4행 4열 data배열에 가로 세로 합계를 구하는 프로그램을 구현하시오.
 * [출력결과]
 *  1   2   3   6
 *  4   5   6  15
 *  7   8   9  24
 * 12  15  18  45
 */

public class Prob_01_array {

	public static void main(String[] args) {
		int[][] data = new int[4][4];
		int cnt = 1;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {

				if (row <= 2 && col <= 2) {
					data[row][col] = cnt++;
				} else if (row > 2) {

					for (int i = 0; i < row; i++) {
						data[row][col] += data[i][col];
					}

				} else {
					for (int i = 0; i < col; i++) {
						data[row][3] += data[row][i];

					}

				}

				System.out.printf("%d\t", data[row][col]);
			}
			System.out.println();
		}

	}// end main()

}// end class
