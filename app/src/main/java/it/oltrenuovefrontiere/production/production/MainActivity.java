package it.oltrenuovefrontiere.production.production;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openInserisci(View v) {
        Intent intInserisci = new Intent(MainActivity.this, Inserisci.class);
        startActivity(intInserisci);
    }
}
