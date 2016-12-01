/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class DAOBuku {
    public static void insert(entity.Buku b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("insert into buku values(?,?,?,?,?,?)");
        p.setString(1, b.getKode());
        p.setString(2, b.getJudul());
        p.setString(3, b.getPengarang());
        p.setString(4, b.getPenerbit());
        p.setBoolean(5, b.isPakai());
        p.setDate(6, b.getMasuk());
        p.execute();
        p.close();
    }

    public static void delete(entity.Buku b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("delete from buku where kode=?");
        p.setString(1, b.getKode());
        p.execute();
        p.close();
    }

    public static void update(entity.Buku a, entity.Buku b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("update buku set kode=?,judul=?,pengarang=?,penerbit=?,pakai=?,masuk=? where kode=?");
        p.setString(1, b.getKode());
        p.setString(2, b.getJudul());
        p.setString(3, b.getPengarang());
        p.setString(4, b.getPenerbit());
        p.setBoolean(5, b.isPakai());
        p.setDate(6, b.getMasuk());
        p.setString(7, a.getKode());
        p.execute();
        p.close();
    }

    public static java.util.List<entity.Buku>kabehBuku(util.Db d) throws SQLException{
        java.util.List<entity.Buku>l=new java.util.LinkedList<entity.Buku>();
        java.sql.ResultSet rs=d.getRS("select kode from buku");
        while(rs.next())l.add(new entity.Buku(rs.getString("kode"), d));
        rs.close();
        return l;
    }
}