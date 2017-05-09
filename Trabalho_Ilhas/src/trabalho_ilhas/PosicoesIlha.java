
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger
 */
public class PosicoesIlha {
    private String name;
    private ArrayList<ItemIlha> items = new ArrayList<ItemIlha>();
    
    public PosicoesIlha(){
    }
    
    public PosicoesIlha(String name){
        this.name = name;
    }

    public void setNameIlha(String name){
        this.name = name;
    }
            
    public String getNameIlha(){
        return name;
    }
    public void addItem(int linha, int coluna){
        ItemIlha i = new ItemIlha();
        i.setItem(linha, coluna);
        this.items.add(i);
    }
    
    public ArrayList<ItemIlha> getItem(){
        return this.items;
    }
 }
