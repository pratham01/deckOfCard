package main;

public class Result implements Comparable<Result> {
    private int precedence;
    private int maxNo;

    public Result(int precedence, int maxNo){
        this.maxNo = maxNo;
        this.precedence = precedence;
    }

    @Override
    public int compareTo(Result result){
        if(this.precedence == result.precedence){
            return (int)(result.maxNo - this.maxNo );
            }
        else{
            return (int)(result.precedence - this.precedence );
        }
    }

    @Override
    public String toString(){
        return String.format("Precedence " + precedence+ " max number "+ maxNo);
    }
}
