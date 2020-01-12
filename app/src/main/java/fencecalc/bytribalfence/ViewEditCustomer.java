package fencecalc.bytribalfence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewEditCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_edit_customer);
        setName();
    }



    public void setName(){
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(Customerview.nameHolder);
    }
}
