package com.ezrebclan.gameloop;

public abstract class GameLoop {

	public final void startLoop() {
		Thread loop = new Thread(new Runnable() {
			
			@Override
			public void run() {
				init();
				while(shouldRun()) {
					cycle();
				}
				finish();
			}
		});
		loop.start();
	}
	
	protected abstract void init();
	protected abstract void cycle();
	protected abstract void finish();
	protected abstract boolean shouldRun();
}
