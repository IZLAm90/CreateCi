package com.example.cicdprojectone

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.cicdprojectone.datastore.UserRepoImpl
import com.example.cicdprojectone.datastore.UserRepoStore
import com.example.cicdprojectone.datastore.islam
import com.example.cicdprojectone.ui.theme.CiCdProjectOneTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    private val PREFERENCES_NAME_USER =  "sample_datastore_prefs"
    private val Context.prefsDataStore by preferencesDataStore(
        name = PREFERENCES_NAME_USER)
    var userRepo : UserRepoStore ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CiCdProjectOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ClickBtb()
                }
            }
        }

    }

  public fun saveUserData(){
        userRepo = UserRepoImpl(prefsDataStore)
        lifecycleScope.launch() {
            userRepo?.getUSerData()?.collect { islam->
                withContext(Dispatchers.Main){
                    Log.d("islam", "setDataToUI: ${islam} ")
                }
            }
        }
    }



@Composable
fun ClickBtb(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color(0xFF009688))
        .fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(painter =painterResource(R.drawable.logoo) ,
            modifier = Modifier
                .width(200.dp)
                .height(150.dp), contentScale = ContentScale.FillWidth,
            contentDescription = "AppLogo")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "medical service ", style = TextStyle(Color.White, fontStyle = FontStyle.Normal, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp))
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = " login ", style = TextStyle(Color.White, fontStyle = FontStyle.Normal, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp))
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp,0.dp,40.dp,0.dp)){
            OutlinedTextField(
                shape = RoundedCornerShape(20.dp),
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                label = { Text(text = "Username") },
                value = username.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = { username.value = it } )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp,0.dp,40.dp,0.dp)){
            OutlinedTextField(
                shape = RoundedCornerShape(20.dp),
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(50.dp),
                label = { Text(text = "Password") },
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password.value = it })

        }

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp,0.dp,40.dp,0.dp)){
            Button(
                onClick = {
                    userRepo = UserRepoImpl(prefsDataStore)
                    lifecycleScope.launch() {
                        userRepo?.setUSerData(islam("mohamed","Alinnn"))
                    }
                    lifecycleScope.launch{
                        userRepo?.getUSerData()?.collect(){isla->
                            withContext(Dispatchers.Main){
                                Log.d("islam", "ClickBtb: ${isla}")
                            }

                        }
                    }

                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(text = "Login")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text =  "forget Password", style = TextStyle(Color.White, textAlign = TextAlign.End),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp))

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp,0.dp,40.dp,0.dp)){
            Button(
                onClick = {},
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(text = "Rejester")
            }
        }
        
    }

}

@Composable
fun ScaffoldWithTopBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top App Bar")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        }, content = {
            ClickBtb()

        })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CiCdProjectOneTheme {
//        ScaffoldWithTopBar()
        ClickBtb()
    }


}
}