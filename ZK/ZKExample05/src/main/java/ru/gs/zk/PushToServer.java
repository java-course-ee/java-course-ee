package ru.gs.zk;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class PushToServer {

	public static void start(Component info) throws InterruptedException {
		final Desktop desktop = Executions.getCurrent().getDesktop();
		if (desktop.isServerPushEnabled()) {
			Messagebox.show("Already started");
		} else {
			desktop.enableServerPush(true);
			new MyThread(info).start();
		}
	}

	public static void stop() throws InterruptedException {
		final Desktop desktop = Executions.getCurrent().getDesktop();
		if (desktop.isServerPushEnabled()) {
			desktop.enableServerPush(false);
		} else {
			Messagebox.show("Already stopped");
		}
	}

	private static class MyThread extends Thread {

		private static Component info;
		private static Desktop desktop;

		public MyThread(Component info) {
			MyThread.info = info;
			MyThread.desktop = info.getDesktop();
		}

		@Override
		public void run() {
			try {
				
				while (true) {
					Executions.activate(desktop);
					((Datebox) info).setValue(new Date());
					Thread.sleep(1000);
					Executions.deactivate(desktop);
				}
			} catch (InterruptedException ex) {
				Logger.getLogger(PushToServer.class.getName()).log(Level.SEVERE, null, ex);
			} catch (DesktopUnavailableException ex) {
				Logger.getLogger(PushToServer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
