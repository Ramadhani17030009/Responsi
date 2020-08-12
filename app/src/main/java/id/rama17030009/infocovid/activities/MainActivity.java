package id.rama17030009.infocovid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import id.rama17030009.infocovid.LoginActivity;
import id.rama17030009.infocovid.Preferences;
import id.rama17030009.infocovid.R;
import id.rama17030009.infocovid.fragment.CountryFragment;
import id.rama17030009.infocovid.fragment.RingkasanFragment;
import id.rama17030009.infocovid.fragment.RiwayatFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    TextView tvToday;
    String hariIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                finish();
            }
        });


        if (savedInstanceState == null) {
            RingkasanFragment ringkasanFragment = new RingkasanFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.flMain, ringkasanFragment)
                    .commit();
        }

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        hariIni = (String) DateFormat.format("EEEE", dateNow);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getToday();

    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d MMMM yyyy", date);
        String formatFix = hariIni + ", " + tanggal;
        tvToday.setText(formatFix);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.summaryMenu:
                RingkasanFragment ringkasanFragment = new RingkasanFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, ringkasanFragment)
                        .commit();
                return true;

            case R.id.summaryIdnMenu:
                CountryFragment countryFragment = new CountryFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, countryFragment)
                        .commit();
                return true;

            case R.id.historyMenu:
                RiwayatFragment riwayatFragment = new RiwayatFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, riwayatFragment)
                        .commit();
                return true;
        }
        return false;
    }


}