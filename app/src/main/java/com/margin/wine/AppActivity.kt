package com.margin.wine

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.margin.wine.navigator.NavigationFlow
import com.margin.wine.navigator.Navigator
import com.margin.wine.navigator.ToFlowNavigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : AppCompatActivity(), ToFlowNavigate {

    private val appViewModel by viewModels<AppViewModel>()

    private val navigator by lazy { Navigator() }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*setContent {
            WineComposeTheme {
                MainScreen()
            }
        }*/

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navigator.navController = navHostFragment.navController
        navController = navHostFragment.navController

        navHostFragment.navController.currentDestination
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }

    override fun onBackPressed() {
        if (!navController.popBackStack()) {
            super.onBackPressed()
        } else {
            navController.navigateUp()
        }
    }
}


/*
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController = navController)
    }
}

@Composable
@Preview
fun PreviewMainScreen() {
    MainScreen()
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        
        composable("favorite") {
            HomeScreen()
        }
        
        composable("alarm") {
            HomeScreen()
        }
        
        composable("my") {
            HomeScreen()
        }
    }
}*/
