package com.example.stitch_export_jules_demo.ui.tripdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.stitch_export_jules_demo.ui.theme.StitchexportjulesdemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripDetailScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "スキートリップ",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF111714))
            )
        },
        containerColor = Color(0xFF111714)
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                AsyncImage(
                    model = "https://lh3.googleusercontent.com/aida-public/AB6AXuB9lY9ZSYo1cCncCyWzy1DRy0TOpHCt6TILb548KGJJhAkX2KTPtO0ECjqYgjKbjnmSqLXXnkULmcmQG4X8XAOjL7k3ZtB6IP4Sp1cZkPf2X3V9ctEAT1CZ-_FDPJNhRhtuVqkSFawc-xJV_nG-Av5IpU6tyDFlR-bJVQy7wCbIyv3OGTOfvcGhSGLZuYItsT7AaHGUH6I5EkGSw8WbqlTL85SSVNVuZ3Nv7Z57DL78mqCbyyO5i41Fs15nLI5tC1IG-jAYykekC8f3",
                    contentDescription = "Trip map",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16 / 9f)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                TripSectionTitle("トリップの概要")
            }
            item {
                TripDetailSection(
                    details = listOf(
                        "日付" to "2024年1月20日",
                        "時間" to "10:00 - 16:00",
                        "距離" to "15km",
                        "成功したリフト" to "5"
                    )
                )
            }
            item {
                TripSectionTitle("トリップの詳細")
            }
            item {
                TripDetailSection(
                    details = listOf(
                        "最高速度" to "60km/h",
                        "平均速度" to "30km/h",
                        "消費カロリー" to "800kcal",
                        "最大標高" to "2500m",
                        "最小標高" to "1500m"
                    )
                )
            }
        }
    }
}

@Composable
fun TripSectionTitle(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    )
}

@Composable
fun TripDetailSection(details: List<Pair<String, String>>) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        details.forEach { (label, value) ->
            TripDetailRow(label = label, value = value)
        }
    }
}

@Composable
fun TripDetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color(0xFF9eb7a8), fontSize = 14.sp)
        Text(text = value, color = Color.White, fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun TripDetailScreenPreview() {
    StitchexportjulesdemoTheme {
        TripDetailScreen()
    }
}
