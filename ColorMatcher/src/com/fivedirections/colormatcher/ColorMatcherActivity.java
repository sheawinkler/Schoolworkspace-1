package com.fivedirections.colormatcher;

import java.util.ArrayList;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class ColorMatcherActivity extends Activity {

	private static ArrayList<TileView> selectedTiles;

	private static final ArrayList<Integer> top = new ArrayList<Integer>();
	private static final ArrayList<Integer> bottom = new ArrayList<Integer>();
	private static final ArrayList<Integer> left = new ArrayList<Integer>();
	private static final ArrayList<Integer> right = new ArrayList<Integer>();

	private static final ArrayList<Integer> colors = new ArrayList<Integer>();

	private static ImageAdapter adapter;

	public static int gridSize;
	public static int gridCols;
	public static int gridRows;

	private static TileView[][] grid;
	private boolean firstClick = true;

	private static int selectedColor;

	private TextView timeCount;
	private TextView scoreCount;
	public static int score;

	private boolean refreshed = false;

	private GameTimer timer;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_matcher);

		GridView gridview = (GridView) findViewById(R.id.gameGrid);
		adapter = new ImageAdapter(this);
		
		int bgHeight = TitleScreenActivity.bgHeight;
		int bgWidth = TitleScreenActivity.bgWidth;
		gridRows = bgHeight / 54;
		gridCols = bgWidth / 54;
		gridSize = gridRows * gridCols;
		adapter.setNumTiles(gridSize);
		gridview.setNumColumns(gridCols);
		gridview.setAdapter(adapter);
		
		int lrPad = (bgWidth % 54) / 2;
		int tbPad = (bgHeight % 54) / 2;
		gridview.setPadding(0, 0, 0, 0);
		int build = Build.VERSION.SDK_INT;
		int defaultT = gridview.getPaddingTop();
		int defaultB = gridview.getPaddingBottom();
		if (build < 11) {
			defaultT += 8;
			defaultB += 8;
		}
		int defaultL = gridview.getPaddingLeft();
		int defaultR = gridview.getPaddingRight();
		gridview.setPadding((lrPad - defaultL), (tbPad - defaultT), (lrPad - defaultR), (tbPad - defaultB));

		for (Integer i: adapter.tiles) {
			colors.add(i);
		}

		selectedTiles = new ArrayList<TileView>();

		score = 0;
		scoreCount = (TextView) findViewById(R.id.score);
		scoreCount.setText("Score: " + score);

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				if (firstClick) {
					firstClick = false;
					grid = new TileView[gridCols][gridRows];
					for(int c = 0; c < gridCols;c++) {
						for(int r = 0; r < gridRows;r++) {
							grid[c][r] = (TileView) parent.findViewById((r*gridCols) + c);
						}
					}
				}
				position = v.getId();
				if (selectedTiles.contains(v)) {
					int size = selectedTiles.size();
					if (size == 1 && score < 750) {
						for (TileView tile: selectedTiles) {
							tile.setImageResource(colors.get(colors.indexOf(selectedColor)));
						}
						selectedTiles.clear();
						Toast.makeText(ColorMatcherActivity.this, "" + (750 - score) + " points needed", Toast.LENGTH_SHORT).show();
					} else {
						if (size == 1)
							score -= 750;
						else if (size > 1)
							score += (size * size * 25);
						scoreCount.setText("Score: " + score);
						replaceTiles();
					}
				} else {
					if(selectedTiles.size() != 0) {
						for (TileView tile: selectedTiles) {
							tile.setImageResource(colors.get(colors.indexOf(selectedColor)));
						}
						selectedTiles.clear();
					}
					selectedColor = findSurrounding(parent, position, v);
					for (TileView tile: selectedTiles) {
						tile.setImageResource(colors.get(colors.indexOf(selectedColor) + 6));
					}
				}
			}
		});

		adapter.initRandom();

		for (int i = 0; i < gridCols;i++) {
			top.add(i);
			bottom.add(i + (gridRows * gridCols) - gridCols);
		}
		for (int i = 0; i < gridRows;i++) {
			left.add(i*gridCols);
			right.add(i*gridCols + (gridCols-1));
		}

		timeCount = (TextView) findViewById(R.id.time);
		setTimer();
	}

	public void setTimer() {
		timer = new GameTimer(TimeSelectActivity.minutes * 60000 + 1000, 1000) {
			public void onTick(long millisUntilFinished) {
				String time = "Time:  " + (millisUntilFinished / 60000) + ":";
				int seconds = (int) (millisUntilFinished % 60000 / 1000);
				if (seconds < 10)
					time += "0" + seconds;
				else
					time += seconds;
				timeCount.setText(time);
			}

			public void onFinish() {
				Intent intent = new Intent(ColorMatcherActivity.this, ScoreDisplayActivity.class);
				startActivity(intent);
				ColorMatcherActivity.this.finish();
			}
		};
		timer.start();
	}

	public int findSurrounding(AdapterView<?> parent, int position, View v) {
		selectedTiles.add((TileView) v);
		int color = (Integer) v.getTag();
		checkLeft(parent, color, position, v);
		checkRight(parent, color, position, v);
		checkUp(parent, color, position, v);
		checkDown(parent, color, position, v);
		return color;
	}

	public void checkLeft(AdapterView<?> parent, int color, int rightP, View v) {
		if(!left.contains(rightP)) {
			int newP = rightP - 1;
			View newV = parent.findViewById(newP);
			if (!(selectedTiles.contains(newV)) && newV.getTag().equals(color)) {
				findSurrounding(parent, newP, newV);
			}
		}
	}

	public void checkRight(AdapterView<?> parent, int color, int leftP, View v) {
		if(!right.contains(leftP)) {
			int newP = leftP + 1;
			View newV = parent.findViewById(newP);
			if (!(selectedTiles.contains(newV)) && newV.getTag().equals(color)) {
				findSurrounding(parent, newP, newV);
			}
		}
	}

	public void checkUp(AdapterView<?> parent, int color, int belowP, View v) {
		if(!top.contains(belowP)) {
			int newP = belowP - gridCols;
			View newV = parent.findViewById(newP);
			if (!(selectedTiles.contains(newV)) && newV.getTag().equals(color)) {
				findSurrounding(parent, newP, newV);
			}
		}
	}

	public void checkDown(AdapterView<?> parent, int color, int aboveP, View v) {
		if(!bottom.contains(aboveP)) {
			int newP = aboveP + gridCols;
			View newV = parent.findViewById(newP);
			if (!(selectedTiles.contains(newV)) && newV.getTag().equals(color)) {
				findSurrounding(parent, newP, newV);
			}
		}
	}

	public void replaceTiles() {
		for (int colNum = 0; colNum < gridCols; colNum++) {
			int offset = 0;
			for (int row = gridRows - 1; row >= 0; row--) {
				if ( ! (row < offset) && selectedTiles.contains(grid[colNum][row - offset])) {
					while (selectedTiles.contains(grid[colNum][row - offset])) {
						offset++;
						if (row < offset)
							break;
					}
				}
				if (row <= (offset - 1)) {
					grid[colNum][row].setImageResource(ImageAdapter.tiles[(int) (Math.random() * 6)]);
				} else {
					grid[colNum][row].setImageResource((Integer) grid[colNum][row - offset].getTag());
				}
			}
		}
		selectedTiles.clear();
	}

	public void onRefresh(View v) {
		ImageView refresh = (ImageView) findViewById(R.id.refreshButton);
		if (!refreshed && score < 2500) {
			Toast.makeText(ColorMatcherActivity.this, "" + (2500 - score) + " points needed", Toast.LENGTH_SHORT).show();
		} else if (!refreshed && v.equals(refresh)) {
			for(int c = 0; c < gridCols;c++) {
				for(int r = 0; r < gridRows;r++) {
					grid[c][r].setImageResource(ImageAdapter.tiles[(int) (Math.random() * 6)]);
				}
			}
			score -= 2500;
			scoreCount.setText("Score: " + score);
			refresh.setImageResource(R.drawable.refresh_button_spent);
			refreshed = true;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_color_matcher, menu);
		
		MenuItem restart = menu.findItem(R.id.menu_restart);
		MenuItem quit = menu.findItem(R.id.menu_quit);
		
		restart.setOnMenuItemClickListener
	    (
	    		new MenuItem.OnMenuItemClickListener () 
	            {
	                public boolean onMenuItemClick(MenuItem item) 
	                {
	                	score = 0;
	            		Intent intent = new Intent(ColorMatcherActivity.this, ColorMatcherActivity.class);
	            		startActivity(intent);
	            		ColorMatcherActivity.this.finish();
	                	return true;
	                }
	            }
	    );
		
		quit.setOnMenuItemClickListener
	    (
	    		new MenuItem.OnMenuItemClickListener () 
	            {
	                public boolean onMenuItemClick(MenuItem item) 
	                {
	            		ColorMatcherActivity.this.finish();
	                	return true;
	                }
	            }
	    );
		
		return true;
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		timer.start();
		super.onContextMenuClosed(menu);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		timer.pause();
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		timer.start();
		super.onOptionsMenuClosed(menu);
	}

	@Override
	protected void onPause() {
		timer.pause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		timer.start();
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		/*User should exit game using the menu.
		I guess it counts as a safety, should the user accidentally press back...*/
	}

}