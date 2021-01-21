package com.java.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pembayaran")
public class Pembayaran {
	@Id
	private int id_pembayaran;
	private int id_pemesanan;
	private Date tanggal_pemesanan;
	private Date tanggal_pembayaran;
	private double nominal;
	private int status_pembayaran;
	public int getId_pembayaran() {
		return id_pembayaran;
	}
	public void setId_pembayaran(int id_pembayaran) {
		this.id_pembayaran = id_pembayaran;
	}
	public int getId_pemesanan() {
		return id_pemesanan;
	}
	public void setId_pemesanan(int id_pemesanan) {
		this.id_pemesanan = id_pemesanan;
	}
	public Date getTanggal_pemesanan() {
		return tanggal_pemesanan;
	}
	public void setTanggal_pemesanan(Date tanggal_pemesanan) {
		this.tanggal_pemesanan = tanggal_pemesanan;
	}
	public Date getTanggal_pembayaran() {
		return tanggal_pembayaran;
	}
	public void setTanggal_pembayaran(Date tanggal_pembayaran) {
		this.tanggal_pembayaran = tanggal_pembayaran;
	}
	public double getNominal() {
		return nominal;
	}
	public void setNominal(double nominal) {
		this.nominal = nominal;
	}
	public int getStatus_pembayaran() {
		return status_pembayaran;
	}
	public void setStatus_pembayaran(int status_pembayaran) {
		this.status_pembayaran = status_pembayaran;
	}
	
	

}
