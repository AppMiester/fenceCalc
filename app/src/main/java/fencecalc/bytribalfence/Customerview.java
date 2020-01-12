package fencecalc.bytribalfence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Customerview extends AppCompatActivity {

    Context context = this;
    List<Customer> customers;

    static String nameHolder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerview);

        loadContacts();
        ListView listView = (ListView) findViewById(R.id.customer_list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }


    public void loadContacts(){
       customers = UtilitysaveLoad.loadContacts(context);
    }
    public int getCustomersSize(){
        return customers.size();
    }

    public void customerViewEdit(View v) {


        LinearLayout viewParentRow = (LinearLayout) v.getParent();


        TextView textViewName = (TextView) viewParentRow.getChildAt(0);




        nameHolder = textViewName.getText().toString();

        Intent intent = new Intent(this,ViewEditCustomer.class);
        startActivity(intent);





    }






//---------custom adapter class
    class CustomAdapter extends BaseAdapter{
        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customcustomerview, null);

            TextView name =(TextView) convertView.findViewById(R.id.name);
            TextView address =(TextView) convertView.findViewById(R.id.address);

            name.setText(customers.get(position).name);
            address.setText(customers.get(position).houseNumber + " " + customers.get(position).street + "\n" + customers.get(position).city);

            return convertView;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
           return getCustomersSize();
        }
    }
}
