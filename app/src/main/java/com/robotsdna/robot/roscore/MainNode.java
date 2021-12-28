package com.robotsdna.robot.roscore;
import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;

public class MainNode implements NodeMain {

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("robona");
    }

    @Override
    public void onStart(ConnectedNode node) {
//        final Log log = node.getLog();
//        log.info("============================= Started ============================");
    }

    @Override
    public void onShutdown(Node node) {
    }

    @Override
    public void onShutdownComplete(Node node) {
    }

    @Override
    public void onError(Node node, Throwable throwable) {
    }
}