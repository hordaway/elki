package experimentalcode.remigius.Adapter;

import de.lmu.ifi.dbs.elki.data.DoubleVector;
import de.lmu.ifi.dbs.elki.database.Database;
import de.lmu.ifi.dbs.elki.result.Result;
import experimentalcode.remigius.AbstractAlgorithmAdapter;
import experimentalcode.remigius.VisualizationManager;
import experimentalcode.remigius.Visualizers.AxisVisualizer;
import experimentalcode.remigius.Visualizers.DotVisualizer;

public class DefaultAdapter<O extends DoubleVector> extends AbstractAlgorithmAdapter<O>{

	private DotVisualizer<O> dotVisualizer;
	private AxisVisualizer<O> axisVisualizer;

	public DefaultAdapter(){
		super();
		dotVisualizer = new DotVisualizer<O>();
		axisVisualizer = new AxisVisualizer<O>();
		visualizers.add(dotVisualizer);
		visualizers.add(axisVisualizer);
	}

	@Override
	public boolean canVisualize(Result r){
		return true;
	}

	@Override
	protected void initVisualizer(Database<O> database, Result result, VisualizationManager<O> visManager) {
		axisVisualizer.setup(database, visManager);
		dotVisualizer.setup(database, visManager);
	}
}