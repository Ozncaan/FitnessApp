package com.lotus.fitnessapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class BWProgram3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bw_program3)

        val vvPistol      = findViewById<VideoView>(R.id.videoBWPistolSquat)
        val vvDiamond     = findViewById<VideoView>(R.id.videoBWDiamondPush)
        val vvArcher      = findViewById<VideoView>(R.id.videoBWArcherPush)
        val vvChinUp      = findViewById<VideoView>(R.id.videoBWChinUp)
        val vvHangingLeg  = findViewById<VideoView>(R.id.videoBWHangingLeg)
        val vvBurpee      = findViewById<VideoView>(R.id.videoBWBurpee)

        setupVideo(vvPistol,     R.raw.jump_squat)
        setupVideo(vvDiamond,    R.raw.diamond_push_up)
        setupVideo(vvArcher,     R.raw.archer_push_up)
        setupVideo(vvChinUp,     R.raw.chin_up)
        setupVideo(vvHangingLeg, R.raw.leg_raise)
        setupVideo(vvBurpee,     R.raw.burpee)

        findViewById<Button>(R.id.btnPlayPistol).setOnClickListener { vvPistol.start() }
        findViewById<Button>(R.id.btnPausePistol).setOnClickListener { vvPistol.pause() }

        findViewById<Button>(R.id.btnPlayDiamond).setOnClickListener { vvDiamond.start() }
        findViewById<Button>(R.id.btnPauseDiamond).setOnClickListener { vvDiamond.pause() }

        findViewById<Button>(R.id.btnPlayArcher).setOnClickListener { vvArcher.start() }
        findViewById<Button>(R.id.btnPauseArcher).setOnClickListener { vvArcher.pause() }

        findViewById<Button>(R.id.btnPlayChinUp).setOnClickListener { vvChinUp.start() }
        findViewById<Button>(R.id.btnPauseChinUp).setOnClickListener { vvChinUp.pause() }

        findViewById<Button>(R.id.btnPlayHangingLeg).setOnClickListener { vvHangingLeg.start() }
        findViewById<Button>(R.id.btnPauseHangingLeg).setOnClickListener { vvHangingLeg.pause() }

        findViewById<Button>(R.id.btnPlayBurpee).setOnClickListener { vvBurpee.start() }
        findViewById<Button>(R.id.btnPauseBurpee).setOnClickListener { vvBurpee.pause() }

        findViewById<Button>(R.id.btnBWProg3Back).setOnClickListener {
            finish()
        }
    }

    private fun setupVideo(vv: VideoView, rawRes: Int) {
        val uri = Uri.parse("android.resource://${packageName}/$rawRes")
        vv.setVideoURI(uri)
        vv.setOnPreparedListener { it.isLooping = false }
    }
}