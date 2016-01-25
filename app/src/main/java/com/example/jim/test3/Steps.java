package com.example.jim.test3;

import java.util.Date;

public class Steps {
    private int _id;
    private long _recordTime;
    private float _step;

    public Steps() {
    }

    public Steps(int _id, long _recordTime, float _step) {
        this._id = _id;
        this._recordTime = _recordTime;
        this._step = _step;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_recordTime(long _recordTime) {
        this._recordTime = _recordTime;
    }

    public void set_step(float _step) {
        this._step = _step;
    }

    public int get_id() {
        return _id;
    }

    public long get_recordTime() {
        return _recordTime;
    }

    public float get_step() {
        return _step;
    }
}
