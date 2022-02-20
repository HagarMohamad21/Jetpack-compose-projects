package com.example.jectpackcomposedemo.widgets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.domain.model.Note

@Composable
fun TopBar(){  TopAppBar(title = {
    Text(text = stringResource(id = R.string.app_name))
},
    actions = {
        Icon(imageVector = Icons.Rounded.Notifications,
            contentDescription = "Icon")
    },
    backgroundColor = Color(0xFFDADFE3)
)
}

