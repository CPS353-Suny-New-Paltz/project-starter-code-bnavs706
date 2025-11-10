package implementations;
import conceptualapi.ComputeAPI;
import networkapi.UserAPI;
import processapi.StorageAPI;

public class UserImplement implements UserAPI {

	    private final ComputeAPI engine;
	    private final StorageAPI storage;

	    public UserImplement(ComputeAPI engine, StorageAPI storage) {
	        this.engine = engine;
	        this.storage = storage;
	    }
	    
	    public String findPrimes(int limit) {
	        return engine.calculatePrimes(limit);
	    }

		@Override
		public void setInput(String sourceUri) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setOutput(String sinkUri) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDelimiters(String pairDelimiter, String kvDelimiter) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void useDefaultDelimiters() {
			// TODO Auto-generated method stub
			
		}

		public String runEngineTask(ComputeAPI mockEngine, int i) {
			// TODO Auto-generated method stub
			return null;
		}
}