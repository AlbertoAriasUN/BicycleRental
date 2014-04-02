package model;

public abstract class Model {
    private int id;
    
    public int getId(){
        return id;
    }
    
    @Override
    public boolean equals(Object obj){
        return true;
    }
    
    public void setId(int id){
        this.id = id;
    }
}
