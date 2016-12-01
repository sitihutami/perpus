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
public class DAOMember {
    public static void insert(entity.Member b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("insert into member values(?,?,?,?,?,?)");
        p.setString(1, b.getKode());
        p.setString(2, b.getNama());
        p.setString(3, b.getAlamat());
        p.setString(4, b.getTelp());
        p.setString(5, b.getJk());
        p.setBoolean(6, b.isCekal());
        p.execute();
        p.close();
    }

    public static void delete(entity.Member b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("delete from member where kode=?");
        p.setString(1, b.getKode());
        p.execute();
        p.close();
    }

    public static void update(entity.Member a, entity.Member b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("update member set kode=?,nama=?,alamat=?,telp=?,jk=?,cekal=? where kode=?");
        p.setString(1, b.getKode());
        p.setString(2, b.getNama());
        p.setString(3, b.getAlamat());
        p.setString(4, b.getTelp());
        p.setString(5, b.getJk());
        p.setBoolean(6, b.isCekal());
        p.setString(7, a.getKode());
        p.execute();
        p.close();
    }

    public static java.util.List<entity.Member>kabehMember(util.Db d) throws SQLException{
        java.util.List<entity.Member>l=new java.util.LinkedList<entity.Member>();
        java.sql.ResultSet rs=d.getRS("select kode from member");
        while(rs.next())l.add(new entity.Member(rs.getString("kode"), d));
        rs.close();
        return l;
    }
}