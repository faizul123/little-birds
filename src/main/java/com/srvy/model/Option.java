package com.srvy.model;

public class Option {
	
	private UIControls type;
	
	private String label;
	
	private String hint;
	
	private boolean isAnswered;

	public UIControls getType() {
		return type;
	}

	public void setType(UIControls type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}
	
	
}
