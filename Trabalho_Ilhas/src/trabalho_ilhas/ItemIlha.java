/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger
 */
public class ItemIlha {
    private int linha;
    private int coluna;

    public void setItem(int lin, int col){
        this.linha = lin;
        this.coluna = col;
    }
    
    public int getLinha(){
        return this.linha;
    }
    
    public int getColuna(){
        return this.coluna;
    }
}
