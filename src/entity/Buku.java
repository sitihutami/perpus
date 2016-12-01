/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author ai
 */
public class Buku {
    private String kode,judul,pengarang,penerbit;
    private boolean pakai;
    private java.sql.Date masuk;

    public Buku(String kode, util.Db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement p=d.getPS("select*from buku where kode=?");
        p.setString(1, kode);
        java.sql.ResultSet rs=p.executeQuery();
        if(rs.next()){
            judul=rs.getString("judul");
            pengarang=rs.getString("pengarang");
            penerbit=rs.getString("penerbit");
            pakai=rs.getBoolean("pakai");
            masuk=rs.getDate("masuk");
        }rs.close();
        p.close();
    }

    public Buku(String kode, String judul, String pengarang, String penerbit) {
        this.kode = kode;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        pakai = false;
        masuk = java.sql.Date.valueOf(LocalDate.now());
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public boolean isPakai() {
        return pakai;
    }

    public void setPakai(boolean pakai) {
        this.pakai = pakai;
    }

    public java.sql.Date getMasuk() {
        return masuk;
    }

    public void setMasuk(java.sql.Date masuk) {
        this.masuk = masuk;
    }

    public java.util.List<Pinjam>pinjaman(util.Db d) throws SQLException{
        java.util.List<Pinjam>l=new java.util.LinkedList<Pinjam>();
        java.sql.PreparedStatement p=d.getPS("select*from pinjam where buku=?");
        p.setString(1, kode);
        java.sql.ResultSet r=p.executeQuery();
        while(r.next()){
            Pinjam b=new Pinjam();
            b.setBuku(kode);
            b.setKembali(r.getDate("kembali"));
            b.setKet(r.getString("ket"));
            b.setMember(r.getString("member"));
            b.setPinjam(r.getDate("pinjam"));
            b.setTarget(r.getDate("target"));
            l.add(b);
        }r.close();
        p.close();
        return l;
    }
}