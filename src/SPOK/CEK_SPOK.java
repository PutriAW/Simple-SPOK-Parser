/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPOK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PUTRI
 */
public class CEK_SPOK {
    private String[] data = {"saya","kamu","mereka","kita","dia","pergi","pulang","makan","minum","membaca",
        "apel","jus","bakso","novel","cerita","kemarin","sekarang","nanti","besok","lusa"};
    private List<Object> stack = new ArrayList<>();
    private int idx = -1;
    
    public char cekKata(String w){
        int i = 0,j,k =0, count= 0; 
        char hasil = 0;
        while (count != 1 && i < data.length){
            if (data[i].length() == w.length()){
                j = 0;
                while(j < data[i].length()){
                    if(data[i].charAt(j) == w.charAt(j)){
                        k++;
                    }
                    j++;
                } 
            }
            if (k == w.length()){
                count = 1;
            }
            k = 0;
            i++;
        }
        i = i - 1;
        if (count == 1){
            if (i > 14 && i <=19){
                hasil = 'K';
            }else if (i > 9 && i<=14){
                hasil = 'O';
            }else if(i> 4 && i <= 9){
                hasil = 'P';
            }else if(i >= 0 && i <= 4){
                hasil = 'S';
            }
        }else{
            hasil = 'E';
        }
        return hasil;
    }
    
    public void push(Object a){
        stack.add(a);
        idx++;
    }
    
    public Object pop(){
        Object hs = stack.remove(idx);
        idx--;
        return hs;
    }
    
    public void cekValidasi(char[] rs){
        int i = 0;
        String hasil;
        push('#');
        push('B');
        if (rs[i] == 'S'){
            pop();
            push('S');
            i++;
            if (rs[i] == 'P'){
                pop();
                push('P');
                i++;
                hasil = "VALID";
                if(rs[i] == 'O'){
                    pop();
                    push('O');
                    hasil = "VALID";
                    i++;
                    if (rs[i] == 'K'){
                        pop();
                        push('K');
                        hasil = "VALID";
                    }
                }else if(rs[i] == 'K'){
                    pop();
                    push('K');
                    hasil = "VALID";
                }else{
                   hasil = "INVALID"; 
                }
                if (hasil == "VALID"){
                    pop();
                    System.out.println(hasil);
                }else{
                    ///System.out.println("INVALID");
                    System.out.println(hasil);
                }
            }else{
                System.out.println("INVALID");
            }
        }else{
            System.out.println("INVALID");
        }
    }
    
    public static void main(String[] args) {
        String[] kata = null;
        char result[] = new char[4];
        Scanner sc = new Scanner(System.in);
        String kalimat = null;
        
        System.out.print("Masukkan Kata :");
        kalimat = sc.nextLine();        
        kata = kalimat.split("\\s");
        CEK_SPOK ck = new CEK_SPOK();
        for (int i = 0; i < kata.length; i++) {
            result[i] = ck.cekKata(kata[i]);
            System.out.print(ck.cekKata(kata[i])+" ");  
        }
        System.out.println("");
        ck.cekValidasi(result);
    }
}