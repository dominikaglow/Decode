package com.company;

public class Decode extends DecoderInterface{
    String referencja = "";
    String zeroCod = ""; //zakodowane zero
    String result = "";

    String codedZero(){
        int one = -1; //indeks pierwszej ejdynki w ciagu
        int indOfEnd = -1; //indeks jedynki, ktora oznacza koniec zakodowanego zera

        //najpierw w calym cigu znakow szukam 1 i wyciagam fragment ktory zaczyna sie od 1
        //a konczy na 0 zeby zobaczyc jak wyglada zakodowane 0
        if(referencja.indexOf("1") != -1) {
            one = referencja.indexOf("1");
        }

        if(one != -1){
            referencja = referencja.substring(one);
        }
        indOfEnd = referencja.indexOf("0");
        if(indOfEnd != -1){
            zeroCod = referencja.substring(0, indOfEnd + 1);
        }

        //System.out.println("Zero coded: " + zeroCod);
        return zeroCod;
    }
    @Override
    public void input(int bit) {
        String znak = String.valueOf(bit);
        referencja = referencja + bit;
    }

    @Override
    public String output() {
        System.out.println("Wprowadzony ciag: " + referencja);
        String z = "";
        z = codedZero();
        System.out.println("Zakodowane zero: " + z);
        System.out.println("referencja: " + referencja);

        int lenghtOfZero = z.length(); //dlugosc zakodowanego zera
        int numOfOnes = lenghtOfZero - 1; //ilosc jedynek w zakodowanym zerze jest o 1 mniejsza od dlugosci zera
        int start = -1, end = -1;

        while(referencja.length() > 0){
            int del = referencja.indexOf("1"); //od tego indeksu trzeba przyciac ref zeby nie bylo na poczatku zer
            if(del >= 0) {
                referencja = referencja.substring(del);
                start = referencja.indexOf("1");
                end = referencja.indexOf("0");

                if (start != -1 && end != -1) {
                    String number = referencja.substring(start, end + 1);
                    if (number.length() == lenghtOfZero) {
                        result = result + "0";
                    } else if (number.length() - 1 == 2 * numOfOnes) {
                        result = result + "1";
                    } else if (number.length() - 1 == 3 * numOfOnes) {
                        result = result + "2";
                    } else if (number.length() - 1 == 4 * numOfOnes) {
                        result = result + "3";
                    }
                    referencja = referencja.substring(end + 1);
                }
            }
            else{
                break;
            }
        }
        System.out.println("result: " + result);
        return null;
    }

    @Override
    public void reset() {
        referencja = "";
    }
}
