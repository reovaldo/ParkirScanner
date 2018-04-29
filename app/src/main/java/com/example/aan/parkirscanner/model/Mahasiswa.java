package com.example.aan.parkirscanner.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Mahasiswa {
        @SerializedName("nim")
        public String nim;

        @SerializedName("nama")
        public String nama;

        @SerializedName("foto")
        public String foto;

        @SerializedName("plat")
        public String plat;

        @SerializedName("email")
        public String email;

        @SerializedName("nohp")
        public String nohp;

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

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
        }

        public String getPlat() {
            return plat;
        }

        public void setPlat(String plat) {
            this.plat = plat;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNohp() {
            return nohp;
        }

        public void setNohp(String nohp) {
            this.nohp = nohp;
        }

        public Mahasiswa(String nim, String nama, String foto, String plat, String email, String nohp) {
            this.nim = nim;
            this.nama = nama;
            this.foto = foto;
            this.plat = plat;
            this.email = email;
            this.nohp = nohp;
        }
}
