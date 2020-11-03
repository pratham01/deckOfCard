package main;

public class Card {

    private String category;
    private String number;

    public Card(String category, String number){
        this.category = category;
        this.number = number;
    }

    public String getNumber(){
        return number;
    }


    @Override
    public String toString(){
        return String.format(category+ " "+number);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + category.length();
        result = prime * result + number.length();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card card = (Card)obj;
        if(card.category == this.category && this.number == card.getNumber())
            return true;
        else
            return false;
    }
}
