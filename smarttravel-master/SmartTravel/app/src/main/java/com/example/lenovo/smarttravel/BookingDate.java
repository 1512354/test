package com.example.lenovo.smarttravel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.eljoprifti.EljoPriftiEditText;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import io.blackbox_vision.materialcalendarview.view.CalendarView;

public class BookingDate extends AppCompatActivity implements View.OnClickListener {

    private static final String DATE_TEMPLATE = "dd/MM/yyyy";
    private static final String MONTH_TEMPLATE = "MMMM yyyy";
    private CalendarView calendarView;
    private TextView txtDate;
    private EljoPriftiEditText edt_rounded;
    ViewGroup transitionsContainer;

    //private TextView txtPriceAdult,txtPriceChild;
    private ElegantNumberButton numberButtonAdult,numberButtonChild;
    private EditText edtQuantityAdult, edtQuantityChild;
    private Button btnNext;
    private PopularActivityModel popularActivityModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_date);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendarView = (CalendarView) findViewById(R.id.calendar_view);
        txtDate = (TextView) findViewById(R.id.textviewDate);
        numberButtonAdult = (ElegantNumberButton) findViewById(R.id.number_button_adult);
        numberButtonChild = (ElegantNumberButton) findViewById(R.id.number_button_child);


        btnNext = (Button) findViewById(R.id.btnNext);

        //getIntent
         popularActivityModel = new PopularActivityModel();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            popularActivityModel = extras.getParcelable("activityModel");
        }

        Calendar disabledCal = Calendar.getInstance();
        disabledCal.set(Calendar.DATE, disabledCal.get(Calendar.DATE) - 1);

        calendarView.setFirstDayOfWeek(Calendar.SUNDAY)
                .setOnDateClickListener(this::onDateClick)
                .setOnMonthChangeListener(this::onMonthChange)
                .setOnDateLongClickListener(this::onDateLongClick)
                .setOnMonthTitleClickListener(this::onMonthTitleClick);

        if (calendarView.isMultiSelectDayEnabled()) {
            calendarView.setOnMultipleDaySelectedListener((month, dates) -> {
                //Do something with your current selection
            });
        }

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendarView.update(Calendar.getInstance(Locale.getDefault()));

        calendarView.shouldAnimateOnEnter(true);

        btnNext.setOnClickListener(this);


        numberButtonAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numberButtonAdult.getNumber();
                Toast.makeText(BookingDate.this, "Num:"+num, Toast.LENGTH_SHORT).show();
            }
        });
        numberButtonChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num2= numberButtonChild.getNumber();
                Toast.makeText(BookingDate.this, "Num2:"+num2, Toast.LENGTH_SHORT).show();
            }
        });





    }// onCreate




    private void onDateLongClick(@NonNull final Date date) {
        //txtDate.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onDateClick(@NonNull final Date date) {
        txtDate.setText("Date selected: "+formatDate(DATE_TEMPLATE, date));
    }

    private void onMonthTitleClick(@NonNull final Date date) {
        //Do something after month selection
    }

    private void onMonthChange(@NonNull final Date date) {
        final ActionBar actionBar = getSupportActionBar();

        if (null != actionBar) {
            String dateStr = formatDate(MONTH_TEMPLATE, date);
            dateStr = dateStr.substring(0, 1).toUpperCase() + dateStr.substring(1, dateStr.length());

            actionBar.setTitle(dateStr);
        }
    }

    private String formatDate(@NonNull String dateTemplate, @NonNull Date date) {
        return new SimpleDateFormat(dateTemplate, Locale.getDefault()).format(date);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btnNext:
                //Toast.makeText(this, "Next" + popularActivityModel.getTitle().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, BookingInforActivity.class);
                intent.putExtra("activityModel",popularActivityModel);
                startActivity(intent);
                break;

        }

    }//onClick

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }//onOptionItemSelected

}
