package core;

import bean.Bean;

public interface Action {

	public void initialize(Bean b);

	public void execute();

	public void callBack();

	public Bean getResult();

}
