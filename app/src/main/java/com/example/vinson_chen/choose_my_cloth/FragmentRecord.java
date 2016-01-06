package com.example.vinson_chen.choose_my_cloth;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Vinson_Chen on 2016/1/4.
 */
public class FragmentRecord extends Fragment {

    private Button bt_save,bt_choose_img;
    private ImageView imgview;
    private static final int SELECT_PICTURE = 1;

    private String selectedImagePath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.layout_fragment_record, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onStart(){
        super.onStart();

    }

    @Override
    public void onResume(){
        super.onResume();

        setView();
        setListener();

    }

    public void setView(){
        bt_save = (Button)getActivity().findViewById(R.id.button_save);
        bt_choose_img = (Button)getActivity().findViewById(R.id.button_find_image);
        imgview = (ImageView)getActivity().findViewById(R.id.imageView);
    }

    public void setListener(){

        bt_choose_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // in onCreate or any event where your want the user to
                // select a file
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE);
            }
        });



    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                imgview.setImageURI(selectedImageUri);
//                selectedImagePath = getPath(selectedImageUri);
            }
        }
    }


}
