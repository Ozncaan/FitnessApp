package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Program2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program2)

        // VideoView referansları
        val vvFrontSquat   = findViewById<VideoView>(R.id.videoFrontSquat)
        val vvFloorPress   = findViewById<VideoView>(R.id.videoFloorPress)
        val vvBentRow      = findViewById<VideoView>(R.id.videoBentOverRow)
        val vvRomanianDL   = findViewById<VideoView>(R.id.videoRomanianDL)
        val vvLateral      = findViewById<VideoView>(R.id.videoLateralRaise)
        val vvKickback     = findViewById<VideoView>(R.id.videoKickback)

        // URI ayarla
        setupVideo(vvFrontSquat, R.raw.goblet_squat)
        setupVideo(vvFloorPress, R.raw.floor_press)
        setupVideo(vvBentRow,    R.raw.tek_kol_row)
        setupVideo(vvRomanianDL, R.raw.deadlift)
        setupVideo(vvLateral,    R.raw.lateral_raise)
        setupVideo(vvKickback,   R.raw.kickback)

        // Play butonları
        findViewById<Button>(R.id.btnPlayFrontSquat).setOnClickListener { vvFrontSquat.start() }
        findViewById<Button>(R.id.btnPlayFloorPress).setOnClickListener { vvFloorPress.start() }
        findViewById<Button>(R.id.btnPlayBentRow).setOnClickListener    { vvBentRow.start() }
        findViewById<Button>(R.id.btnPlayRomanianDL).setOnClickListener { vvRomanianDL.start() }
        findViewById<Button>(R.id.btnPlayLateral).setOnClickListener    { vvLateral.start() }
        findViewById<Button>(R.id.btnPlayKickback).setOnClickListener   { vvKickback.start() }

        // Pause butonları
        findViewById<Button>(R.id.btnPauseFrontSquat).setOnClickListener { vvFrontSquat.pause() }
        findViewById<Button>(R.id.btnPauseFloorPress).setOnClickListener { vvFloorPress.pause() }
        findViewById<Button>(R.id.btnPauseBentRow).setOnClickListener    { vvBentRow.pause() }
        findViewById<Button>(R.id.btnPauseRomanianDL).setOnClickListener { vvRomanianDL.pause() }
        findViewById<Button>(R.id.btnPauseLateral).setOnClickListener    { vvLateral.pause() }
        findViewById<Button>(R.id.btnPauseKickback).setOnClickListener   { vvKickback.pause() }

        // Geri butonu
        findViewById<Button>(R.id.btnProg2Back).setOnClickListener {
            finish()
        }
    }

    private fun setupVideo(vv: VideoView, rawRes: Int) {
        val uri = Uri.parse("android.resource://${packageName}/$rawRes")
        vv.setVideoURI(uri)
        vv.setOnPreparedListener { mp ->
            mp.isLooping = false
        }
    }
}