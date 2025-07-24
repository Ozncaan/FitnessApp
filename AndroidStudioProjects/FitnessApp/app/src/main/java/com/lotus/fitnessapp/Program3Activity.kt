package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Program3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program3)

        // VideoView referansları
        val vvSplitSquat     = findViewById<VideoView>(R.id.videoSplitSquat)
        val vvInclinePress   = findViewById<VideoView>(R.id.videoInclinePress)
        val vvRenegadeRow    = findViewById<VideoView>(R.id.videoRenegadeRow)
        val vvDLShrug        = findViewById<VideoView>(R.id.videoDLShrug)
        val vvShoulderPress  = findViewById<VideoView>(R.id.videoShoulderPress)
        val vvSkullCrushers  = findViewById<VideoView>(R.id.videoSkullCrushers)

        // URI ayarla
        setupVideo(vvSplitSquat,    R.raw.bulgarian_squat)
        setupVideo(vvInclinePress,  R.raw.incline_bench)
        setupVideo(vvRenegadeRow,   R.raw.renegade_row)
        setupVideo(vvDLShrug,       R.raw.deadlift_ve_shrug)
        setupVideo(vvShoulderPress, R.raw.shoulder_press)
        setupVideo(vvSkullCrushers, R.raw.skull_crushers)

        // Play kontrolleri
        findViewById<Button>(R.id.btnPlaySplitSquat).setOnClickListener    { vvSplitSquat.start() }
        findViewById<Button>(R.id.btnPlayIncline).setOnClickListener       { vvInclinePress.start() }
        findViewById<Button>(R.id.btnPlayRenegade).setOnClickListener      { vvRenegadeRow.start() }
        findViewById<Button>(R.id.btnPlayDLShrug).setOnClickListener       { vvDLShrug.start() }
        findViewById<Button>(R.id.btnPlayShoulderPress).setOnClickListener { vvShoulderPress.start() }
        findViewById<Button>(R.id.btnPlaySkull).setOnClickListener         { vvSkullCrushers.start() }

        // Pause kontrolleri
        findViewById<Button>(R.id.btnPauseSplitSquat).setOnClickListener    { vvSplitSquat.pause() }
        findViewById<Button>(R.id.btnPauseIncline).setOnClickListener       { vvInclinePress.pause() }
        findViewById<Button>(R.id.btnPauseRenegade).setOnClickListener      { vvRenegadeRow.pause() }
        findViewById<Button>(R.id.btnPauseDLShrug).setOnClickListener       { vvDLShrug.pause() }
        findViewById<Button>(R.id.btnPauseShoulderPress).setOnClickListener { vvShoulderPress.pause() }
        findViewById<Button>(R.id.btnPauseSkull).setOnClickListener         { vvSkullCrushers.pause() }

        // Geri butonu
        findViewById<Button>(R.id.btnProg3Back).setOnClickListener { finish() }
    }

    private fun setupVideo(vv: VideoView, rawRes: Int) {
        val uri = Uri.parse("android.resource://${packageName}/$rawRes")
        vv.setVideoURI(uri)
        vv.setOnPreparedListener { mp -> mp.isLooping = false }
    }
}