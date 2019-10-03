package com.supermavster.reciclerview.dummy

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v4.content.ContextCompat.getSystemService
import android.util.Log
import java.util.ArrayList
import java.util.HashMap
import kotlin.random.Random

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
public final class DummyContent (sensor: SensorManager) {
    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()
    val deviceSensors: List<Sensor> = sensor.getSensorList(Sensor.TYPE_ALL)
    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 10

    fun getItems(): MutableList<DummyItem> {
        return ITEMS;
    }

    init {
        Log.v("Total sensors",""+deviceSensors.size)
        deviceSensors.forEach{
            Log.v("Sensor name",""+it)
        }
        // Add some sample items.
        for (i in 1..deviceSensors.size) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Sensor #" + position, makeDetails(position))
    }



    private fun makeDetails(position: Int): ArrayList<String> {
        val builder = ArrayList<String>();
        //builder.add(deviceSensors[position].name);
        builder.add(deviceSensors[position-1].name)
        builder.add(deviceSensors[position-1].type.toString());
        //builder.add(deviceSensors[position].type.toString());
        return builder
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, val details: ArrayList<String>) {
        override fun toString(): String = id
    }

}
