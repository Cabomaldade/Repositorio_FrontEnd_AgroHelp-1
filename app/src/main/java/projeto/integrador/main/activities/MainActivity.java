package projeto.integrador.main.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projeto.integrador.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // mudado para login para testes retrofit
    }
}