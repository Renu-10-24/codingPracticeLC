package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        S s = new S();
//        System.out.println(s.isValidSudoku(board));

        ScalerSol ss = new ScalerSol();
        String[] A = new String[]{"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        int x=0;
//        int x=ss.isValidSudoku(A);
//        System.out.println(x);
        //"..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."
        A = new String[]{"..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."};
//        "..5.....6"
//        "....14..."
//        "........."
//        ".....92.."
//        "5....2..."
//        ".......3."
//        "...54...."
//        "3.....42."
//        "...27.6.."
        x=ss.isValidSudoku(A);
        System.out.println(x);
//        ". . .  . 5 .  . 1 . ",
//        ". 4 .  3 . .  . . . ",
//        ". . .  . . 3  . . 1 ",

//        "8 . .  . . .  . 2 . ",
//        ". . 2  . 7 .  . . . ",
//        ". 1 5  . . .  . . . ",

//        ". . .  . . 2  . . . ",
//        ". 2 .  9 . .  . . . ",
//        ". . 4  . . .  . . . "
    }
}

class S {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowset = null;
//		System.out.println("rowsets");
        rowset = new HashSet<Character>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
//					System.out.print("board[" + i + "][" + j + "] : " + board[i][j] + " ");
                    if (!rowset.add(board[i][j])) {
                        return false;
                    }
                }
            }
//			System.out.println();
            rowset.clear();
        }

        for (int j = 0; j < board[0].length; j++) {
//			colset = new HashSet<Character>();
//			System.out.println("colsets j " + j);
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
//					System.out.print("board[\"+i+\"][\"+j+\"] : " + board[i][j] + " ");
                    if (!rowset.add(board[i][j])) {
                        return false;
                    }
                }
            }
//			System.out.println();
            rowset.clear();
        }
        for (int c2 = 0; c2 <= 2; c2++) {
            for (int c1 = 0; c1 <= 2; c1++) {
//				sqset = new HashSet<Character>();
                for (int i = 0; i <= 2; i++) {
//					System.out.println("c1 " + c1 + "i " + i);
                    for (int j = 0; j <= 2; j++) {
//						System.out.println("c2 " + c2 + "j " + j);
//						System.out.println("index : [" + (3 * c1 + i) + " ][ " + (3 * c2 + j) + "]");
                        if (board[3 * c1 + i][3 * c2 + j] != '.') {
//							System.out.println("board[i][j] : " + board[3 * c1 + i][3 * c2 + j]);
                            if (!rowset.add(board[3 * c1 + i][3 * c2 + j])) {
                                return false;
                            }
                        }
                    }
                }
                rowset.clear();
            }
        }
        return true;
    }
}

class ScalerSol {
    public int isValidSudoku(final String[] A) {
        Set<Character> rows = new HashSet<Character>();
        for (int i = 0; i < A.length; i++) {
            rows = new HashSet<>();
            for (int j = 0; j < A[i].length(); j++) {
                String row = A[i];
                char ch = row.charAt(j);
                if (ch != '.' && !rows.add(ch)) {
                    return 0;
                }
            }
        }
//        rows.clear();
        int k = 0;
        for (int i = 0; k<A[0].length()&& i < A[k].length(); i++,k++) {
            rows = new HashSet<>();
            for (int j = 0; j < A.length; j++) {
                String col = A[j];
                char ch = col.charAt(i);
                if (ch != '.' && !rows.add(ch)) {
                    return 0;
                }
            }
        }
        rows.clear();
        for (int c2 = 0; c2 <= 2; c2++) {
            for (int c1 = 0; c1 <= 2; c1++) {
                rows = new HashSet<>();
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        char ch = A[3 * c1 + i].charAt(3 * c2 + j);
							System.out.println("x : " + (3 * c1 + i)+" y : "+(3 * c2 + j)+"      "+ch);
                            if (ch !='.' && !rows.add(ch)) {
                                return 0;
                            }
                        }
                    }
                System.out.println();
                System.out.println("..........................");
                }
            }
        return 1;
    }
}