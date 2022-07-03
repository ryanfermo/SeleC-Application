package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class archive_votes extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    ListView myListView;
    List<ItemsModel> archiveList;
    DatabaseReference archiveref;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    ListAdapter adapter;
    String pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_votes);
        ActivityCompat.requestPermissions(archive_votes.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        updateNavHeader();
        drawer=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        myListView=(ListView)findViewById(R.id.myListView);
        archiveList=new ArrayList<>();

        archiveref = FirebaseDatabase.getInstance().getReference("Archives");
        archiveref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                archiveList.clear();
                List<String> keys=new ArrayList<>();
                for(DataSnapshot transsnap: dataSnapshot.getChildren()){
                    keys.add(transsnap.getKey());
                    ItemsModel trans = transsnap.getValue(ItemsModel.class);
                    archiveList.add(trans);
                }

                adapter = new ListAdapter(archive_votes.this,archiveList);
                myListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ItemsModel trans =archiveList.get(position);
                showUpdateDialog(trans.getId(), trans.getPresident1(), trans.getPresident2(), trans.getVice1(), trans.getVice2(), trans.getSecretary1(), trans.getSecretary2(), trans.getTreasurer1(), trans.getTreasurer2(), trans.getAuditor1(),
                        trans.getAuditor2(), trans.getPro1(), trans.getPro2(), trans.getRep1(), trans.getRep2(), trans.getPresident11(), trans.getPresident21(), trans.getVice11(), trans.getVice21(), trans.getSecretary11(), trans.getSecretary21(),
                        trans.getTreasurer11(), trans.getTreasurer21(), trans.getAuditor11(), trans.getAuditor21(), trans.getPro11(), trans.getPro21(), trans.getRep11(), trans.getRep21(), trans.getArdate());
                return false;
            }
        });
    }

    private void showUpdateDialog(String id, String president1, String president2, String vice1, String vice2, String secretary1, String secretary2, String treasurer1, String treasurer2,
                                  String auditor1, String auditor2, String pro1, String pro2, String rep1, String rep2, String president11, String president21, String vice11, String vice21, String secretary11, String secretary21, String treasurer11, String treasurer21,
                                  String auditor11, String auditor21, String pro11, String pro21, String rep11, String rep21, String ardate) {
        AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View mDialogView = inflater.inflate(R.layout.update_dialog, null);
        mDialog.setView(mDialogView);
        Button btnDelete =mDialogView.findViewById(R.id.delete);
        Button createMYPDF =mDialogView.findViewById(R.id.save);
        pdf="STUDENT COUNCIL ELECTION RESULTS \n"+ardate+" \n \n TALLY VOTES: \n President Candidate1: "+president1+" \n Total Votes: "+president11 + " \n President Candidate2: "+president2+" \n Total Votes: "+president21
        +" \n Vice President Candidate1: "+vice1+" \n Total Votes: "+vice11+" \n Vice President Candidate2: "+vice2+" \n Total Votes: "+vice21+" \n Secretary Candidate1: "+secretary1+" \n Total Votes: "+secretary11
                +" \n Secretary Candidate2: "+secretary2+" \n Total Votes: "+secretary21+" \n Treasurer Candidate1: "+treasurer1+" \n Total Votes: "+treasurer11+" \n Treasurer Candidate2: "+treasurer2+" \n Total Votes: "+treasurer21
                +" \n Auditor Candidate1: "+auditor1+" \n Total Votes: "+auditor11+" \n Auditor Candidate2: "+auditor2+" \n Total Votes: "+auditor21+" \n PRO Candidate1: "+pro1+" \n Total Votes: "+pro11
                +" \n PRO Candidate2: "+pro2+" \n Total Votes: "+pro21+" \n Representative Candidate1: "+rep1+" \n Total Votes: "+rep11+" \n Representative Candidate2: "+rep2+" \n Total Votes: "+rep21;
        final AlertDialog alertDialog=mDialog.create();
        alertDialog.show();
        createMYPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfDocument myPdfDocument = new PdfDocument();
                PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300,600,1).create();
                PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

                Paint myPaint = new Paint();
                String myString = pdf;
                int x = 10, y=25;

                for (String line:myString.split("\n")){
                    myPage.getCanvas().drawText(line, x, y, myPaint);
                    y+=myPaint.descent()-myPaint.ascent();
                }

                myPdfDocument.finishPage(myPage);

                String myFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
                File myFile = new File(myFilePath, "SC-Election-Result.pdf");
                Toast.makeText(archive_votes.this, "Successfuly Saved", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
                try {
                    myPdfDocument.writeTo(new FileOutputStream(myFile));
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(archive_votes.this, "ERROR", Toast.LENGTH_SHORT).show();
                }

                myPdfDocument.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleterecord(id);
                alertDialog.dismiss();
            }

            private void deleterecord(String id) {
                DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference("Archives").child(id);
                Task<Void> mTask=databaseReference.removeValue();
                mTask.addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(archive_votes.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(archive_votes.this, "Error Deleting", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
            Intent intent4=new Intent(this,registered.class);
            startActivity(intent4);
            finish();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.admin_register:
                Intent intent=new Intent(this,registered.class);
                startActivity(intent);
                finish();
                break;
            case R.id.admin_update:
                Intent intent1=new Intent(this,content.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.admin_result:
                Intent intent2=new Intent(this,results.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.admin_chart:
                Intent intent5=new Intent(this,charting.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.admin_archive:
                Intent intent3=new Intent(this,archive_votes.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.appadmin:
                Intent intent4=new Intent(this,admin.class);
                startActivity(intent4);
                finish();
                break;
        }
        return true;
    }

    public void updateNavHeader(){
        navigationView=findViewById(R.id.nav_view);
        View HeaderView=navigationView.getHeaderView(0);
        TextView navUserName= HeaderView.findViewById(R.id.nav_username);
        ImageView imageview = (ImageView) HeaderView.findViewById(R.id.nav_imageView);
        imageview.setImageResource(R.drawable.selecprofileadmin);
        navUserName.setText("SeleC Admin");

    }
}