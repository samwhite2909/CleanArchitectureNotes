package com.swhite.cleanarchitecturenotes.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swhite.cleanarchitecturenotes.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.swhite.cleanarchitecturenotes.feature_note.presentation.notes.NotesScreen
import com.swhite.cleanarchitecturenotes.feature_note.presentation.util.Screen
import com.swhite.cleanarchitecturenotes.ui.theme.CleanArchitectureNotesTheme
import dagger.hilt.android.AndroidEntryPoint

//Main activity/entry point.
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureNotesTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    //Setting up basic navigation.
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    //Creating a nav option for the notes screen.
                    ) {
                        composable(route = Screen.NotesScreen.route) {
                            NotesScreen(navController = navController)
                        }
                        //Creating a nav option for the add edit notes screen, which allows for id
                        // and color to be passed as meta data using the route.
                        composable(
                            route = Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            //Get the color from the nav arguments.
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}
