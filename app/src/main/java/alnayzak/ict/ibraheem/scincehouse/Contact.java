package alnayzak.ict.ibraheem.scincehouse;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.widget.Toast.LENGTH_LONG;

public class Contact extends AppCompatActivity {

    boolean network = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        Button send = findViewById(R.id.contacting_button_send);
        isNetworkAvailable();
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isNetworkAvailable();
                ToastMake();
                new Thread(new Runnable() {
                    public void run() {
                        boolean isNull = false;
                        EditText Name_field = findViewById(R.id.contacting_field_name);
                        String Name = Name_field.getText().toString();
                        EditText Subject_field = findViewById(R.id.contacting_field_subject);
                        String Subject = Subject_field.getText().toString();
                        EditText Message_field = findViewById(R.id.contacting_field_message);
                        String Message = Message_field.getText().toString();
                        EditText Phone_Number_Field = findViewById(R.id.contacting_field_phone_number);
                        String Phone_Number = Phone_Number_Field.getText().toString();
                        CharSequence text;
                        int duration = Toast.LENGTH_SHORT;
                        if (Name.matches("")) {
                            isNull = true;
                        } else if (Phone_Number.matches("")) {
                            isNull = true;
                        } else if (Subject.matches("")) {
                            isNull = true;
                        } else if (Message.matches("")) {
                            isNull = true;
                        } else if (isNull == false) {
                            try {
                                GMailSender sender = new GMailSender(getString(R.string.email),getString(R.string.pass));


                                sender.sendMail(Subject, Name + "\n"+ Phone_Number + "\n" + Message,

                                        getString(R.string.email), getString(R.string.email));


                            } catch (Exception e) {

                                Toast.makeText(getApplicationContext(), getString(R.string.err), LENGTH_LONG).show();


                            }
                        }

                    }

                }).start();

            }

        });


    }

    public void ToastMake() {
        final Context context = getApplicationContext();
        EditText Name_field = findViewById(R.id.contacting_field_name);
        String Name = Name_field.getText().toString();
        EditText Subject_field = findViewById(R.id.contacting_field_subject);
        String Subject = Subject_field.getText().toString();
        EditText Message_field = findViewById(R.id.contacting_field_message);
        String Message = Message_field.getText().toString();
        EditText Phone_Number_Field = findViewById(R.id.contacting_field_phone_number);
        String Phone_Number = Phone_Number_Field.getText().toString();
        String text = "";
        boolean isNull = false;
        if (!network) {
            text = getString(R.string.chckcon);
        } else if (Name.matches("")) {
            text = getString(R.string.errname);
            isNull = true;
        } else if (Phone_Number.matches("")) {
            text = getString(R.string.errnumber);
            isNull = true;
        } else if (Subject.matches("")) {
            text = getString(R.string.errsub);
            isNull = true;
        } else if (Message.matches("")) {
            text = getString(R.string.errmsg);
            isNull = true;
        } else if (isNull == false && network == true) {
            text = getString(R.string.sending);
        }
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            network = true;
        } else {
            network = false;
        }
    }
}