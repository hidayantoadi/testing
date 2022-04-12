package uaspbo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ProsesDataMahasiswa {

    private Mahasiswa mahasiswa;
    private static InputStreamReader in;
    private static BufferedReader br;
    private ArrayList<Mahasiswa> daftarMahasiswa;
    private String jawab;

    public ProsesDataMahasiswa() {
        mahasiswa = new Mahasiswa();
        daftarMahasiswa = new ArrayList<Mahasiswa>();
        in = new InputStreamReader(System.in);
        br = new BufferedReader(in);
        setJawab("Y");
    }

    public void tambahData() {
        setJawab("Y");
        boolean benar = false;
        mahasiswa = new Mahasiswa();
        while (getJawab().equalsIgnoreCase("Y")) {
            try {
                System.out.print("Nama Universitas\t: ");
                mahasiswa.setNamaUniversitas(br.readLine());
                System.out.print("NIM\t\t\t: ");
                mahasiswa.setNim(br.readLine());
                System.out.print("Nama\t\t\t: ");
                mahasiswa.setNama(br.readLine());
                System.out.print("Alamat\t\t\t: ");
                mahasiswa.setAlamat(br.readLine());
                while(!benar){
                    System.out.print("Jurusan\t\t\t: ");
                    mahasiswa.setJurusan(Integer.valueOf(br.readLine()));
                    if(mahasiswa.getJurusan()>=61 && mahasiswa.getJurusan()<=66){
                        benar = true;
                    }else{
                        System.out.println("Kode jurusan tidak valid (kode jurusan harus bernilai >= 61 dan <= 66");
                    }    
                }
                System.out.print("Apakah Anda ingin memasukkan data lagi ? (Y=Ya;T=Tidak) : ");
                setJawab(br.readLine());
                getDaftarMahasiswa().add(mahasiswa);
                if (getJawab().equalsIgnoreCase("Y")) {
                    mahasiswa = new Mahasiswa();
                    benar = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Kode jurusan yang anda masukkan tidak valid");
            } catch (IOException e) {
            }
        }
    }

    public void tampilData() {
        if(getDaftarMahasiswa().size()==0){
        System.out.println("==============================================");
        System.out.println("Data Mahasiswa kosong");
        }else{
            for (Mahasiswa mhs : getDaftarMahasiswa()) {
                System.out.println("==============================================");
                System.out.println("Nama Universitas\t: " + mhs.getNamaUniversitas());
                System.out.println("NIM\t\t\t: " + mhs.getNim());
                System.out.println("Nama\t\t\t: " + mhs.getNama());
                System.out.println("Alamat\t\t\t: " + mhs.getAlamat());
                System.out.println("Jurusan\t\t\t: " + mhs.getNamaJurusan(mhs.getJurusan()));
            }
        }
        System.out.println("==============================================");
    }

    public String getJawab() {
        return jawab;
    }

    public void setJawab(String jawab) {
        this.jawab = jawab;
    }

    public ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public void setDaftarMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }
}
