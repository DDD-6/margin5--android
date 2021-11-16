/*
package com.margin.wine.ui

import com.margin.wine.R
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavController) {
	val listItems: List<HomeBottomNavigationItem> = listOf(
		HomeBottomNavigationItem.HOME,
		HomeBottomNavigationItem.FAVORITE,
		HomeBottomNavigationItem.ALARM,
		HomeBottomNavigationItem.MY
	)
	
	BottomNavigation(
		backgroundColor = colorResource(id = R.color.purple_500),
		contentColor = Color.White
	) {
		val navBackStackEntry by navController.currentBackStackEntryAsState()
		val currentRoute = navBackStackEntry?.destination?.route
		
		listItems.forEach { item ->
			BottomNavigationItem(
				icon = {
					Icon(
						imageVector = ImageVector.vectorResource(id = item.icon),
						contentDescription = null
					)
				},
				label = {
					Text(text = stringResource(id = item.label))
				},
				selectedContentColor = Color.White,
				unselectedContentColor = Color.White.copy(0.4f),
				alwaysShowLabel = true,
				selected = currentRoute == item.route,
				onClick = {
					navController.navigate(item.route) {
					
					}
				},
			)
		}
	}
}

enum class HomeBottomNavigationItem(
	@DrawableRes val icon: Int,
	@StringRes val label: Int,
	val route: String
) {
	HOME(R.drawable.ic_baseline_home_24, R.string.home, "home"),
	FAVORITE(R.drawable.ic_baseline_home_24, R.string.favorite, "favorite"),
	ALARM(R.drawable.ic_baseline_home_24, R.string.alarm, "alarm"),
	MY(R.drawable.ic_baseline_home_24, R.string.my, "my")
}*/
