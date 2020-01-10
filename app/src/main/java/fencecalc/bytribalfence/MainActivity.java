package fencecalc.bytribalfence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToNewCustomer(View view){

        Intent intent = new Intent(this,NewCustomer.class);
        startActivity(intent);

    }

    public void goToCustomerView(View view){

        Intent intent = new Intent(this, Customerview.class);
        startActivity(intent);

    }
}
