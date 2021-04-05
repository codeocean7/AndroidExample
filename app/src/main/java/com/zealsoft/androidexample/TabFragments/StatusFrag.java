package com.zealsoft.androidexample.TabFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.zealsoft.androidexample.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class  StatusFrag extends Fragment {

    CircleImageView imgProf;
    TextView txtEmail;

    FirebaseAuth mAuth;

    Context ctx;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_status,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgProf=view.findViewById(R.id.imgProfile);
        txtEmail=view.findViewById(R.id.txtEmail);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();

        Uri photoUrl=user.getPhotoUrl();

        Glide.with(ctx)
                .load(photoUrl)
                .into(imgProf);

        txtEmail.setText(user.getEmail());
    }
}
