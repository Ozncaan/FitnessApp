package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Program1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program1)

        // VideoView referansları
        val vvGoblet     = findViewById<VideoView>(R.id.videoGoblet)
        val vvBench      = findViewById<VideoView>(R.id.videoBench)
        val vvRow        = findViewById<VideoView>(R.id.videoRow)
        val vvDeadlift   = findViewById<VideoView>(R.id.videoDeadlift)
        val vvPress      = findViewById<VideoView>(R.id.videoPress)
        val vvCurl       = findViewById<VideoView>(R.id.videoCurl)

        // URI set et
        setupVideo(vvGoblet,   R.raw.goblet_squat)
        setupVideo(vvBench,    R.raw.bench_press)
        setupVideo(vvRow,      R.raw.tek_kol_row)
        setupVideo(vvDeadlift, R.raw.deadlift)
        setupVideo(vvPress,    R.raw.shoulder_press)
        setupVideo(vvCurl,     R.raw.hammer_curl)

        // Başlat kontrolleri
        findViewById<Button>(R.id.btnPlayGoblet).setOnClickListener { vvGoblet.start() }
        findViewById<Button>(R.id.btnPlayBench).setOnClickListener { vvBench.start() }
        findViewById<Button>(R.id.btnPlayRow).setOnClickListener { vvRow.start() }
        findViewById<Button>(R.id.btnPlayDeadlift).setOnClickListener { vvDeadlift.start() }
        findViewById<Button>(R.id.btnPlayPress).setOnClickListener { vvPress.start() }
        findViewById<Button>(R.id.btnPlayCurl).setOnClickListener { vvCurl.start() }

        // Durdur kontrolleri
        findViewById<Button>(R.id.btnPauseGoblet).setOnClickListener { vvGoblet.pause() }
        findViewById<Button>(R.id.btnPauseBench).setOnClickListener { vvBench.pause() }
        findViewById<Button>(R.id.btnPauseRow).setOnClickListener { vvRow.pause() }
        findViewById<Button>(R.id.btnPauseDeadlift).setOnClickListener { vvDeadlift.pause() }
        findViewById<Button>(R.id.btnPausePress).setOnClickListener { vvPress.pause() }
        findViewById<Button>(R.id.btnPauseCurl).setOnClickListener { vvCurl.pause() }

        // Geri
        findViewById<Button>(R.id.btnProg1Back).setOnClickListener {
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