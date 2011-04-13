package jsipp.parser.model.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import jsipp.sip.Transceiver;

public class Sceneraio {
	private static Logger logger = Logger.getLogger(Sceneraio.class.getName());
	List<Action> actions = new ArrayList<Action>();
	Transceiver transceiver;

	public Sceneraio(int port, Properties properties) throws Exception {
		transceiver = new Transceiver(port, properties);

	}

	public void addAction(Action action) {
		action.setTx(transceiver);
		actions.add(action);
	}

	public List<Action> getActions() {

		return actions;
	}

	public void play() {
		// TODO Auto-generated method stub
		for (Action action : actions) {
			logger.info("Processing Action : " + action);
			action.execute();
		}

	}
}
