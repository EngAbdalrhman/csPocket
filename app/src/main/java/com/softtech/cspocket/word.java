package com.softtech.cspocket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class word extends AppCompatActivity {
    EditText editText;
    Spinner size_spinner;
    Spinner color_spinner;
    Spinner font_spinner;
    //Button btn_left;
    //Button btn_ce;
    //Button btn_r;
    //Button btn_new;
    //Button btn_save;
    //Button btn_load;
    CheckBox chk_bold;
    CheckBox chk_I;
    CheckBox chk_u;
    EditText fName;
    int Storage_permission_code = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        editText = findViewById(R.id.editText);
        size_spinner = findViewById(R.id.size_spinner);
        chk_bold = findViewById(R.id.chk_bold);
        chk_I = findViewById(R.id.chk_I);
        chk_u = findViewById(R.id.chk_u);
        color_spinner = findViewById(R.id.color_spinner);
        font_spinner = findViewById(R.id.font_spinner);
        //btn_left = findViewById(R.id.btn_left);
        //btn_ce = findViewById(R.id.btn_ce);
        //btn_r = findViewById(R.id.btn_r);
        fName = findViewById(R.id.fName);
        //btn_new = findViewById(R.id.btn_new);
        //btn_save = findViewById(R.id.btn_save);
        //btn_load = findViewById(R.id.btn_load);
        chk_bold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectFont();
                // bold();
                // bolditalic();
            }
        });
        chk_u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                under_line();
            }
        });
        chk_I.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //italic();
                //bolditalic();
                selectFont();
            }
        });
        size_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectSize();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        color_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectColor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        font_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectFont();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        fillcolor();
        fillsize();
        fillfonts();
    }
    void fillcolor(){
        String[] colors = {"black","red","green","blue","yellow","gray","orange","pink"};
        ArrayAdapter<String> adabter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item,colors);
        color_spinner.setAdapter(adabter);
    }
    void fillsize(){
        String[] size = {"14","16","18","20","22","24","26","28","30","32","34","36"};
        ArrayAdapter<String> adabter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item,size);
        size_spinner.setAdapter(adabter);

    }
    void fillfonts(){
        String[] fonts = {"default","AdobeClean_Regular","AdobeDevanagari_Regular","arial","ariblk","BAUHS93","BERNHC","BRADHITC","ARIALN","calibriz","COOPBL","CURLZ"};
        ArrayAdapter<String> adabter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item,fonts);
        font_spinner.setAdapter(adabter);

    }
    void bold(){
        if (chk_bold.isChecked()){

                editText.setTypeface(null,Typeface.BOLD);
        }
        else {
                editText.setTypeface(null,Typeface.NORMAL);
        }
    }
    void under_line(){
        if (chk_u.isChecked()){
            editText.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG) ;
        }
        else {
            editText.setPaintFlags(Paint.LINEAR_TEXT_FLAG);
        }
    }
    void italic(){
        if (chk_I.isChecked()){
            editText.setTypeface(null,Typeface.ITALIC);
        }
        else {
            editText.setTypeface(null,Typeface.NORMAL);
        }
    }
    void bolditalic(){
        if (chk_bold.isChecked() && chk_I.isChecked()){
            editText.setTypeface(null,Typeface.BOLD_ITALIC);
        }
    }
    void selectColor()
    {
        String selected_color = color_spinner.getSelectedItem().toString();
        switch (selected_color)
        {
            case "black":
                editText.setTextColor(getResources().getColor(R.color.black));
                break;
            case "red":
                editText.setTextColor(getResources().getColor(R.color.red));
                break;
            case "green":
                editText.setTextColor(getResources().getColor(R.color.green));
                break;
            case "blue":
                editText.setTextColor(getResources().getColor(R.color.blue));
                break;
            case "yellow":
                editText.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case "gray":
                editText.setTextColor(getResources().getColor(R.color.gray));
                break;
            case "orange":
                editText.setTextColor(getResources().getColor(R.color.orange));
                break;
            case "pink":
                editText.setTextColor(getResources().getColor(R.color.pink));
                break;
        }
    }
    void selectFont()
    {
        String selected_font = font_spinner.getSelectedItem().toString();
        Typeface tf = Typeface.DEFAULT;
        switch (selected_font)
        {
            case "default":
                tf = Typeface.DEFAULT;
                break;
            case "AdobeClean_Regular":
                tf = Typeface.createFromAsset(getAssets(), "AdobeClean_Regular.otf");
                break;
            case "AdobeDevanagari_Regular":
                tf = Typeface.createFromAsset(getAssets(), "AdobeDevanagari_Regular.otf");
                break;
            case "arial":
                tf = Typeface.createFromAsset(getAssets(), "arial.ttf");
                break;
            case "ariblk":
                tf = Typeface.createFromAsset(getAssets(), "ariblk.ttf");
                break;
            case "BAUHS93":
                tf = Typeface.createFromAsset(getAssets(), "BAUHS93.TTF");
                break;
            case "BERNHC":
                tf = Typeface.createFromAsset(getAssets(), "BERNHC.TTF");
                break;
            case "BRADHITC":
                tf = Typeface.createFromAsset(getAssets(), "BRADHITC.TTF");
                break;

            case "ARIALN":
                tf = Typeface.createFromAsset(getAssets(), "ARIALN.TTF");
                break;
            case "calibriz":
                tf = Typeface.createFromAsset(getAssets(), "calibriz.ttf");
                break;
            case "COOPBL":
                tf = Typeface.createFromAsset(getAssets(), "COOPBL.TTF");
                break;
            case "CURLZ":
                tf = Typeface.createFromAsset(getAssets(), "CURLZ.TTF");
                break;
        }
        //editText.setTypeface(tf);
        fontDesign(tf);
    }
    void selectSize()
    {// TODO USE BUTTONS
        String selected_size = size_spinner.getSelectedItem().toString();
        switch (selected_size)
        {
            case "14":
                editText.setTextSize(14f);
                break;
            case "16":
                editText.setTextSize(16f);
                break;
            case "18":
                editText.setTextSize(18f);
                break;
            case "20":
                editText.setTextSize(20f);
                break;
            case "22":
                editText.setTextSize(22f);
                break;
            case "24":
                editText.setTextSize(24f);
                break;
            case "26":
                editText.setTextSize(26f);
                break;
            case "28":
                editText.setTextSize(28f);
                break;
            case "30":
                editText.setTextSize(30f);
                break;
            case "32":
                editText.setTextSize(32f);
                break;
            case "34":
                editText.setTextSize(34f);
                break;
            case "36":
                editText.setTextSize(36f);
                break;
        }
    }
    void fontDesign(Typeface typeface){
        if (chk_bold.isChecked() && chk_I.isChecked()){
            editText.setTypeface(typeface,Typeface.BOLD_ITALIC);
        }

        else if (chk_bold.isChecked())
        {
            editText.setTypeface(typeface,Typeface.BOLD);
        }

       else if (chk_I.isChecked())
       {
            editText.setTypeface(typeface,Typeface.ITALIC);
       }
        else {
            editText.setTypeface(typeface,Typeface.NORMAL);
        }


    }

    public void left_aligen(View view) {
        editText.setGravity(Gravity.LEFT);
    }

    public void center_aligen(View view) {
        editText.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    public void right_aligen(View view) {
        editText.setGravity(Gravity.RIGHT);
    }

    public void newFile(View view) {
        editText.setText(null);
        chk_bold.setChecked(false);
        chk_I.setChecked(false);
        chk_u.setChecked(false);
        size_spinner.setSelection(0);
        selectFont();
        color_spinner.setSelection(0);
        font_spinner.setSelection(0);
        selectSize();
        selectColor();
        editText.setGravity(Gravity.LEFT);
        fName.setText(null);
        editText.requestFocus();
    }

    public void saved(View view) {
        check_Permission();
        if (fName.getText().toString().trim() == null) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_LONG).show();
            editText.requestFocus();
        }
        else {
            try {
                String path = Environment.getExternalStorageDirectory().getPath() +"/CSPocket";
                File file = new File(path);
                file.mkdir();
                PrintWriter printWriter = new PrintWriter(path + "/"+ fName.getText().toString() + ".txt");
                printWriter.write(editText.getText().toString());
                printWriter.close();
                Toast.makeText(this, "Saved ^^", Toast.LENGTH_LONG).show();
            }
            catch (Exception exception)
            {
                Log.e("cs","save",exception);
            }

        }
    }
    public void load(View view) {
        check_Permission();
        try {
            String path = Environment.getExternalStorageDirectory().getPath() +"/CSPocket";
            FileReader fileReader = new FileReader(path + "/"+ fName.getText().toString() + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String contact = "";
            while ((line =  bufferedReader.readLine()) != null)
            {
                contact += line + "\n";
            }
            fileReader.close();
            bufferedReader.close();
            editText.setText(contact);
            Toast.makeText(this, "Loaded ^^", Toast.LENGTH_LONG).show();
        }
        catch (Exception exception)
        {
            Log.e("cs","load",exception);
        }
    }
    void check_Permission()
    {
        if(ContextCompat.checkSelfPermission(word.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
        {
            Log.e("cs","Permission Granted");
        }
        else
            {
                requestStoragePermissions();
            }
    }
    void requestStoragePermissions()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this ,Manifest.permission.READ_EXTERNAL_STORAGE))
        {
            new AlertDialog.Builder(this).setTitle("Permission Needed").setMessage("You should give the Permission").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(word.this , new String [] {Manifest.permission.READ_EXTERNAL_STORAGE},Storage_permission_code);

                }
            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }
        else  {
            ActivityCompat.requestPermissions(this , new String [] {Manifest.permission.READ_EXTERNAL_STORAGE},Storage_permission_code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Storage_permission_code)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Log.e("cs","Permission Granted");
            }
            else {
                Log.e("cs","Permission Dined");
            }
        }
    }
}