package com.example.jim.test3;

import android.app.Service;
import android.content.Intent;
import android.hardware.SensorEventListener;
import android.os.IBinder;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Looper;
import android.util.Log;

public class StepLogger extends Service implements SensorEventListener{
    private static final String LOGTAG = "StepLogger";

    private SensorManager sensorManager = null;
    private Sensor stepCountSensor = null;

    private StepsDBHandler dbHandler;

    public StepLogger() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.v(LOGTAG, "Step Logger in main thread");
            Log.v(LOGTAG, Looper.myLooper().getThread().getName());
        }
    }

    public void onCreate() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sensorManager.registerListener(this, stepCountSensor, SensorManager.SENSOR_DELAY_NORMAL);
        Log.v(LOGTAG, "sensor mounted");
        if (stepCountSensor == null) {
            Log.v(LOGTAG, "no sensor found");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Steps stepRecord = new Steps();
        stepRecord.set_recordTime(event.timestamp);
        stepRecord.set_step(event.values[0]);
        dbHandler.addSteps(stepRecord);
        Log.v(LOGTAG, "stepLogged");
        Log.v(LOGTAG, "time:" + event.timestamp + " step:" + event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
