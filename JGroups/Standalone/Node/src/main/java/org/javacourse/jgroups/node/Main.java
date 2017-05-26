package org.javacourse.jgroups.node;

import org.jgroups.Address;
import org.jgroups.AnycastAddress;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.stack.IpAddress;
import org.jgroups.util.UUID;
import org.jgroups.util.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String name = args[0];

        JChannel channel = new JChannel();
        channel.setDiscardOwnMessages(true);
        channel.setName(name);
        channel.connect("NodeCluster");
        NodeReceiverAdapter receiver = new NodeReceiverAdapter();
        channel.setReceiver(receiver);
        Address address = channel.getAddress();

        System.out.println("who: all for all members in cluster");

        while (true) {
            System.out.print("(who:message) >> ");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            String command = inputReader.readLine();

            int separator = command.indexOf(':');
            if (separator == -1) {
                System.out.println("wrong input");
                continue;
            }
            String who = command.substring(0, separator);
            Address dest = null;
            if (!who.equals("all")) {
                dest = receiver.getAddresses().get(who);
            }

            String message = command.substring(separator + 1, command.length());

            channel.send(new Message(dest, address, message));
        }
    }

}
