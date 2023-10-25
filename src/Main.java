import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//Вася разобрал на даче старый сарай на N досок одинаковой ширины и толщины, но разной длины. Он решил построить из них забор.
// Высота забора не имеет для Васи особого значения, главное чтобы он был как можно более ровным. Неровность забора определяется
// как разница высот между самой короткой и самой длинной доской, использованной для постройки забора.
//После тщательного измерения оказалось, что K из N досок лишние и их можно не использовать для строительства забора.
//Определите минимальную неровность забора, который можно построить из п-к досок.
//В первой строке входных данных записаны два числа п и k (0≤k<n≤200 000) — количество досок от разбора сарая и количество
// лишних досок.
//Во второй строке записаны п целых чисел 1; (1≤l;≤10°) — длины досок.
public class Main {
    public static void main(String[] args) {
        Scanner board = new Scanner(System.in);
        System.out.println("введите общ.кол. и кол.ненужных досок:");
        String quantityAllBoards = board.nextLine();
        System.out.println("введите длинны всех досок:");
        String boardsLengthsAll = board.nextLine();
        board.close();
        findStrait(quantityAllBoards, boardsLengthsAll);
    }

    public static void findStrait(String quantityAllBoards, String boardsLengthsAll) {
        String[] boardArray = quantityAllBoards.split(" ");
        int quantityBoards = Integer.parseInt(boardArray[0]);
        int quantityBoardsExtra = Integer.parseInt(boardArray[1]);
        int boardForHome = quantityBoards - quantityBoardsExtra;
        int[] arrBoardsLengthsAll = Arrays.stream(boardsLengthsAll.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int b = arrBoardsLengthsAll[boardForHome - 1] - arrBoardsLengthsAll[0];
        for (int i = 0, j = boardForHome; i < arrBoardsLengthsAll.length && j < arrBoardsLengthsAll.length; i++, j++) {
            int a = arrBoardsLengthsAll[j - 1] - arrBoardsLengthsAll[i];
            if (a < b) {
                b = a;
            }
        }
        System.out.println(b);
    }
}