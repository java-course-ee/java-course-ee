package org.javacourse.jgroups.node;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.jgroups.Address;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class NodeReceiverAdapter extends ReceiverAdapter {

    private static final Logger log = LoggerFactory.getLogger(NodeReceiverAdapter.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
    }

    private Map<String, Address> addresses = new HashMap<>();

    public Map<String, Address> getAddresses() {
        Map<String, Address> result = new HashMap<>();
        synchronized (addresses) {
            result.putAll(addresses);
        }
        return result;
    }

    @Override
    public void receive(Message msg) {
        log.info("Message received: {}", msg.getObject());
        try {
            log.trace("Message received: {}", mapper.writeValueAsString(msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewAccepted(View view) {
        log.info("Members changed: {}", view.getMembers());
        synchronized (addresses) {
            addresses.clear();
            for (Address address: view.getMembers()) {
                System.out.println(address.getClass().getCanonicalName());
                addresses.put(address.toString(), address);
            }
        }
        try {
            log.trace("ViewId: {}", mapper.writeValueAsString(view));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
