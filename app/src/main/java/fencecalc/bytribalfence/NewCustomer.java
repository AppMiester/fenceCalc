package fencecalc.bytribalfence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewCustomer extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
    }

    public void goToMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void save(View view){
        EditText name = (EditText) findViewById(R.id.name);
        EditText phone = (EditText) findViewById(R.id.phone_number);
        EditText email = (EditText) findViewById(R.id.email);
        EditText street = (EditText) findViewById(R.id.street);
        EditText houseNumber = (EditText) findViewById(R.id.house_number);
        EditText city = (EditText) findViewById(R.id.city);

        Customer customer = new Customer(name.getText().toString(),phone.getText().toString(), email.getText().toString(),street.getText().toString(),houseNumber.getText().toString(),city.getText().toString());

        List<Customer> customerList = UtilitysaveLoad.loadContacts(context);
        String string = "";

//        for(int i = 0; i < customerList.size(); i++){
//            string += "\n" + customerList.get(i).name;
//        }
//        Toast toast = Toast.makeText(context, string, Toast.LENGTH_LONG);
//        toast.show();

        customerList.add(customer);
        UtilitysaveLoad.saveContacts(context, customerList);

        String nameContacts = name.getText().toString() + " " + houseNumber.getText().toString() + " " + street.getText().toString() + " " + city.getText().toString();

        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, nameContacts);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText().toString());

        startActivity(intent);

    }
}
