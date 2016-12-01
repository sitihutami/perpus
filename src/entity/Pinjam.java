/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ai
 */
public class Pinjam {
    private String member,buku,ket;
    private java.sql.Date pinjam,kembali,target;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getBuku() {
        return buku;
    }

    public void setBuku(String buku) {
        this.buku = buku;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public java.sql.Date getPinjam() {
        return pinjam;
    }

    public void setPinjam(java.sql.Date pinjam) {
        this.pinjam = pinjam;
    }

    public java.sql.Date getKembali() {
        return kembali;
    }

    public void setKembali(java.sql.Date kembali) {
        this.kembali = kembali;
    }

    public java.sql.Date getTarget() {
        return target;
    }

    public void setTarget(java.sql.Date target) {
        this.target = target;
    }
}