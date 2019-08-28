package com.swingy.model;

public class Player {
    protected Position position;

    public int getRow(){
        return this.position.getRow();
    }

    public int getColumn(){
        return this.position.getColumn();
    }

    public void setPosition(int row, int column){
        if (this.position == null)
            this.position = new Position(row, column);
        else{
            this.position.setRow(row);
            this.position.setColumn(column);
        }
    }
}