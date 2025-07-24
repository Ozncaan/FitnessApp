package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Program4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program4)

        // VideoView referansları
        val vvThruster   = findViewById<VideoView>(R.id.videoThruster)
        val vvFlyPress   = findViewById<VideoView>(R.id.videoFlyPress)
        val vvSingleRow  = findViewById<VideoView>(R.id.videoSingleRow)
        val vvSumoDL     = findViewById<VideoView>(R.id.videoSumoDL)
        val vvYTL        = findViewById<VideoView>(R.id.videoYTL)
        val vvOHTri      = findViewById<VideoView>(R.id.videoOHTri)

        // URI ayarla
        setupVideo(vvThruster,  R.raw.thruster)
        setupVideo(vvFlyPress,  R.raw.bench_ve_fly)
        setupVideo(vvSingleRow, R.raw.tek_kol_row)
        setupVideo(vvSumoDL,    R.raw.sumo_deadlift)
        setupVideo(vvYTL,       R.raw.ytl_raise)
        setupVideo(vvOHTri,     R.raw.overhead_triceps_extension)

        // Play kontrolleri
        findViewById<Button>(R.id.btnPlayThruster).setOnClickListener  { vvThruster.start() }
        findViewById<Button>(R.id.btnPlayFlyPress).setOnClickListener  { vvFlyPress.start() }
        findViewById<Button>(R.id.btnPlaySingleRow).setOnClickListener { vvSingleRow.start() }
        findViewById<Button>(R.id.btnPlaySumoDL).setOnClickListener    { vvSumoDL.start() }
        findViewById<Button>(R.id.btnPlayYTL).setOnClickListener       { vvYTL.start() }
        findViewById<Button>(R.id.btnPlayOHTri).setOnClickListener     { vvOHTri.start() }

        // Pause kontrolleri
        findViewById<Button>(R.id.btnPauseThruster).setOnClickListener  { vvThruster.pause() }
        findViewById<Button>(R.id.btnPauseFlyPress).setOnClickListener  { vvFlyPress.pause() }
        findViewById<Button>(R.id.btnPauseSingleRow).setOnClickListener { vvSingleRow.pause() }
        findViewById<Button>(R.id.btnPauseSumoDL).setOnClickListener    { vvSumoDL.pause() }
        findViewById<Button>(R.id.btnPauseYTL).setOnClickListener       { vvYTL.pause() }
        findViewById<Button>(R.id.btnPauseOHTri).setOnClickListener     { vvOHTri.pause() }

        // Geri butonu
        findViewById<Button>(R.id.btnProg4Back).setOnClickListener { finish() }
    }

    private fun setupVideo(vv: VideoView, rawRes: Int) {
        val uri = Uri.parse("android.resource://${packageName}/$rawRes")
        vv.setVideoURI(uri)
        vv.setOnPreparedListener { mp -> mp.isLooping = false }
    }
}