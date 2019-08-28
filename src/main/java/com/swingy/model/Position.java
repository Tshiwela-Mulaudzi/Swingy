package com.swingy.model;

public class Position {
    private int row;
    private int column;
    
    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getRow(){
        return this.row;
    }

    public void changeRow(int value){
        this.row += value;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public int getColumn(){
        return this.column;
    }

    public void changeColum(int value){
        this.column += value;
    }
}