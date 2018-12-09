package alnayzak.ict.ibraheem.scincehouse;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class ContactAr extends AppCompatActivity {

    boolean network = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us_ar);
        Button send = findViewById(R.id.contacting_button_send_ar);
        isNetworkAvailable();
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isNetworkAvailable();
                ToastMake();
                new Thread(new Runnable() {
                    public void run() {
                        boolean isNull = false;
                        EditText Name_field = findViewById(R.id.contacting_field_name_ar);
                        String Name = Name_field.getText().toString();
                        EditText Subject_field = findViewById(R.id.contacting_field_subject_ar);
                        String Subject = Subject_field.getText().toString();
                        EditText Message_field = findViewById(R.id.contacting_field_message_ar);
                        String Message = Message_field.getText().toString();
                        EditText Phone_Number_Field = findViewById(R.id.contacting_field_phone_number_ar);
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
                                GMailSender sender = new GMailSender(

                                        "ScienceHouseGuests@gmail.com",

                                        "AlNayzak");


                                sender.sendMail(Subject, "Automated Header From Science House APP(Contact Us Section) \nSender Name Is :" + Name + "\nSenders Phone Number is :" + Phone_Number + "\n\nSenders Message :\n" + Message,

                                        "ScienceHouseGuests@gmail.com",
                                        // TODO Change the Receiver E-Mail to : ScienceHouse@alnayzak.org
                                        "ScienceHouseGuests@gmail.com");


                            } catch (Exception e) {

                                Toast.makeText(getApplicationContext(), "Error", LENGTH_LONG).show();


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
            text = "تحقق من اتصالك بالانترنت !";
        } else if (Name.matches("")) {
            text = "يبدو انك نسيت ادخال اسمك";
            isNull = true;
        } else if (Phone_Number.matches("")) {
            text = "يبدو انك نسيت ادخال رقم هاتفك";
            isNull = true;
        } else if (Subject.matches("")) {
            text = "يبدو انك نسيت ادخال الموضوع";
            isNull = true;
        } else if (Message.matches("")) {
            text = "لاتنسى كتابة الرسالة";
            isNull = true;
        } else if (isNull == false && network == true) {
            text = "يرسل ...";
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