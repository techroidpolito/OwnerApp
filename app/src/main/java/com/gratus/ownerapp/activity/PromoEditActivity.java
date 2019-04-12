package com.gratus.ownerapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.gratus.ownerapp.R;
import com.gratus.ownerapp.model.PromoCodeModel;
import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PromoEditActivity extends AppCompatActivity {
    private EditText promoEt,et_discount,et_condition,desEt;
    private Button saveBt;
    private ArrayList<PromoCodeModel> promoCodeModels = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_edit);
        promoEt = findViewById(R.id.promoEt);
        et_discount = findViewById(R.id.et_discount);
        et_condition = findViewById(R.id.et_condition);
        desEt = findViewById(R.id.desEt);
        saveBt = findViewById(R.id.saveBt);


        if(getIntent().getSerializableExtra("promomodel")!=null){
            promoCodeModels = (ArrayList<PromoCodeModel>) getIntent().getSerializableExtra("promomodel");
        }
        if(promoCodeModels.size()>0){
            if(promoCodeModels.get(0).getPromoName()!=null && !promoCodeModels.get(0).getPromoName().isEmpty()) {
                promoEt.setText(promoCodeModels.get(0).getPromoName());
            }
            if(promoCodeModels.get(0).getCondition()!=null && !promoCodeModels.get(0).getCondition().isEmpty()) {
                et_condition.setText(promoCodeModels.get(0).getCondition());
            }
            if(promoCodeModels.get(0).getDiscount()!=null && !promoCodeModels.get(0).getDiscount().isEmpty()) {
                et_discount.setText(promoCodeModels.get(0).getDiscount());
            }
            if(promoCodeModels.get(0).getDescription()!=null && !promoCodeModels.get(0).getDescription().isEmpty()) {
                desEt.setText(promoCodeModels.get(0).getDescription());
            }
        }
        if (savedInstanceState != null) {
        }
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSave();
            }
        });
    }

    private void setSave() {
        promoCodeModels = new ArrayList<>();
        if(setValidation()) {
            promoCodeModels.add(new PromoCodeModel(
                    promoEt.getText().toString(),
                    et_condition.getText().toString(),
                    et_discount.getText().toString(),
                    desEt.getText().toString()
            ));
            if (promoCodeModels.size() > 0) {
                Intent intent = new Intent();
                intent.putExtra("model", promoCodeModels);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

    private boolean setValidation() {
        if((promoEt.getText().toString().isEmpty() || promoEt.getText().length()<=2)){
            promoEt.setError("Please enter the promo name");
            return false;
        }
        if((et_condition.getText().toString().isEmpty() || et_condition.getText().length()<=2)){
            et_condition.setError("Please enter the condition");
            return false;
        }
        if((et_discount.getText().toString().isEmpty() || et_discount.getText().length()<=5)){
            et_discount.setError("Please enter the discount");
            return false;
        }
        if((desEt.getText().toString().isEmpty() || desEt.getText().length()<=5)){
            desEt.setError("Please enter the desription");
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}