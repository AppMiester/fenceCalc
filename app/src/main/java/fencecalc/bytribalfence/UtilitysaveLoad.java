package fencecalc.bytribalfence;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class UtilitysaveLoad {








        public static List<Customer> loadContacts(Context context) {









            SharedPreferences sharedPreferences = context.getSharedPreferences("customer_file", MODE_PRIVATE);

            Gson gson = new Gson();

            String json = sharedPreferences.getString("customer_list_prefs", null);

            Type type = new TypeToken<ArrayList<Customer>>() {}.getType();



            ArrayList<Customer> temp = gson.fromJson(json, type);



            if(temp != null){

                return temp;

            }

            return new ArrayList<>();





        }





        public static void saveContacts(Context context, List<Customer> contact){





            Gson gson = new Gson();

            String json = gson.toJson(contact);



            SharedPreferences sharedPreferences = context.getSharedPreferences("customer_file", MODE_PRIVATE);



            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("customer_list_prefs",json);

            editor.apply();











        }
}
