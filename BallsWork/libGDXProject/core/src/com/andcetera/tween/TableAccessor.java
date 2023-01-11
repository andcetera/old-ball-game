package com.andcetera.tween;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TableAccessor implements TweenAccessor<Table> {

	public static final int Y = 0, RGB = 1, ALPHA = 2;

	@Override
	public int getValues(Table target, int tweenType, float[] returnValues) {
		switch (tweenType) {
		case Y:
			returnValues[0] = target.getY();
			return 1;
		case ALPHA:
			returnValues[0] = target.getColor().a;
			return 1;
		default:
			assert false;
			return -1;
		}
	}

	@Override
	public void setValues(Table target, int tweenType, float[] newValues) {
		switch (tweenType) {
		case Y:
			target.setY(newValues[0]);
			break;
		case ALPHA:
			target.setColor(target.getColor().r, target.getColor().g,
					target.getColor().b, newValues[0]);
			break;
		default:
			assert false;
		}
	}

}
