package implementations;
import conceptualapi.ComputeAPI; 
import project.annotations.ConceptualAPI;
import java.util.List;
public class ComputeImplement implements ComputeAPI {

	 @Override
	    public String compute(int n) {
	        if (n <= 2) {
	            return "";
	        }
	        return calculatePrimes(n);
	    }

	 @Override
	 public String calculatePrimes(int limit) {
		// TODO Auto-generated method stub
		return null;
	 }

	
	}

	
