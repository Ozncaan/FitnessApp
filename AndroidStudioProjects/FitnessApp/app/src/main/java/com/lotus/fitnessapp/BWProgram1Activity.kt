package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class BWProgram1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bw_program1)

        // VideoView referansları
        val vvSquat     = findViewById<VideoView>(R.id.videoBWSquat)
        val vvKneePush  = findViewById<VideoView>(R.id.videoBWKneePush)
        val vvBridge    = findViewById<VideoView>(R.id.videoBWBridge)
        val vvRow       = findViewById<VideoView>(R.id.videoBWRow)
        val vvPlank     = findViewById<VideoView>(R.id.videoBWPlank)
        val vvSuperman  = findViewById<VideoView>(R.id.videoBWSuperman)

        // URI ayarla (döngüsüz)
        setupVideo(vvSquat,    R.raw.bw_squat)
        setupVideo(vvKneePush, R.raw.knee_push_up)
        setupVideo(vvBridge,   R.raw.glute_bridge)
        setupVideo(vvRow,      R.raw.tek_kol_row)
        setupVideo(vvPlank,    R.raw.plank)
        setupVideo(vvSuperman, R.raw.superman)

        // Başlat butonları
        findViewById<Button>(R.id.btnPlaySquat).setOnClickListener { vvSquat.start() }
        findViewById<Button>(R.id.btnPlayKnee).setOnClickListener { vvKneePush.start() }
        findViewById<Button>(R.id.btnPlayBridge).setOnClickListener { vvBridge.start() }
        findViewById<Button>(R.id.btnPlayRow).setOnClickListener { vvRow.start() }
        findViewById<Button>(R.id.btnPlayPlank).setOnClickListener { vvPlank.start() }
        findViewById<Button>(R.id.btnPlaySuperman).setOnClickListener { vvSuperman.start() }

        // Durdur butonları
        findViewById<Button>(R.id.btnPauseSquat).setOnClickListener { vvSquat.pause() }
        findViewById<Button>(R.id.btnPauseKnee).setOnClickListener { vvKneePush.pause() }
        findViewById<Button>(R.id.btnPauseBridge).setOnClickListener { vvBridge.pause() }
        findViewById<Button>(R.id.btnPauseRow).setOnClickListener { vvRow.pause() }
        findViewById<Button>(R.id.btnPausePlank).setOnClickListener { vvPlank.pause() }
        findViewById<Button>(R.id.btnPauseSuperman).setOnClickListener { vvSuperman.pause() }

        // Geri butonu
        findViewById<Button>(R.id.btnBWProg1Back).setOnClickListener {
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