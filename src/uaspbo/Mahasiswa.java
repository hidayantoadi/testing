package uaspbo;

import java.util.HashMap;

public class Mahasiswa extends Universitas{
    private String nim;
    private String nama;
    private String alamat;
    private Integer jurusan;
    private HashMap<Integer, String> namaJurusan = new HashMap<Integer, String>();
    
    
    public Mahasiswa(){
        namaJurusan.put(61,"MATEMATIKA");
        namaJurusan.put(62,"BIOLOGI");
        namaJurusan.put(63,"KIMIA");
        namaJurusan.put(64,"FISIKA");
        namaJurusan.put(65,"TEKNIK INFORMATIKA");
        namaJurusan.put(66,"TEKNIK ARSITEKTUR");
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getJurusan() {
        return jurusan;
    }

    public void setJurusan(Integer jurusan) {
        this.jurusan = jurusan;
    }

    public String getNamaJurusan(Integer kode){
        return namaJurusan.get(kode);
    }
    
    public HashMap<Integer, String> getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(HashMap<Integer, String> namaJurusan) {
        this.namaJurusan = namaJurusan;
    }
    
}
