package org.javacourse.jgroups.node;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String name = args[0];

        if (name == null) {
            System.out.println("Provide name as a parameter");
            return;
        }

        JChannel channel = new JChannel();
        channel.setDiscardOwnMessages(false);
        channel.setName(name);
        channel.connect("NodeCluster");
        NodeReceiverAdapter receiver = new NodeReceiverAdapter();
        channel.setReceiver(receiver);

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
                final List<Address> members = channel.getView().getMembers();
                for (Address member : members) {
                    if (member.toString().equals(who)) {
                        dest = member;
                        break;
                    }
                }
            }

            String message = command.substring(separator + 1);
            channel.send(new Message(dest, message));
        }
    }

}
