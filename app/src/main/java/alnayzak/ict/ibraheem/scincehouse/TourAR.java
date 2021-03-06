package alnayzak.ict.ibraheem.scincehouse;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class TourAR extends AppCompatActivity {
    int adults = 1;
    int kids = 1;
    boolean network = false;
    private static final String TAG = "TourAR";
    private TextView mDisplayDate;
    private String Date;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_tour_ar);
        isNetworkAvailable();
        mDisplayDate = findViewById(R.id.Booking_Date_ar);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        TourAR.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        Button plusA = findViewById(R.id.plus_adults_ar);
        Button minusA = findViewById(R.id.minusA_ar);
        Button plusK = findViewById(R.id.plusK_ar);
        Button plusKten = findViewById(R.id.plusKten_ar);
        Button minusK = findViewById(R.id.minusK_ar);
        Button minusKten = findViewById(R.id.minusKten_ar);
        plusA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (adults < 5) {
                    adults = adults + 1;
                    displayA(adults);
                } else {
                    Toast.makeText(getApplicationContext(), getText(R.string.errteacherar), Toast.LENGTH_LONG).show();
                }
            }
        });
        minusA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (adults > 0) {
                    adults = adults - 1;
                    displayA(adults);
                }
            }
        });
        plusK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (kids < 50) {
                    kids = kids + 1;
                    displayK(kids);
                } else {
                    Toast.makeText(getApplicationContext(), getText(R.string.errstudarplus), Toast.LENGTH_LONG).show();
                }
            }
        });
        plusKten.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (kids + 10 <= 50) {
                    kids = kids + 10;
                    displayK(kids);
                } else {
                    Toast.makeText(getApplicationContext(), getText(R.string.errstudarplus), Toast.LENGTH_LONG).show();
                }
            }
        });
        minusK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (kids > 1) {
                    kids = kids - 1;
                    displayK(kids);
                } else {
                    Toast.makeText(getApplicationContext(), getText(R.string.errstudentnegar), Toast.LENGTH_LONG).show();
                }
            }
        });
        minusKten.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (kids - 10 >= 1) {
                    kids = kids - 10;
                    displayK(kids);
                } else {
                    Toast.makeText(getApplicationContext(), getText(R.string.errstudentnegar), Toast.LENGTH_LONG).show();
                }
            }
        });
        Button Submit = findViewById(R.id.Booking_Tour_Submit_ar);
        Submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isNetworkAvailable();
                ToastMake();
                new Thread(new Runnable() {
                    public void run() {
                        Context context = getApplicationContext();
                        EditText Person_Name_field = findViewById(R.id.Booking_Person_Name_ar);
                        String PersonName = Person_Name_field.getText().toString();
                        EditText Person_Number_field = findViewById(R.id.Booking_Person_Number_ar);
                        String Person_Number = Person_Number_field.getText().toString();
                        EditText Person_City_field = findViewById(R.id.Booking_City_Name_ar);
                        String Person_City = Person_City_field.getText().toString();
                        EditText Organization_Name_Field = findViewById(R.id.Booking_ORG_Name_ar);
                        String Organization_Name = Organization_Name_Field.getText().toString();
                        EditText Organization_Number_Field = findViewById(R.id.Booking_ORG_Number_ar);
                        String Organization_Number = Organization_Number_Field.getText().toString();
                        boolean isNull = false;
                        if (PersonName.matches("")) {
                            isNull = true;
                        } else if (Person_Number.matches("")) {
                            isNull = true;
                        } else if (Person_City.matches("")) {
                            isNull = true;
                        } else if (Organization_Name.matches("")) {
                            isNull = true;
                        } else if (Organization_Number.matches("")) {
                            isNull = true;
                        } else if (adults == 0) {
                            isNull = true;
                        } else if (kids == 0) {
                            isNull = true;
                        } else if (isNull == false) {

                            try {

                                GMailSender sender = new GMailSender(getString(R.string.email),getString(R.string.pass));


                                sender.sendMail(getString(R.string.subject_booking),  Organization_Name + "\n" + Person_City + "\n" + mDisplayDate.getText() + "\n" + kids + "\n" + adults + " \n" + Organization_Number + "\n" + PersonName + " \n" + Person_Number,

                                        getString(R.string.email),getString(R.string.email));

                            } catch (Exception e) {

                                Toast.makeText(context, getString(R.string.errar), Toast.LENGTH_LONG).show();

                            }
                        }

                    }

                }).start();

            }
        });

    }

    private void displayA(int num) {
        TextView Adults_Number = findViewById(R.id.adultsN_ar);
        Adults_Number.setText("" + num);
    }


    private void displayK(int num) {
        TextView Kids_Number = findViewById(R.id.kidsN_ar);
        Kids_Number.setText("" + num);
        TextView Pay = findViewById(R.id.costs_ar);
        Pay.setText(getString(R.string.costar) + num * 12 + getString(R.string.nis));
    }

    public void ToastMake() {
        EditText Person_Name_field = findViewById(R.id.Booking_Person_Name_ar);
        String Name = Person_Name_field.getText().toString();
        EditText Person_Number_field = findViewById(R.id.Booking_Person_Number_ar);
        String Phone_Number = Person_Number_field.getText().toString();
        EditText Person_City_field = findViewById(R.id.Booking_City_Name_ar);
        String Person_City = Person_City_field.getText().toString();
        EditText Organization_Name_Field = findViewById(R.id.Booking_ORG_Name_ar);
        String Organization_Name = Organization_Name_Field.getText().toString();
        EditText Organization_Number_Field = findViewById(R.id.Booking_ORG_Number_ar);
        String Organization_Number = Organization_Number_Field.getText().toString();
        String text = "";
        boolean isNull = false;
        if (!network) {
            text = getString(R.string.errconar);
        } else if (Name.matches("")) {
            text = getString(R.string.errnamear);
            isNull = true;
        } else if (Phone_Number.matches("")) {
            text = getString(R.string.errnumberar);
            isNull = true;
        } else if (Person_City.matches("")) {
            text = getString(R.string.cityar);
            isNull = true;
        } else if (Organization_Name.matches("")) {
            text = getString(R.string.errschoolar);
            isNull = true;
        } else if (Organization_Number.matches("")) {
            text = getString(R.string.errschoolnumar);
            isNull = true;
        } else if (kids == 0) {
            text = getString(R.string.errstudnumar);
            isNull = true;
        } else if (isNull == false) {
            text = getString(R.string.sendingar);
        }
        Context context = getApplicationContext();
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