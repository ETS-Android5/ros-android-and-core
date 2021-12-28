package com.robotsdna.robot.widgets.label;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.schneewittchen.rosandroid.R;
import com.robotsdna.robot.model.entities.widgets.BaseEntity;
import com.robotsdna.robot.ui.views.details.SilentWidgetViewHolder;
import com.robotsdna.robot.utility.Utils;

/**
 * TODO: Description
 *
 * @author Dragos Circa
 * @version 1.0.0
 * @created on 02.11.2020
 * @updated on 18.11.2020
 * @modified by Nils Rottmann
 * @updated on 20.03.2021
 * @modified by Nico Studt
 */
public class LabelDetailVH extends SilentWidgetViewHolder {

    private EditText labelTextText;
    private Spinner labelTextRotationSpinner;

    private ArrayAdapter<CharSequence> rotationAdapter;


    @Override
    public void initView(View view) {
        labelTextText = view.findViewById(R.id.labelText);
        labelTextRotationSpinner = view.findViewById(R.id.labelTextRotation);

        // Init spinner
        rotationAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.button_rotation, android.R.layout.simple_spinner_dropdown_item);

        labelTextRotationSpinner.setAdapter(rotationAdapter);
    }

    @Override
    protected void bindEntity(BaseEntity entity) {
        LabelEntity labelEntity = (LabelEntity) entity;
        int position = rotationAdapter.getPosition(Utils.numberToDegrees(labelEntity.rotation));

        labelTextText.setText(labelEntity.text);
        labelTextRotationSpinner.setSelection(position);
    }

    @Override
    protected void updateEntity(BaseEntity entity) {
        int rotation = Utils.degreesToNumber(labelTextRotationSpinner.getSelectedItem().toString());

        ((LabelEntity) entity).text = labelTextText.getText().toString();
        ((LabelEntity) entity).rotation = rotation;
    }


}
