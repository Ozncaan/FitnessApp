package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class BWProgram2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bw_program2)

        // VideoView referansları
        val vvJump      = findViewById<VideoView>(R.id.videoBWJumpSquat)
        val vvPush      = findViewById<VideoView>(R.id.videoBWPushUp)
        val vvBSquat    = findViewById<VideoView>(R.id.videoBWBSquat)
        val vvPullUp    = findViewById<VideoView>(R.id.videoBWPullUp)
        val vvSidePlank = findViewById<VideoView>(R.id.videoBWSidePlank)
        val vvMtnClimb  = findViewById<VideoView>(R.id.videoBWMtnClimber)

        // URI ayarla
        setupVideo(vvJump,      R.raw.jump_squat)
        setupVideo(vvPush,      R.raw.push_up)
        setupVideo(vvBSquat,    R.raw.bulgarian_squat)
        setupVideo(vvPullUp,    R.raw.pull_up)
        setupVideo(vvSidePlank, R.raw.side_plank)
        setupVideo(vvMtnClimb,  R.raw.mountain_climber)

        // Oynatma kontrolleri
        findViewById<Button>(R.id.btnPlayJumpSquat).setOnClickListener { vvJump.start() }
        findViewById<Button>(R.id.btnPauseJumpSquat).setOnClickListener { vvJump.pause() }

        findViewById<Button>(R.id.btnPlayPushUp).setOnClickListener { vvPush.start() }
        findViewById<Button>(R.id.btnPausePushUp).setOnClickListener { vvPush.pause() }

        findViewById<Button>(R.id.btnPlayBSquat).setOnClickListener { vvBSquat.start() }
        findViewById<Button>(R.id.btnPauseBSquat).setOnClickListener { vvBSquat.pause() }

        findViewById<Button>(R.id.btnPlayPullUp).setOnClickListener { vvPullUp.start() }
        findViewById<Button>(R.id.btnPausePullUp).setOnClickListener { vvPullUp.pause() }

        findViewById<Button>(R.id.btnPlaySidePlank).setOnClickListener { vvSidePlank.start() }
        findViewById<Button>(R.id.btnPauseSidePlank).setOnClickListener { vvSidePlank.pause() }

        findViewById<Button>(R.id.btnPlayMtnClimber).setOnClickListener { vvMtnClimb.start() }
        findViewById<Button>(R.id.btnPauseMtnClimber).setOnClickListener { vvMtnClimb.pause() }

        // Geri butonu
        findViewById<Button>(R.id.btnBWProg2Back).setOnClickListener {
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