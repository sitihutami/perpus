/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class Member {
    private String kode,nama,alamat,telp,jk;
    private boolean cekal;

    public Member(String kode, util.Db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement p=d.getPS("select*from member where kode=?");
        p.setString(1, kode);
        java.sql.ResultSet rs=p.executeQuery();
        if(rs.next()){
            nama=rs.getString("nama");
            alamat=rs.getString("alamat");
            telp=rs.getString("telp");
            jk=rs.getString("jk");
            cekal=rs.getBoolean("cekal");
        }rs.close();
        p.close();
    }

    public Member(String kode, String nama, String alamat, String telp, String jk) {
        this.kode = kode;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.jk = jk;
        cekal = false;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
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

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public boolean isCekal() {
        return cekal;
    }

    public void setCekal(boolean cekal) {
        this.cekal = cekal;
    }

    public java.util.List<Denda>pelanggaran(util.Db d) throws SQLException{
        java.util.List<Denda>l=new java.util.LinkedList<Denda>();
        java.sql.PreparedStatement p=d.getPS("select*from denda where member=?");
        p.setString(1, kode);
        java.sql.ResultSet r=p.executeQuery();
        while(r.next()){
            Denda b=new Denda(kode, r.getLong("bayar"));
            b.setDari(r.getDate("dari"));
            b.setKe(r.getDate("ke"));
            l.add(b);
        }r.close();
        p.close();
        return l;
    }

    public java.util.List<Pinjam>pinjaman(util.Db d) throws SQLException{
        java.util.List<Pinjam>l=new java.util.LinkedList<Pinjam>();
        java.sql.PreparedStatement p=d.getPS("select*from pinjam where member=?");
        p.setString(1, kode);
        java.sql.ResultSet r=p.executeQuery();
        while(r.next()){
            Pinjam b=new Pinjam();
            b.setBuku(r.getString("buku"));
            b.setKembali(r.getDate("kembali"));
            b.setKet(r.getString("ket"));
            b.setMember(kode);
            b.setPinjam(r.getDate("pinjam"));
            b.setTarget(r.getDate("target"));
            l.add(b);
        }r.close();
        p.close();
        return l;
    }
}