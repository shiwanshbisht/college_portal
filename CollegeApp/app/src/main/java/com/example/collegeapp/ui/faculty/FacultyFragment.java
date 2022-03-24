
package com.example.collegeapp.ui.faculty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment,mechanicalDepartment,civilDepartment,chemicalDepartment;
    private LinearLayout csNoData,mechanicalNoData,civilNoData,chemicalNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private TeacherAdapter  adapter;

    private DatabaseReference reference,dbRef;

    public FacultyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);


        chemicalNoData=view.findViewById(R.id.chemicalNoData);
        csNoData=view.findViewById(R.id.csNoData);
        mechanicalNoData=view.findViewById(R.id.mechanicalNoData);
        civilNoData=view.findViewById(R.id.civilNoData);


        csDepartment=view.findViewById(R.id.csDepartment);
        mechanicalDepartment=view.findViewById(R.id.mechanicalDepartment);
        civilDepartment=view.findViewById(R.id.civilDepartment);
        chemicalDepartment=view.findViewById(R.id.chemicalDepartment);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        mechanicalDepartment();
        civilDepartment();
        chemicalDepartment();

       return view;
    }

    private void csDepartment() {

        dbRef=reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list1=new ArrayList<>();
                if(!datasnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mechanicalDepartment() {

        dbRef=reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot datasnapshot) {
                list2=new ArrayList<>();
                if(!datasnapshot.exists()){
                    mechanicalNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else{
                    mechanicalNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list2,getContext());
                    mechanicalDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void civilDepartment() {

        dbRef=reference.child("Civil");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot datasnapshot) {
                list3=new ArrayList<>();
                if(!datasnapshot.exists()){
                    civilNoData.setVisibility(View.VISIBLE);
                    civilDepartment.setVisibility(View.GONE);
                }else{
                    civilNoData.setVisibility(View.GONE);
                    civilDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    civilDepartment.setHasFixedSize(true);
                    civilDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list3,getContext());
                    civilDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void chemicalDepartment() {

        dbRef=reference.child("Chemical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot datasnapshot) {
                list4=new ArrayList<>();
                if(!datasnapshot.exists()){
                    chemicalNoData.setVisibility(View.VISIBLE);
                    chemicalDepartment.setVisibility(View.GONE);
                }else{
                    chemicalNoData.setVisibility(View.GONE);
                    chemicalDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    chemicalDepartment.setHasFixedSize(true);
                    chemicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list4,getContext());
                    chemicalDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}