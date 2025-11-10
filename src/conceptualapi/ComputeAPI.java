package conceptualapi;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface ComputeAPI {
    
	String compute(int n);
	String calculatePrimes(int limit);
}
