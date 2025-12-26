package com.example.stitch_export_jules_demo.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.stitch_export_jules_demo.ui.dashboard.DashboardScreen
import com.example.stitch_export_jules_demo.ui.onboarding.OnboardingScreen
import com.example.stitch_export_jules_demo.ui.resorts.ResortsScreen
import com.example.stitch_export_jules_demo.ui.settings.SettingsScreen
import com.example.stitch_export_jules_demo.ui.tripdetail.TripDetailScreen

sealed class Screen(val route: String, val label: String, val icon: ImageVector? = null) {
    object Onboarding : Screen("onboarding", "Onboarding")
    object Home : Screen("home", "ホーム", Icons.Default.Home)
    object Resorts : Screen("resorts", "スキー場", Icons.Default.Landscape)
    object TripDetail : Screen("tripdetail", "記録", Icons.Default.Notes)
    object Settings : Screen("settings", "設定", Icons.Default.Settings)
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Resorts,
    Screen.TripDetail,
    Screen.Settings
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            if (currentDestination?.route != Screen.Onboarding.route) {
                NavigationBar(containerColor = Color(0xFF1c2620)) {
                    bottomNavItems.forEach { screen ->
                        NavigationBarItem(
                            icon = { screen.icon?.let { Icon(it, contentDescription = null) } },
                            label = { Text(screen.label) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color(0xFF9eb7a8),
                                selectedTextColor = Color.White,
                                unselectedTextColor = Color(0xFF9eb7a8),
                                indicatorColor = Color(0xFF1c2620)
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Onboarding.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Onboarding.route) {
                OnboardingScreen(onGetStartedClick = { navController.navigate(Screen.Home.route) })
            }
            composable(Screen.Home.route) {
                DashboardScreen()
            }
            composable(Screen.Resorts.route) {
                ResortsScreen()
            }
            composable(Screen.TripDetail.route) {
                TripDetailScreen()
            }
            composable(Screen.Settings.route) {
                SettingsScreen()
            }
        }
    }
}
