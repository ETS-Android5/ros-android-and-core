package com.robotsdna.robot.roscore;

import org.ros.address.InetAddressFactory;
import org.ros.node.DefaultNodeFactory;
import org.ros.node.Node;
import org.ros.node.NodeConfiguration;

import java.net.InetAddress;
import java.net.URI;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class RosUtils {

    public static Node createExternalMaster(String node_name, String masterURI) {
        URI muri = URI.create(masterURI);

        InetAddress host = InetAddressFactory.newNonLoopback();
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(host.getHostName(), muri);
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);

        DefaultNodeFactory factory = new DefaultNodeFactory(scheduledExecutorService);
        return factory.newNode(nodeConfiguration);
    }
}
