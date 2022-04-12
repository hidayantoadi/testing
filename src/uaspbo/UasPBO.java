package uaspbo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javafx.application.Platform;

public class UasPBO {
    private static Matriks matriksM;
    private static int[][] matriksN;
    private static InputStreamReader in ;
    private static BufferedReader br ;
    private static ProsesDataMahasiswa pdm;
    
    private static Short pilihMenu(){
        short pilih = (short)0;
        System.out.println("============================");
        System.out.println("1. Pengolahan Data Matriks");
        System.out.println("2. Pengolahan Data Mahasiswa");
        System.out.println("0. Exit");
        System.out.println("============================");
        System.out.print("Pilih Menu : ");
        try{
            pilih = Short.valueOf(br.readLine());        
        }catch(IOException | NumberFormatException e){   
            System.out.println("Angka yang anda masukkan tidak valid");
        }        
        return pilih;
    }     
    
    private static Short pilihMenuDataMahasiswa(){
        short pilih = (short)0;
        System.out.println("============================");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Tampilkan Data Mahasiswa");
        System.out.println("0. Kembali Menu awal");
        System.out.println("============================");
        System.out.print("Pilih Menu : ");
        try{
            pilih = Short.valueOf(br.readLine());        
        }catch(IOException | NumberFormatException e){   
            System.out.println("Angka yang anda masukkan tidak valid");
        }        
        return pilih;
    }         
    
    public static void main(String[] args) {
        in = new InputStreamReader(System.in);
        br = new BufferedReader(in);
        Integer rowMatriks;
        Integer colMatriks;
        Integer colMatriksProc;
        
        switch (pilihMenu()){
            case 0 :
                Platform.exit();
                System.exit(0);
                break;
            case 1 : 
                try{
                    //Inisialisasi matriks M
                    System.out.print("Masukkan jumlah baris matriks :");
                    rowMatriks = Integer.valueOf(br.readLine());
                    System.out.print("Masukkan jumlah kolom matriks :");
                    colMatriks = Integer.valueOf(br.readLine());      
                    System.out.print("Masukkan kolom matriks yang diproses :");
                    colMatriksProc = Integer.valueOf(br.readLine());     
                    matriksM = new Matriks(rowMatriks, colMatriks);
                    //Input data ke matriks M
                    for(int row=0;row<rowMatriks;row++){
                        for(int col=0;col<colMatriks;col++){
                            System.out.print("baris-"+row+",kolom-"+col+"=");
                            matriksM.setMatriks(row, col, Integer.valueOf(br.readLine()));
                        }                                          
                    }                                                           
                    //Tampilkan data matriks M
                    System.out.println("Matriks M :");
                    for(int row=0;row<rowMatriks;row++){
                        for(int col=0;col<colMatriks;col++){
                            System.out.print(matriksM.getMatrks(row, col)+"\t");
                        }                                          
                        System.out.println("");                                
                    }                     
                    //urutkan matrik M -> matriks N
                    matriksN = matriksM.getMatriksN(colMatriksProc);
                    //Tampilkan data matriks N
                    System.out.println("Matriks N :");
                    for(int row=0;row<rowMatriks;row++){
                        for(int col=0;col<colMatriks;col++){
                            System.out.print(matriksN[row][col]+"\t");
                        }                                          
                        System.out.println("");                                
                    }                       
                }catch(NumberFormatException e){   
                    System.out.println("Angka yang anda masukkan tidak valid");
                }catch(IOException e){
                }    
                main(args);
                break;
            case 2 :        
                Short pilih = pilihMenuDataMahasiswa();
                pdm = new ProsesDataMahasiswa();
                while(pilih!=(short)0){
                    switch (pilih){
                        case 1 :
                            pdm.tambahData();
                            break;                            
                        case 2 :
                            pdm.tampilData();
                            break;
                        default :
                            System.out.println("Pilihan tidak ada, coba inputkan angka yang tepat");
                            break;
                    }
                    pilih = pilihMenuDataMahasiswa();
                }
                main(args);
                break;
            default :
                System.out.println("Pilihan tidak ada, coba inputkan angka yang tepat");
                main(args);
                break;                
        }
    }   
}