package com.java.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pemesanan_produk")
public class Pemesanan {
	@Id
	private int id_pemesanan;
	private int id_produk;
	private int id_user;
	private Date tanggal_pemesanan;
	private double jumlah_harga;
	private int status_bayar;
	private int status_produk;
	public int getId_pemesanan() {
		return id_pemesanan;
	}
	public void setId_pemesanan(int id_pemesanan) {
		this.id_pemesanan = id_pemesanan;
	}
	public int getId_produk() {
		return id_produk;
	}
	public void setId_produk(int id_produk) {
		this.id_produk = id_produk;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public Date getTanggal_pemesanan() {
		return tanggal_pemesanan;
	}
	public void setTanggal_pemesanan(Date tanggal_pemesanan) {
		this.tanggal_pemesanan = tanggal_pemesanan;
	}
	public double getJumlah_harga() {
		return jumlah_harga;
	}
	public void setJumlah_harga(double jumlah_harga) {
		this.jumlah_harga = jumlah_harga;
	}
	public int getStatus_bayar() {
		return status_bayar;
	}
	public void setStatus_bayar(int status_bayar) {
		this.status_bayar = status_bayar;
	}
	public int getStatus_produk() {
		return status_produk;
	}
	public void setStatus_produk(int status_produk) {
		this.status_produk = status_produk;
	}

	
}
