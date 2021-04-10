package com.zealsoft.androidexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.potyvideo.library.AndExoPlayerView;
import com.potyvideo.library.globalInterfaces.ExoPlayerCallBack;

public class VideoUploadActivity extends AppCompatActivity{

    Button btnSelectVideo;
    private int RC_VIDEO=52;
    private Uri videoUri;

    AndExoPlayerView videoPlayer;

    StorageReference mStRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_upload);

        btnSelectVideo=findViewById(R.id.btnSelectVideo);
        videoPlayer=findViewById(R.id.andExoPlayerView);

        videoPlayer.setExoPlayerCallBack(new ExoPlayerCallBack() {
            @Override
            public void onError() {
                Toast.makeText(VideoUploadActivity.this,"Play Error..",Toast.LENGTH_LONG).show();
            }
        });

        mStRef= FirebaseStorage.getInstance().getReference();

        btnSelectVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectVideo();
            }
        });
    }

    private  void selectVideo(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("video/*");
        startActivityForResult(intent,RC_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RC_VIDEO){
            videoUri=data.getData();
            uploadVideo();
        }
    }

    private  void uploadVideo(){

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        StorageReference videoRef=mStRef.child(videoUri.getLastPathSegment()+".mp4");
        videoRef.putFile(videoUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(VideoUploadActivity.this,"Upload Successful..",Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                        videoRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String videoURL=uri.toString();
                                videoPlayer.setSource(videoURL);
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(VideoUploadActivity.this,"Upload Fail..",Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                progressDialog.setMessage("Uploaded " + (int)progress + "%");

            }
        });
    }
}

