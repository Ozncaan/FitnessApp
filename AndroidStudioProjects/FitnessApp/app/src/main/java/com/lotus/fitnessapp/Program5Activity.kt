package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Program5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program5)

        // VideoView referansları
        val vvCleanPress            = findViewById<VideoView>(R.id.videoCleanPress)
        val vvBenchPushDrop         = findViewById<VideoView>(R.id.videoBenchPushDrop)
        val vvRenegadePlankRow      = findViewById<VideoView>(R.id.videoRenegadePlankRow)
        val vvSingleLegRomanian     = findViewById<VideoView>(R.id.videoSingleLegRomanian)
        val vvDumbellSnatch         = findViewById<VideoView>(R.id.videoDumbellSnatch)
        val vvBurpeeThruster        = findViewById<VideoView>(R.id.videoBurpeeThruster)

        // URI ayarla
        setupVideo(vvCleanPress,        R.raw.thruster)
        setupVideo(vvBenchPushDrop,     R.raw.bench_pushup_drop_set)
        setupVideo(vvRenegadePlankRow,  R.raw.renegade_row)
        setupVideo(vvSingleLegRomanian, R.raw.single_leg_romanian_deadlift)
        setupVideo(vvDumbellSnatch,     R.raw.shoulder_press)
        setupVideo(vvBurpeeThruster,    R.raw.burpee)

        // Play kontrolleri
        findViewById<Button>(R.id.btnPlayCleanPress).setOnClickListener        { vvCleanPress.start() }
        findViewById<Button>(R.id.btnPlayBenchPushDrop).setOnClickListener     { vvBenchPushDrop.start() }
        findViewById<Button>(R.id.btnPlayRenegadePlankRow).setOnClickListener  { vvRenegadePlankRow.start() }
        findViewById<Button>(R.id.btnPlaySingleLegRomanian).setOnClickListener { vvSingleLegRomanian.start() }
        findViewById<Button>(R.id.btnPlayDumbellSnatch).setOnClickListener     { vvDumbellSnatch.start() }
        findViewById<Button>(R.id.btnPlayBurpeeThruster).setOnClickListener    { vvBurpeeThruster.start() }

        // Pause kontrolleri
        findViewById<Button>(R.id.btnPauseCleanPress).setOnClickListener        { vvCleanPress.pause() }
        findViewById<Button>(R.id.btnPauseBenchPushDrop).setOnClickListener     { vvBenchPushDrop.pause() }
        findViewById<Button>(R.id.btnPauseRenegadePlankRow).setOnClickListener  { vvRenegadePlankRow.pause() }
        findViewById<Button>(R.id.btnPauseSingleLegRomanian).setOnClickListener { vvSingleLegRomanian.pause() }
        findViewById<Button>(R.id.btnPauseDumbellSnatch).setOnClickListener     { vvDumbellSnatch.pause() }
        findViewById<Button>(R.id.btnPauseBurpeeThruster).setOnClickListener    { vvBurpeeThruster.pause() }

        // Geri butonu
        findViewById<Button>(R.id.btnProg5Back).setOnClickListener { finish() }
    }

    private fun setupVideo(vv: VideoView, rawRes: Int) {
        val uri = Uri.parse("android.resource://${packageName}/$rawRes")
        vv.setVideoURI(uri)
        vv.setOnPreparedListener { mp -> mp.isLooping = false }
    }
}