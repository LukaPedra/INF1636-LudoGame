package controller;

import java.util.ArrayList;
import java.util.List;

public class TabuleiroObservable {
	private List<TabuleiroObserver> observers = new ArrayList<TabuleiroObserver>();
	
	public void addObserver(TabuleiroObserver observer) {
		this.observers.add(observer);
	}
	
	public void notifyObservers() {
		for(TabuleiroObserver observer : this.observers) {
			observer.update();
		}
	}
}
