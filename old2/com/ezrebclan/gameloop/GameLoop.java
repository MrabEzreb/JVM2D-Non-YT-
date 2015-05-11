package com.ezrebclan.gameloop;

public abstract class GameLoop {

	private Thread loop;
	
	public final void startLoop() {
		loop = new Thread(new Runnable() {
			@Override
			public void run() {
				init();
				while(shouldRun()) {
					loopCycle();
				}
				exit();
			}
		});
		loop.start();
	}

	protected abstract boolean shouldRun();
	protected abstract void init();
	protected abstract void loopCycle();
	protected abstract void exit();
}
