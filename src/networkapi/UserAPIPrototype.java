package networkapi;
import project.annotations.NetworkAPIPrototype;

public class UserAPIPrototype {
	 @NetworkAPIPrototype
    public void prototype(UserAPI userapi) {
		 userapi.setInput("file://inputs.txt");
			userapi.setOutput("file://outputs.txt");
			userapi.useDefaultDelimiters();
    }
}
