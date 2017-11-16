package com.example.anhkhoa.diffutil;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    List<Student>listStudent;
    RecyclerView recyclerView;
    AdapterRecyclerView adapterRecyclerView;
    Button btnsorted,btnsortes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
        recyclerView.setAdapter(adapterRecyclerView);
    }

    private void addEvent() {
        btnsorted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterRecyclerView.dispath(getListStudentsorted());
                Toast.makeText(getApplicationContext(), "sorted", Toast.LENGTH_SHORT).show();
            }
        });
        btnsortes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterRecyclerView.dispath(getListStudentDesc());
                Toast.makeText(getApplicationContext(), "dasda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Student> getData() {
        ArrayList<Student>listStudent1=new ArrayList<>();
        listStudent1.add(new Student("Nguyen Lê Anh Khoa","14dthc04",1));
        listStudent1.add(new Student("Bui Hong Lân","14dthc04",2));
        listStudent1.add(new Student("Đặng Võ Hồng ĐĂng","14dthc04",3));
        listStudent1.add(new Student("Hồ Trung Hải","14dthc04",4));
        return listStudent1;
    }

    private void addControl() {
        btnsorted=findViewById(R.id.btnasc);
        btnsortes=findViewById(R.id.btndesc);
        listStudent=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        adapterRecyclerView=new AdapterRecyclerView(getData(),getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

    }


    List<Student>getListStudentsorted(){
        List<Student>list=getData();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return student.getTen().compareTo(t1.getTen());
            }
        });
        return list;
    }
    List<Student>getListStudentDesc(){
        List<Student>list=getData();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return student.getStt()-t1.getStt();
            }
        });
        return list;
    }
}
