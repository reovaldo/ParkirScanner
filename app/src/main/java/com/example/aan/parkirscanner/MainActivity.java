package com.example.aan.parkirscanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aan.parkirscanner.model.Items;
import com.example.aan.parkirscanner.model.Mahasiswa;
import com.example.aan.parkirscanner.rest.ApiClient;
import com.example.aan.parkirscanner.rest.ApiInterface;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

import br.com.felix.imagezoom.ImageZoom;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.textViewNama)
    TextView textViewNama;
    @BindView(R.id.textViewNIM)
    TextView textViewNIM;
    @BindView(R.id.textViewplat)
    TextView textViewplat;
    @BindView(R.id.textViewnohp)
    TextView textViewnohp;
    @BindView(R.id.textViewEmail)
    TextView textViewemail;
    @BindView(R.id.buttonScan)
    Button buttonScan;
    private ImageView imageView;

    private IntentIntegrator intentIntegrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.foto);
        ButterKnife.bind(this);
        buttonScan.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        // inisialisasi IntentIntegrator(scanQR)
        intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.initiateScan();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();
            }else{
                // jika qrcode berisi data
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                Call<Items> call = apiService.getDataMahasiswa(result.getContents());

                //Call<Items> call = apiService.getDataMahasiswa(getString(IntentIntegrator.));

                call.enqueue(new Callback<Items>() {
                    @Override
                    public void onResponse(Call<Items> call, Response<Items> response) {
                        List<Mahasiswa> mahasiswa = response.body().getItems();
                        loadData(mahasiswa);
                    }

                    @Override
                    public void onFailure(Call<Items> call, Throwable t) {

                    }
                });
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void loadData(List<Mahasiswa> mahasiswa) {
        for (Mahasiswa data : mahasiswa) {
                            textViewNama.setText(data.getNama());
                            textViewNIM.setText(data.getNim());
                            textViewnohp.setText(data.getNohp());
                            textViewemail.setText(data.getEmail());
                            textViewplat.setText(data.getPlat());
                            Picasso.with(this).load(data.getFoto()).into(imageView);
        }
    }


}