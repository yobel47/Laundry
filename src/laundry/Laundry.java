/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author vegay
 */
public class Laundry {
    
    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner (System.in);
    String nama="", alamat, lagi, tgl_masuk, no_telp, tgl_selesai;
    int pilihan, i=0;
    String[][] data = new String[10][7];
    int kg, totalharga;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Loundry Kiloan");
        String username="admin";
        Laundry lo = new Laundry();
        lo.login();
    }
    
    void login(){
        boolean login = false;
        do{
            System.out.println("+------------------+"); 
            System.out.print("| Username |");
            String user = input.next();
            System.out.print("| Password |");
            String pwd = input.next();
            System.out.println("+------------------+");
            if(user.equals("admin") && pwd.equals("admin")){
                System.out.println("=======================");
                System.out.println("= Anda berhasil login =");
                System.out.println("=======================");
                login=true;
                menu();
            }else{
                System.out.println("=====================================");
                System.out.println("= Username atau password anda salah =");
                System.out.println("=====================================");
                login=false;
            }
        }while(login==false);
        
    }
    
    void menu(){
        do{
            System.out.println("==============================");
            System.out.println("MENU :");
            System.out.println("1.Input Data Pelanggan.");
            System.out.println("2.Tampilkan Data Pelanggan.");
            System.out.println("3.LogOut");
            System.out.print("Pilih Menu Yang Akan Dituju :");
            pilihan = input.nextInt();
            System.out.println("============================");
            switch(pilihan){
                case 1:
                    data();
                    break;
                case 2:
                    show_data();
                    break;
                case 3:
                    System.out.println("");
                    break;
                default:
                    System.out.println("Input Data Tidak Valid!!");
                    break;
            }
        }while(pilihan!=1||pilihan!=2||pilihan!=3);
    }
    
    void data(){
        do{
            System.out.println("=============================");
            input.nextLine();
            System.out.print("Massukan Nama Anda :");
            nama = input.nextLine();
            data[i][0]=nama;
            System.out.print("Massukan No.Telepon Anda :");
            no_telp=input.nextLine();
            data[i][1]=String.valueOf(no_telp);
            System.out.print("Massukan Alamat Anda :");
            alamat=input.nextLine();
            data[i][2]=alamat;
            System.out.print("Tanggal masuk : ");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
            Date date = new Date();
            Calendar c = Calendar.getInstance(); 
            c.setTime(date); 
            System.out.print(dateFormat.format(date));
            tgl_masuk = dateFormat.format(date);
            data[i][4]=String.valueOf(tgl_masuk);
            System.out.println("");
            System.out.print("Kg : ");
            kg = input.nextInt();
            data[i][3] = String.valueOf(kg);
            System.out.println("====================================");
            do{
                System.out.println("Pilihan Lundry");
                System.out.println("1. Pelayanan Lengkap (Cuci Strika)");
                System.out.println("2. Pelayanan Cuci (Tanpa Setrika)");
                System.out.println("3. Pelayanan mengeringkan baju (Menggunkan Mesin Pengering)");
                System.out.print("Masukkan pilihan laundry :");
                pilihan = input.nextInt();
                System.out.println("==================================");
                switch(pilihan){
                    case 1:
                        totalharga=kg*15000;
                        data[i][6]=String.valueOf(totalharga);
                        System.out.println("Harga per kg : 15000");
                        System.out.println("Total Biaya : "+totalharga);
                        c.add(Calendar.DATE, 3);
                        date = c.getTime();
                        tgl_selesai = dateFormat.format(date);
                        data[i][5]=tgl_selesai;
                        System.out.print("Tanggal selesai : "+dateFormat.format(date));
                        System.out.println("");
                        break;
                    case 2:
                        totalharga=kg*10000;
                        data[i][5]=String.valueOf(totalharga);
                        System.out.println("Total Biaya : "+(int)totalharga);
                        c.add(Calendar.DATE, 3);
                        date = c.getTime();
                        tgl_selesai = dateFormat.format(date);
                        data[i][6]=tgl_selesai;
                        System.out.print("Tanggal selesai : "+dateFormat.format(date));
                        System.out.println("");
                        break;
                    case 3:
                        totalharga=kg*7000;
                        data[i][5]=String.valueOf(totalharga);
                        System.out.println("Total Biaya : "+(int)totalharga);
                        c.add(Calendar.DATE, 3);
                        date = c.getTime();
                        tgl_selesai = dateFormat.format(date);
                        data[i][6]=tgl_selesai;
                        System.out.print("Tanggal selesai : "+dateFormat.format(date));
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Input tidak valid!!");
                        break;
                }
                i++;
            }while(pilihan<0|| pilihan>3);
            System.out.println("Ingin input lagi? (Y/N)");
            lagi = input.next();
        }while(lagi.equals("Y")||lagi.equals("y"));
        menu();
    }
       
    void show_data(){
        System.out.println("Nama\t\tTelp\t\tAlamat\t\tKg\t\tMasuk\t\t\tKeluar\t\t\tTotal");
        for(int j=0;j<i;j++){
            for(int k=0;k<7;k++){
                System.out.print(data[j][k]+"\t\t");
            }
            System.out.println("");
        }
        do{
            System.out.println("Kembali ke menu? (Y/N) ");
            lagi = input.next();
            if(lagi.equals("Y")||lagi.equals("y")){
                menu();
            }else{
                System.exit(0);
            }
        }while(lagi.equals("Y")||lagi.equals("y"));
    } 
    public static void keluar(){
           System.out.println("");
       }
    
}
