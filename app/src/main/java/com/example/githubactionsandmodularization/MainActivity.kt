package com.example.githubactionsandmodularization

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.common.FirstTableModel
import com.example.localDatabase.LocalDatabase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var localDatabase: LocalDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {

                    Text("Halla!")

                    Button(
                        onClick = {
                            lifecycleScope.launch {

                                localDatabase.fetchData().also { Log.d("Halla!", "$it") }
                            }
                        },
                        content = { Text("Fetch data") }
                    )

                    Button(
                        onClick = {

                            lifecycleScope.launch {

                                localDatabase.addData(
                                    FirstTableModel(
                                        id = (1..10000).random(),
                                        intValue = (1..10000).random(),
                                        stringValue = (1..10000).random().toString()
                                    )
                                )
                            }
                        },
                        content = { Text("Add data") }
                    )
                }
            )
        }
    }
}