
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ilhas {

    //total de linhas e colunas
    private int ROW, COL;
    // matriz contendo arquivo binário
    private int[][] arBinario;
    // contator de ilhas
    private int totalIlhas = 0;
    // lista posiçoes da ilha
    List<PosicoesIlha> lstIlhas = new ArrayList<PosicoesIlha>();

    public Ilhas(String filePath) {
        try {
            Scanner sc = new Scanner(new FileReader(filePath));
            this.COL = sc.nextInt();
            this.ROW = sc.nextInt();
            this.arBinario = new int[ROW][COL];

            int index = 0;
            while (sc.hasNext()) {
                this.arBinario[index] = this.stringToArray(sc.next());
                index++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

        System.out.println("");
        totalIlhas = contaIlhas(arBinario);
    }

    private int[] stringToArray(String str) {
        int[] array = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            array[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        return array;
    }

    public int getIlhas() {
        return totalIlhas;
    }

    // valida linha, coluna
    private boolean valida(int M[][], int row, int col, boolean visited[][]) {
        // verifica se a coluna e a linha são válidos, se contem valor 1 e se ainda não foi visitado
        return (row >= 0) && (row < this.ROW)
                && (col >= 0) && (col < this.COL)
                && (M[row][col] == 1 && !visited[row][col]);
    }

    // Navega na matria para identificar as ilhas
    //
    private void DFS(int M[][], int row, int col, boolean visited[][], PosicoesIlha posicoesIlha) {
        int rowNbr[] = new int[]{-1, 0, 0, 1};
        int colNbr[] = new int[]{0, -1, 1, 0};

        // marca posicoes visitadas
        visited[row][col] = true;

        //System.out.println(row +", " + col );
        posicoesIlha.addItem(row, col);

        for (int k = 0; k < 4; ++k) {
            if (this.valida(M, row + rowNbr[k], col + colNbr[k], visited)) {
                //System.out.println((row + rowNbr[k]) +", " + (col + colNbr[k]));
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, posicoesIlha);
            }
        }
    }

    //  contador de ilhas
    private int contaIlhas(int M[][]) {
        // guardar posicoes visitadas
        boolean visited[][] = new boolean[ROW][COL];
        PosicoesIlha posicoesIlha;
        
        int count = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j] == 1 && !visited[i][j])
                {
                    //System.out.println("Ilha nr.: " + (count+1));
                    posicoesIlha = new PosicoesIlha();
                    DFS(M, i, j, visited, posicoesIlha);
                    ++count;
                    
                    posicoesIlha.setNameIlha("Ilha " + count);
                    lstIlhas.add(posicoesIlha);
                }
            }
        }

        return count;
    }

    public void printMatriz() {
        for (int index = 0; index < this.arBinario.length; index++) {
            //System.out.print("|");
            for (int i = 0; i < arBinario[index].length; i++) {
                System.out.print(arBinario[index][i]);
                //System.out.print("|");
            }
            System.out.println("");
        }
    }

    public void printMatriz2() {
        for (int index = 0; index < this.arBinario.length; index++) {
            //System.out.print("|");
            for (int i = 0; i < arBinario[index].length; i++) {
                if (arBinario[index][i] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(arBinario[index][i]);
                }
                //System.out.print("|");
            }
            System.out.println("");
        }
    }

    public void printPositions() {
        for (PosicoesIlha ilha : lstIlhas) {
            System.out.println(ilha.getNameIlha());
            for (ItemIlha item : ilha.getItem()) {
                System.out.println(item.getLinha() + ", " + item.getColuna());
            }
            System.out.println("");
        }

    }
}
