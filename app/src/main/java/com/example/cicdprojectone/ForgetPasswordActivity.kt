package com.example.cicdprojectone

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cicdprojectone.ui.theme.CiCdProjectOneTheme

class ForgetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            CiCdProjectOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                ForgetPass()
                }
            }
        }
    }


    @Composable
    fun ForgetPass() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(painter = painterResource(R.drawable.logoo) ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.FillWidth,
                contentDescription = "AppLogo")
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
            Text(text ="islam",Modifier.fillMaxWidth())
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        CiCdProjectOneTheme {
            ForgetPass()
        }
    }
}