package com.robotsdna.robot.roscore;

import android.util.Log;

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;

import std_msgs.String;

/**
 * A simple {@link Subscriber} {@link NodeMain}.
 *
 * @author razzaghi229@gmail.com (Mr Razzaghi)
 */
public class Listener extends AbstractNodeMain {

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("robona/listener");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {
//        final Log log = connectedNode.getLog();
        Subscriber<String> subscriber = connectedNode.newSubscriber("chatter", String._TYPE);
        subscriber.addMessageListener(new MessageListener<String>() {
            @Override
            public void onNewMessage(String message) {
//                log.info("I heard: \"" + message.getData() + "\"");
                Log.d("Mr","I heard: \"" + message.getData() + "\"");
            }
        });
    }
}