package com.robotsdna.robot.ui.general;


import com.robotsdna.robot.model.repositories.rosRepo.node.BaseData;

/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.0
 * @created on 15.03.20
 * @updated on 15.03.20
 * @modified by
 */
public interface DataListener {

    void onNewWidgetData(BaseData data);
}
