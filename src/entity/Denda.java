/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author ai
 */
public class Denda {
    private String member;
    private java.sql.Date dari,ke;
    private long bayar;

    public Denda(String member, long bayar) {
        this.member = member;
        this.bayar = bayar;
        dari = java.sql.Date.valueOf(LocalDate.now());
        ke = null;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public java.sql.Date getDari() {
        return dari;
    }

    public void setDari(java.sql.Date dari) {
        this.dari = dari;
    }

    public java.sql.Date getKe() {
        return ke;
    }

    public void setKe(java.sql.Date ke) {
        this.ke = ke;
    }

    public long getBayar() {
        return bayar;
    }

    public void setBayar(long bayar) {
        this.bayar = bayar;
    }
}