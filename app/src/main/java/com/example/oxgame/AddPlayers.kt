package com.example.oxgame

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.oxgame.databinding.ActivityAddPlayersBinding

class AddPlayers : AppCompatActivity() {
    lateinit var binding: ActivityAddPlayersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startGameButton.setOnClickListener {
            val getPlayerOneName = binding.playerOne.text.toString()
            val getPlayerTwoName = binding.playerTwo.text.toString()
            if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                Toast.makeText(
                    this@AddPlayers,
                    getString(R.string.enter_player_name),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this@AddPlayers, MainActivity::class.java)
                intent.putExtra("playerOne", getPlayerOneName)
                intent.putExtra("playerTwo", getPlayerTwoName)
                startActivity(intent)
            }
        }
    }
}